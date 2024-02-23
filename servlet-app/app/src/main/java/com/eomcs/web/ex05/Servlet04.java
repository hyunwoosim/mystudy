package com.eomcs.web.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05/s4")
public class Servlet04 extends MyHttpServlet2 {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("text/plain;charset=UTP-8");
        PrintWriter out = response.getWriter();
        out.println("GET 요청입니다.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/plain;charset=UTP-8");
        PrintWriter out = response.getWriter();
        out.println("POST 요청입니다.");
    }
}