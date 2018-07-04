package com.aop_xml;

import org.aopalliance.aop.Advice;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;


/**
 * 日志打印
 *
 * @author
 * @create 2017-11-21 15:23
 **/
public class LogRecord implements Advice {

    /**
     *  如果使用aop:advisor配置,那么切面逻辑必须要实现advice接口才行!否则会失败!
     */
    //日志管理
    private Logger logger;

    //前置通知
    public void beforeLogging(JoinPoint joinPoint) {
        logger = LoggerFactory.getLogger(joinPoint.getClass());
        logger.info(joinPoint.getSignature().getName() + " Start,参数为：" + Arrays.asList(joinPoint.getArgs()));
    }
    //后置通知
    public void afterLogging(JoinPoint joinPoint) {
        logger = LoggerFactory.getLogger(joinPoint.getClass());
        logger.info(joinPoint.getSignature().getName() + " End ");
    }
    //返回通知
    public void afterReturnLogging(JoinPoint joinPoint, Object result) {
        logger = LoggerFactory.getLogger(joinPoint.getClass());
        logger.info(joinPoint.getSignature().getName() + " Result :" + result);
    }
    //异常通知
    public void afterThrowLogging(JoinPoint joinPoint, Exception e) {
        logger = LoggerFactory.getLogger(joinPoint.getClass());
        logger.info(joinPoint.getSignature().getName() + "Error :" + e);
    }
    //环绕通知
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
