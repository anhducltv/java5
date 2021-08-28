package edu.poly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import edu.poly.interceptors.AdminInterceptor;
import edu.poly.interceptors.AuthenticateInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
	@Autowired
	AuthenticateInterceptor authInterceptor;
	
	@Autowired
	AdminInterceptor adminInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authInterceptor)
		.addPathPatterns("/admin/**")
		.excludePathPatterns("/login");
	
		registry.addInterceptor(adminInterceptor).addPathPatterns("/admin/**").excludePathPatterns("/member/search-and-page");
	
	
	}
}
