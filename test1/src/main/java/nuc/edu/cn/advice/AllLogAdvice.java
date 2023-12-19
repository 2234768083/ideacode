package nuc.edu.cn.advice;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class AllLogAdvice {

    @Pointcut("execution(* nuc.edu.cn.service.IProductService.*(..))")

    private void allMethod() {

    }


    @Before("allMethod()")
    public void myBeforeAdvice(JoinPoint joinPoint) {

        List<Object> args = Arrays.asList(joinPoint.getArgs());

        String loginInfoText = "前置通知:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "  "
                + args.get(0).toString() + "  浏览商品： " + args.get(1).toString();

        System.out.println(loginInfoText);
    }


    @After("allMethod()")
    public void myAfterAdvice(JoinPoint joinPoint) {

        List<Object> args = Arrays.asList(joinPoint.getArgs());

        String loginInfoText = "后置通知:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "  "
                + args.get(0).toString() + "  浏览商品： " + args.get(1).toString();

        System.out.println(loginInfoText);
    }


    @AfterReturning("allMethod()")
    public void myAfterReturnAdvice(JoinPoint joinPoint) {

        List<Object> args = Arrays.asList(joinPoint.getArgs());

        String loginInfoText = "返回通知:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "  "
                + args.get(0).toString() + "  浏览商品： " + args.get(1).toString();

        System.out.println(loginInfoText);
    }


    @AfterThrowing(pointcut = "allMethod()", throwing = "e")
    public void myThrowingAdvice(JoinPoint joinPoint, Exception e) {

        String targetClassName = joinPoint.getTarget().getClass().getName();

        String targetMethodName = joinPoint.getSignature().getName();

        String loginInfoText = "异常通知 ִ调用" + targetClassName + " 类 " + targetMethodName + "  方法发生异常 ";

        System.out.println(loginInfoText);
    }


    @Around("allMethod()")
    public void myAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();
        joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        String targetMethodName = joinPoint.getSignature().getName();

        String loginInfoText = "环绕通知: " + targetMethodName + "方法被调用时间" + beginTime + "毫秒, " + " 执行完成时间  " + endTime
                + "毫秒. ";

        System.out.println(loginInfoText);
    }

}
