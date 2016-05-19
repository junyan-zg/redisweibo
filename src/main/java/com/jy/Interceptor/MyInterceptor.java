package com.jy.Interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Handler;

/**
 * Created by Administrator on 2016/5/19.
 */
public class MyInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getSession().getAttribute("user")==null){
            response.sendRedirect(request.getContextPath()+"/index.jsp");
            return false;
        }
        return true;
    }
}
