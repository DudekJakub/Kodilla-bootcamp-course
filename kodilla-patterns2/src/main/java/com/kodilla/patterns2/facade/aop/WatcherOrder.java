package com.kodilla.patterns2.facade.aop;

import com.kodilla.patterns2.facade.api.OrderDto;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WatcherOrder {

    private static final Logger LOGGER = LoggerFactory.getLogger(WatcherOrder.class);

    @Before(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))" + "&& target(object) && args(orderDto, userId)", argNames = "object, orderDto, userId")
    public void logEvent(Object object, OrderDto orderDto, Long userId) {
        LOGGER.info("Class: " + object + " for object: " + orderDto + " & userId: " + userId);
    }

    @Around(value = "execution(* com.kodilla.patterns2.facade.api.OrderFacade.processOrder(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            Long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            Long end = System.currentTimeMillis();
            LOGGER.info("Time consumed to execute task = " + (end - begin) + " ms");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}
