package com.kodilla.patterns2.observer.homework.aop;

import com.kodilla.patterns2.observer.homework.Task;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WatcherKodillaCourse {

    public static final Logger LOGGER = LoggerFactory.getLogger(WatcherKodillaCourse.class);

    @Before(value = "execution(* com.kodilla.patterns2.observer.homework.KodillaCourse.addTask(..))" + " && target(object) && args(task) ", argNames = "task, object")
    public void logEvent(Task task, Object object) {
        LOGGER.info(object + ": Adding task: " + task + " -> to list.");
    }

    @Around(value = "execution(* com.kodilla.patterns2.observer.homework.KodillaCourse.addTask(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long begin = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed to execute 'addTask(..)' = " + (end - begin) + "ms");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }
}
