package com.example.temp.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TemperatureServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/temp.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String type = req.getParameter("type");
        String tempStr = req.getParameter("temperature");
        try {
            double input = Double.parseDouble(tempStr);
            double result;
            if ("CtoF".equals(type)) {
                result = input * 9.0 / 5 + 32;
            } else {
                result = (input - 32) * 5.0 / 9;
            }
            req.setAttribute("result", String.format("%.2f", result));
            req.setAttribute("type", type);
        } catch (NumberFormatException e) {
            req.setAttribute("error", "Giá trị nhiệt độ không hợp lệ!");
        }
        req.getRequestDispatcher("/temp.jsp").forward(req, resp);
    }
}