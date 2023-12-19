package com.mongodb.config;

import com.mongodb.pojo.LogBean;
import com.mongodb.utils.CommonUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * MongoDB日志切面
 * 通过AOP实现在指定Controller方法执行后将日志信息存储到MongoDB。
 */
@Component
@Aspect
public class MongoDbLogAspect {

    @Autowired
    private MongoTemplate mongoTemplate;

    // 定义切点，指定哪些方法需要被执行AOP
    @Pointcut("execution(* com.mongodb.controller.*.*(..))")
    public void logPointCut() {
    }

    // 返回后通知，表示在logPointCut()切点返回后执行
    @AfterReturning(value = "logPointCut()", returning = "rtv")
    // JoinPoint是连接点的意思，用于获取类名、方法名、请求参数等信息
    public void afterLog(JoinPoint joinpoint, Object rtv) {

        // 创建日志实体
        LogBean logBean = new LogBean();

        // 获取类名
        String className = joinpoint.getTarget().getClass().getSimpleName();
        // 获取方法名
        String methodName = joinpoint.getSignature().getName();

        // 获取请求参数（暂时为空字符串，你可能需要从HttpServletRequest中获取实际请求参数）
        String requestParam = "";
        logBean.setClassName(className);
        logBean.setMethod(methodName);
        logBean.setResponseResults(requestParam);
        logBean.setCreateDate(new Date());

        // 设置返回值
        if (rtv != null) {
            logBean.setResponseResults(rtv.toString());
        }

        // 获取request对象
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String requestURI = request.getRequestURI();
        logBean.setRequestURI(requestURI);

        // 获取IP地址
        String ip = CommonUtils.getUserIP(request);
        logBean.setIp(ip);

        // 保存日志到MongoDB
        mongoTemplate.save(logBean);
        System.out.println("日志存储中");
    }
}
