package edu.it.controllers;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.it.components.Utiles;
import edu.it.model.Alumno;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
            
            var alumno = new Alumno[] {Utiles.generarAlumnoRandom(), Utiles.generarAlumnoRandom(), Utiles.generarAlumnoRandom()};
            var alumnoJson = new Gson().toJson(alumno);
            
            out.print(alumnoJson);
            
            response.setStatus(200);
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    		
    		try {
    				var isreader = new InputStreamReader(request.getInputStream());
    				var buffReader = new BufferedReader(isreader);
    				
    				StringBuilder strBld = new StringBuilder();
    				
    				for (String linea = buffReader.readLine();linea != null;linea = buffReader.readLine()) {
    					strBld.append(linea);
    				}
    				
    				System.out.println(strBld.toString());
    				
    				var alumno = new Gson().fromJson(strBld.toString(), Alumno.class);
    				
    				// Como ponemos esto en una base de datos MySQL
    				
    				response.setStatus(201);
    		}
    		catch (Exception ex) {
    			response.setStatus(500);
    		}
    }
    public void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    		
    		try {
    				var isreader = new InputStreamReader(request.getInputStream());
    				var buffReader = new BufferedReader(isreader);
    				
    				StringBuilder strBld = new StringBuilder();
    				
    				for (String linea = buffReader.readLine();linea != null;linea = buffReader.readLine()) {
    					strBld.append(linea);
    				}
    				
    				System.out.println(strBld.toString());
    				
    				var alumno = new Gson().fromJson(strBld.toString(), Alumno.class);
    				
    				// Como ponemos esto en una base de datos MySQL
    				
    				response.setStatus(200);
    		}
    		catch (Exception ex) {
    			response.setStatus(500);
    		}
    }
    
    
}
