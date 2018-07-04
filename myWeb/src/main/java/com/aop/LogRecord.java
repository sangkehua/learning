package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;


/**
 * 日志打印
 *
 * @author
 * @create 2017-11-21 15:23
 **/
@Order(1)
@Component
@Aspect
public class LogRecord {
    //日志管理
    private Logger logger;

    //切点表达式
    @Pointcut("execution(* com.service.*.*.*(..))")
    public void declareJoinPointExpression() {
    }
    //前置通知
    @Before("declareJoinPointExpression()")
    public void beforeLogging(JoinPoint joinPoint) {
        logger = LoggerFactory.getLogger(joinPoint.getClass());
        logger.info(joinPoint.getSignature().getName() + " Start,参数为：" + Arrays.asList(joinPoint.getArgs()));
    }
    //后置通知
    @After("declareJoinPointExpression()")
    public void afterLogging(JoinPoint joinPoint) {
        logger = LoggerFactory.getLogger(joinPoint.getClass());
        logger.info(joinPoint.getSignature().getName() + " End ");
    }
    //返回通知
    @AfterReturning(value = "declareJoinPointExpression()", returning = "result")
    public void afterReturnLogging(JoinPoint joinPoint, Object result) {
        logger = LoggerFactory.getLogger(joinPoint.getClass());
        logger.info(joinPoint.getSignature().getName() + " Result :" + result);
    }
    //异常通知
    @AfterThrowing(value = "declareJoinPointExpression()", throwing = "e")
    public void afterThrowLogging(JoinPoint joinPoint, Exception e) {
        logger = LoggerFactory.getLogger(joinPoint.getClass());
        logger.info(joinPoint.getSignature().getName() + "Error :" + e);
    }
    //环绕通知
    @Around("declareJoinPointExpression()")
    public Object aroundLogging(ProceedingJoinPoint joinPoint) {
        logger = LoggerFactory.getLogger(joinPoint.getClass());
        Object result = null;
        try {
            logger.info(joinPoint.getSignature().getName() + " Start,参数为：" + Arrays.asList(joinPoint.getArgs()));
            result = joinPoint.proceed();
            logger.info(joinPoint.getSignature().getName() + " Result :" + result);
        } catch (Throwable throwable) {
            logger.info(joinPoint.getSignature().getName() + "Error :" + throwable);
            throwable.printStackTrace();
        }
        logger.info(joinPoint.getSignature().getName() + " End ");
        return result;
    }
}
