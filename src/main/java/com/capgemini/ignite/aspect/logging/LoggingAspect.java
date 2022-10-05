package com.capgemini.ignite.aspect.logging;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LoggingAspect {


    @Before("com.capgemini.ignite.aspect.logging.SystemArchitecture.controller()")
    public void beforeExecutionOfControllerMethod(JoinPoint joinPoint) {
        log.info(
            "Enter: {}.{}() with argument[s] = {}",
            joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(),
            Arrays.toString(joinPoint.getArgs()));
    }

    @Before("com.capgemini.ignite.aspect.logging.SystemArchitecture.service()")
    public void beforeExecutionOfServiceMethod(JoinPoint joinPoint) {
        log.info(
            "Enter: {}.{}() with argument[s] = {}",
            joinPoint.getSignature().getDeclaringTypeName(),
            joinPoint.getSignature().getName(),
            Arrays.toString(joinPoint.getArgs()));
    }
}
