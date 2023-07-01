package edu.it.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.it.components.ConectorJPA;
import edu.it.errores.HTTPErrorCode;
import edu.it.model.Alumno;

public class AlumnosController2 extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws IOException, ServletException {
				
				System.out.println("Instanciando AlumnosController2");
		
	            response.setContentType("Application/json");
	            PrintWriter out = response.getWriter();
	            
	            try 
	            {
					var conectorJPA = new ConectorJPA();
					var em = conectorJPA.getEntityManager(); // EntityManager				
					var query = em.createQuery("FROM Alumno a", Alumno.class);
					// query.setParameter("idParam", idAlumno);
					var resultado = query.getResultList();
					var strAlu = new Gson().toJson(resultado);
					out.println(strAlu);
					response.setStatus(200);
					
				}
	            catch (HTTPErrorCode ex) {
	            	response.setStatus(ex.getErrorCode());            	
	            }
	            catch (Exception ex) {
	            	response.setStatus(500);
	            }
	    }
}
