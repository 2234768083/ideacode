package com.nuc.edu.cn.chap04_2113042727.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Interceptor1 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {
// TODO Auto-generated method stub
        System.out.println("处理器前方法");
// 返回true，不会拦截后续的处理
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler,
                           ModelAndView modelAndView) throws Exception {
// TODO Auto-generated method stub
        System.out.println("处理器后方法");
    }
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
// TODO Auto-generated method stub
        System.out.println("处理器完成方法");
    }
}
