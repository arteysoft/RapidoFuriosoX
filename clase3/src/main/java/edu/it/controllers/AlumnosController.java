package edu.it.controllers;

import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.it.components.ConectorJPA;
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
            
            String pathInfo = request.getPathInfo();
            var idAlumno = pathInfo.replace("/", "");
            
            {
				// Persistir en una base de datos
				var conectorJPA = new ConectorJPA();
				var em = conectorJPA.getEntityManager(); // EntityManager				
				var query = em.createQuery("FROM Alumno a where id = :idParam", Alumno.class);
				query.setParameter("idParam", idAlumno);
				var resultado = query.getResultList();
				if (resultado.size() == 0) {
					// Responder 404 NOT Found
					response.setStatus(404);
					out.println("");
				}
				else {
					var alu = resultado.get(0);
					var strAlu = new Gson().toJson(alu);
					out.println(strAlu);
					response.setStatus(200);
				}
			}
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
    				
    				{
    					// Persistir en una base de datos
    					var conectorJPA = new ConectorJPA();
    					var em = conectorJPA.getEntityManager(); // EntityManager
    					var tx = em.getTransaction(); // EntityTransaction
    					tx.begin();
    					em.persist(alumno);
    					tx.commit();
    				}
    				
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
    public void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    	
    	try {
			response.setStatus(200);    	
    	}
		catch (Exception ex) {
			response.setStatus(200);
		}
    }
}
