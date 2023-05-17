package com.joolshe.chargesys.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Zexi He.
 * @date 2023/5/17 13:53
 * @description:
 */

@Slf4j
@Component
public class AuthorizeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        log.info("preHandle 拦截器拦截的请求路径是:{}", uri);

        // 设置响应头允许跨域访问
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "*");

        HttpSession session = request.getSession();
        Object loginAdmin = session.getAttribute("loginAdmin");
        if (loginAdmin != null) {
            //放行
            return true;
        } else {
            //拦截,返回登录页面
//            response.sendRedirect("/");

            //TODO  intercept unauthorized requests
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("AuthorizeInterceptor --- postHandle 方法被执行");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("AuthorizeInterceptor --- afterCompletion 方法被执行");
    }
}
