package edu.it.controllers;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.it.components.Utiles;

import java.io.IOException;
import javax.servlet.ServletException;

public class AlumnosController extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
            response.setContentType("Application/json");
            PrintWriter out = response.getWriter();
            
            /*
             * Van a generar 5 alumnos, los ponene en un array o ArrayList
             * Luego lo mismo, lo transforman a Json
             */
            
            var alumno = Utiles.generarAlumnoRandom();
            var alumnoJson = new Gson().toJson(alumno);
            
            out.print(alumnoJson);
            
            response.setStatus(200);
    }
}
