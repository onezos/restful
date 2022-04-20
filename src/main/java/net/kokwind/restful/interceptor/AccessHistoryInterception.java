package net.kokwind.restful.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AccessHistoryInterception implements HandlerInterceptor {
    //用户请求拦截，分析用户信息，记录用户访问记录
    private Logger logger = LoggerFactory.getLogger(AccessHistoryInterception.class);

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //控制log输出内容
        StringBuilder log = new StringBuilder();
        //获取用户的IP地址
        log.append(request.getRemoteAddr());
        //分割线
        log.append("|");
        //获取用户的浏览器信息
        log.append(request.getHeader("User-Agent"));
        //分割线
        log.append("|");
        //获取用户的请求URL
        log.append(request.getRequestURL());
        logger.info(log.toString());
        return true;
    }

}
