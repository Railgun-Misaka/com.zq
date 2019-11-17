package com.zq.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class WebInterceptor extends HandlerInterceptorAdapter {
	
	Logger logger = Logger.getLogger(WebInterceptor.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request,    
            HttpServletResponse response, Object handler) throws Exception {
		logger.info("method = " + request.getMethod());
		logger.info("url = " + request.getRequestURI());
        return true;
         
    } 
    
	@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,    
            ModelAndView modelAndView) throws Exception {  
    }  
    
	@Override
    public void afterCompletion(HttpServletRequest request,    
            HttpServletResponse response, Object handler, Exception ex) throws Exception { 
		
    }  
}
