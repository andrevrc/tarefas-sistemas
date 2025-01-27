package com.andrevrc.security;

import java.io.IOException;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;

public class AuthFilter extends GenericFilterBean{
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain filter)
            throws IOException, ServletException {
        var auth = SecUtils.getAuthentication((HttpServletRequest) req);
        SecurityContextHolder.getContext().setAuthentication(auth);
        filter.doFilter(req, res);
    }
}
