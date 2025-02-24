package com.example.DependencyInjection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeMonitorAspect {
    @Around("@annotation(TimeMonitor)")
    public void logTime(ProceedingJoinPoint jointPoint){
        long start=System.currentTimeMillis();
        try{
            jointPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        finally {
            long end=System.currentTimeMillis();
            long totalTimeTaken=end-start;
            System.out.println("Total Time Taken to execute : " +totalTimeTaken);
        }

    }
}
