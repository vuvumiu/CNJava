package com.example.temp.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/convert")
public class TempFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Không cần init đặc biệt
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        // Nếu là GET, bỏ qua validation
        if ("GET".equalsIgnoreCase(req.getMethod())) {
            chain.doFilter(request, response);
            return;
        }

        // Chỉ validate khi POST
        String tempStr = request.getParameter("temperature");
        try {
            Double.parseDouble(tempStr);
            chain.doFilter(request, response);
        } catch (NumberFormatException | NullPointerException e) {
            request.setAttribute("error", "Giá trị nhiệt độ không hợp lệ!");
            request.getRequestDispatcher("/temp.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
        // Không cần cleanup
    }
}
