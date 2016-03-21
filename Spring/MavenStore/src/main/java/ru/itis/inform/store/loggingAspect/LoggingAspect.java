package ru.itis.inform.store.loggingAspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @After("execution( * ru.itis.inform.store.services.StoreServiceImpl.*(..))")
    public void logMethodExecution(JoinPoint jp) {
        System.out.println("AOP logging -> "
                + jp.toShortString() );
    }
}
