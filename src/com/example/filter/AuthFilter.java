package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthFilter
 */
@WebFilter(filterName = "AuthFilter", urlPatterns = "/success")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) req).getSession(false);
        if (session == null || session.getAttribute("loginUser") == null) {
            session.invalidate();
            ((HttpServletResponse) resp).sendRedirect("/auth_sample/login");

            return;
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

}
