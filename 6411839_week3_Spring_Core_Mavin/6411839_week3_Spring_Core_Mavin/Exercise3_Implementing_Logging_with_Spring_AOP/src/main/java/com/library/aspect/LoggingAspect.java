package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Around("execution(* com.library.service.*.*(..))") // adjust package as per your structure
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object result = joinPoint.proceed(); // proceed to the actual method

        long endTime = System.currentTimeMillis();
        String methodName = joinPoint.getSignature().toShortString();

        System.out.println(methodName + " executed in " + (endTime - startTime) + " ms");

        return result;
    }
}
