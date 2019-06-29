package com.zyt.myblog.backend.config;

import com.zyt.myblog.backend.interceptor.BackendInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    BackendInterceptor backendInterceptor() {
        return new BackendInterceptor ();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor (new BackendInterceptor ()).addPathPatterns ("/**").excludePathPatterns ("/static").excludePathPatterns ("/login");
    }
}
