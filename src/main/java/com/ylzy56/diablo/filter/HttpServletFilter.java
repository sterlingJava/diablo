package com.ylzy56.diablo.filter;


import com.alibaba.fastjson.JSON;
import com.ylzy56.diablo.common.utils.ParameterRequestWrapper;
import com.ylzy56.diablo.domain.UserInfo;
import com.ylzy56.diablo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.security.core.context.SecurityContextHolder;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * 过滤器
 *
 * @Author: Mr_li
 * @CreateDate: 2019-04-19 11:14
 * @Version: 1.0
 */
//@Component
@WebFilter(urlPatterns = "/*")
public class HttpServletFilter implements Filter {

    @Autowired
    private UserService userService;

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList( "/auth/login",
                    "/auth/register",
                    "/auth/refresh",
                    "/auth/login",
                    "/v2/api-docs",
                    "/swagger-resources/configuration/ui",
                    "/swagger-resources",
                    "/swagger-resources/configuration/security",
                    "/swagger-ui.html")));
    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", "");
        boolean allowedPath = ALLOWED_PATHS.contains(path);

        if (allowedPath) {
           //这里是不需要处理的url进入的方法
            chain.doFilter(req, res);
        }
        else {
            //这里是需要处理的url进入的方法
            Map<String, String[]> map = new HashMap<String, String[]>(request.getParameterMap());
            String name = SecurityContextHolder.getContext().getAuthentication().getName();
            if (!"anonymousUser".equals(name)) {
                UserInfo userInfo = userService.findByMobile(name);
                String userinfoStr = JSON.toJSONString(userInfo);
                map.put("loginUser", new String[]{userinfoStr});
            }
            ParameterRequestWrapper parameterRequestWrapper = new ParameterRequestWrapper((HttpServletRequest) request, map);
            //继续向后传递修改后的request,拦截器不能实现。
            chain.doFilter(parameterRequestWrapper, response);
        }

    }

    @Override
    public void destroy() {

    }
}
