package com.zq.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zq.interceptor.WebInterceptor;

@Configuration
public class WebConfigurer implements WebMvcConfigurer {

	@Autowired WebInterceptor webInterceptor ;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		//addPathPatterns 用来设置拦截路径，excludePathPatterns 用来设置白名单，也就是不需要触发这个拦截器的路径。
		registry.addInterceptor(webInterceptor).addPathPatterns("/**");
		
	}
	
	@Override
	public void configurePathMatch(PathMatchConfigurer configurer) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Validator getValidator() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public MessageCodesResolver getMessageCodesResolver() {
		// TODO 自动生成的方法存根
		return null;
	}

}
