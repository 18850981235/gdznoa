package com.configuration;

import com.beans.SysUser;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author 李鹏熠
 * @create 2019/4/11 11:06
 */
//@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }



    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(getSecurityInterceptor());
        //拦截所有路径
        addInterceptor.addPathPatterns("/**");
        //排除的路径
        addInterceptor.excludePathPatterns("/error");
        addInterceptor.excludePathPatterns("/page/**");
        addInterceptor.excludePathPatterns("/findByAdminAndPassword");
        //addInterceptor.excludePathPatterns("/static/**");

    }

    private class SecurityInterceptor extends HandlerInterceptorAdapter {
        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
            response.setHeader("Access-Control-Allow-Origin", "*");
            SysUser user =  (SysUser)request.getSession().getAttribute("user");
            request.getSession().removeAttribute("login");
            if(user == null){
                request.setAttribute("login","请先登录");
                //request.getRequestDispatcher("/page/index").forward(request, response);
                //request.getRequestDispatcher("").forward(request,response);
                request.getSession().setAttribute("login","请先登录");
                response.sendRedirect("/page/index");
                return false;
            }else
                return true;
        }
    }
}