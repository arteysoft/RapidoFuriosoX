package edu.it.controllers;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;

public class AlumnosController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("<h1>Hora Actual: ");
            out.println(System.currentTimeMillis());
            out.println("</h1>");
            response.setStatus(200);
    }
}
