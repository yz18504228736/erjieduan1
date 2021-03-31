package com.canguanwang.demo.filter;

import com.canguanwang.demo.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyFilter implements Filter {

    @SuppressWarnings("unused")
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
        System.out.println("MyFilter init, filterConfig="+filterConfig);
        System.out.println("myParam="+filterConfig.getInitParameter("myParam"));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("MyFilter doFilter before");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        User user = (User) req.getSession().getAttribute("admin");
        if (user == null) {
            req.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        }
        chain.doFilter(request, response);

        System.out.println("MyFilter doFilter after");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter destroy");
    }

}