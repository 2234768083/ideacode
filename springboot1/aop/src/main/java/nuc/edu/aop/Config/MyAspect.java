package nuc.edu.aop.Config;


import nuc.edu.aop.Entity.User;
import nuc.edu.aop.validator.UserValidator;
import nuc.edu.aop.validator.impl.UserValidatorImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author hongjun
 * @create 2020-09-16 7:41
 * • execution 表示在执行的时候，拦截里面的正则匹配的方法： . ＊表示任意返回类型的方法：
 * • nuc.edu.aop.Service.Impl.UserServiceImpl指定目标对象的全限定名称：
 * • printUser 指定目标对象的方法：
 * • （..）表示任意参数进行匹配。
 *     @DeclareParents(value = "nuc.edu.aop.Service.Impl.UserServiceImpl+", defaultImpl = UserValidatorImpl.class)
 *     public UserValidator userValidator;
 *       //切点
 *     /*@Pointcut("execution(* nuc.edu.aop.Service.Impl.UserServiceImpl.printUser(..))")
 *     public void pointCut(){
 *
 *     }
 *      @Before("poit()&&args(user)")
 *         public void before(JoinPoint joinPoint, User user) {
 *             Object[] args=joinPoint.getArgs();
 *             for(int i=0;i<args.length;i++){
 *                 System.out.println(args[i]);
 *             }
 *             System.out.println("before...");
 *         }
 *
 *     */

@Aspect
public class MyAspect {
    @Pointcut("execution(* nuc.edu.aop.Service.Impl.UserServiceImpl.printUser(..))")
   public void pointCut(){

    }
    /*@Before("pointCut()&&args(user)")
         public void before(JoinPoint joinPoint, User user) {
              Object[] args=joinPoint.getArgs();
              for(int i=0;i<args.length;i++){
                  System.out.println(args[i]);
              }
              System.out.println("before...");
          }*/
    @Before("pointCut()")
    public void before() {
        System.out.println("before...");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after...");
    }

    @AfterReturning("execution(* nuc.edu.aop.Service.Impl.UserServiceImpl.printUser(..))")
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

   /* @AfterThrowing("poit()")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }*/




    /* @Around("execution(* nuc.edu.aop.Service.Impl.UserServiceImpl.printUser(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around before....");
        joinPoint.proceed();
        System.out.println("around after.....");
    }*/
}
