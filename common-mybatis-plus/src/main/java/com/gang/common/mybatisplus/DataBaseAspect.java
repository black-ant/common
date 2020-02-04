package com.gang.common.mybatisplus;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname DataBaseAspect
 * @Description TODO
 * @Date 2020/2/4 20:16
 * @Created by zengzg
 */
public class DataBaseAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around(value = "execution(* com.gang.etl.datacenter.dao.*.*(..))")
    public Object restAction(ProceedingJoinPoint joinPoint) throws Throwable {

        String method = "";
        String className = "";
        try {

            Object[] args = joinPoint.getArgs();

            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

            method = methodSignature.getMethod().getName();

            className = joinPoint.getTarget().getClass().getSimpleName();

            logger.info("------> DAO 操作 {} . {}--参数 ：{} <-------", className, method, args);

            Object result = joinPoint.proceed();

            logger.info("------> DAO {} success ", method);
            if (result != null) {
                String jsonresult = JSONObject.toJSONString(result);
                logger.info("------> DAO {} . {}  result :{} ", className, method, jsonresult);
            } else {
                logger.info("------> DAO {} . {}  No Result", className, method);
            }
            return result;

        } catch (Exception e) {
            logger.error("E----> DAO 操作 :{} . {} 出现异常 class :{}", className, method, e.getClass());
            logger.error("E---->  error :{} -- content :{}", e.getClass() + e.getMessage(), e);
            throw e;
        }
    }
}
