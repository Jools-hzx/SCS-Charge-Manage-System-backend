package com.joolshe.chargesys.config;

import com.joolshe.chargesys.interceptor.AuthorizeInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Zexi He.
 * @date 2023/5/17 13:59
 * @description:    注册拦截器
 */

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizeInterceptor())
                .addPathPatterns("/**") //拦截所有请求
                .excludePathPatterns("/", "/admin/login"); //放行的请求, 可以根据需要增加
    }
}
