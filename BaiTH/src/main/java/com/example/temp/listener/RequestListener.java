package com.example.temp.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class RequestListener implements ServletRequestListener {
    private static final String COUNTER = "requestCount";

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        ServletContext ctx = sre.getServletContext();
        Integer count = (Integer) ctx.getAttribute(COUNTER);
        if (count == null) count = 0;
        ctx.setAttribute(COUNTER, count + 1);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        // Không cần xử lý
    }
}