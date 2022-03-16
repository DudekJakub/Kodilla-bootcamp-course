package com.kodilla.patterns2.aop.calculator;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Aspect
@Component
public class Watcher {

    private static final Logger LOGGER = LoggerFactory.getLogger(Watcher.class);

//    @Before(value = "execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))" + "&& args(theNumber) && target(object)", argNames = "theNumber,object")
//    public void logEvent(BigDecimal theNumber, @NotNull Object object) {
//        LOGGER.info("Class: " + object.getClass().getName() + ", Args: " + theNumber);
//    }

    @Around(value = "execution(* com.kodilla.patterns2.aop.calculator.Calculator.factorial(..))")
    public Object measureTime(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long being = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Time consumed " + (end - being) + " ms");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }

    @Around(value = "execution(* com.kodilla.patterns2.aop.calculator.Calculator.add(..))")
    public Object measureTimeForAdd(final ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result;
        try {
            long being = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            long end = System.currentTimeMillis();
            LOGGER.info("Czas przeznaczony na operację dodawania = " + (end - being) + "ms");
        } catch (Throwable throwable) {
            LOGGER.error(throwable.getMessage());
            throw throwable;
        }
        return result;
    }

    @Before(value = "execution(public * com.kodilla.patterns2.aop.calculator.Calculator.add(..))"
                    + "&& args(numberA, numberB) && target(object)", argNames = "numberA,numberB,object")

    public void testAspectBefore(double numberA, double numberB, @NotNull Object object) {
        LOGGER.info("Aspekt @BEFORE -> dodawanie rozpoczęte...");
        LOGGER.info("Użyte argumenty w metodzie ADD to -> liczba pierwsza: " + numberA + " plus liczba druga: " + numberB +
                    ". Lokalizacja metody ADD: " + object.getClass().getName());
    }

    @After(value = "execution(public * com.kodilla.patterns2.aop.calculator.Calculator.add(..))")
    public void testAspectAfter() {
        LOGGER.info("Aspekt @AFTER -> dodawanie zakończone!");
    }
}
