package com.ylzy56.diablo.configuration;

import com.ylzy56.diablo.interceptor.SecurityInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MVCConfig extends WebMvcConfigurerAdapter {
    @Bean
    public SecurityInterceptor securityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(securityInterceptor()).excludePathPatterns("/static/*")
                .excludePathPatterns("/error").addPathPatterns("/**");
    }

}
