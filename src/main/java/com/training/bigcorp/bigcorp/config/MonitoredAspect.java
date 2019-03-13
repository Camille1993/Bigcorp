package com.training.bigcorp.bigcorp.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MonitoredAspect {
    private final static Logger logger = LoggerFactory.getLogger(MonitoredAspect.class);
    @Before("@annotation(Monitored)")
    public void logServiceBeforeCall(JoinPoint jp){
        logger.info("Appel finder "+jp.getSignature());
    }
    @AfterReturning(pointcut = "@annotation(Monitored)", returning = "element")
    public void logServiceAfterCall(JoinPoint jp, Object element){
        if(element ==null){
            logger.info("\n"+"Appel Finder " + jp.getTarget()+ "returns null");
        }else {
            logger.info("\n"+"Appel Finder " +jp.getTarget()+ "returns" + element.toString());
        }
    }
}
