package edu.it.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.Gson;

import edu.it.components.ConectorJPA;
import edu.it.errores.HTTP400BadRequest;
import edu.it.errores.HTTP404NotFound;
import edu.it.errores.HTTPErrorCode;
import edu.it.model.Alumno;
import edu.it.model.Usuario;
import edu.it.model.UsuarioPasswordDTO;
import edu.it.utiles.JWTUtil;
import edu.it.utiles.Utiles;

public class LoginController extends HttpServlet {
	private void verificarUsuario(String usuario, String passwordEnClear) {
		var em = new ConectorJPA().getEntityManager();
		var qr = em.createQuery("FROM Usuario u where u.nombreUsuario = :nomusu", Usuario.class);
		qr.setParameter("nomusu", usuario);
		
		var lista = qr.getResultList();
		
		if (lista.size() == 0) {
			throw new HTTP404NotFound();
		}
		
		var usuEncontrado = lista.get(0);
		
		System.out.println("Encontrado !!!");
		System.out.println(usuEncontrado.nombreUsuario);
		System.out.println(usuEncontrado.passwordEncriptada);
		var passwordEncriptada = DigestUtils.sha256Hex(passwordEnClear + usuEncontrado.salt);
		System.out.println(passwordEncriptada);
		
		if (passwordEncriptada.equals(usuEncontrado.passwordEncriptada)) {
			System.out.println("Son iguales");
		}
		else {
			throw new HTTP400BadRequest();
		}
		
		/* 
		 * El ejercicio es:
		 * Identificar si el usuario es valido o no. y mostrar el resultado por pantalla
		 * 
		 */
		
		em.close();
		
		// Si llego hasta aca ? generar el TOKEN con la libreria
		JWTUtil.crearJWT("aca va el id usuario");
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
    		
			UsuarioPasswordDTO usuario = null;
    	
    		try {
    				var strInput = Utiles.leerInputTCP(request);    				
    				System.out.println(strInput);
    				
    				try {
    					usuario = new Gson().fromJson(strInput, UsuarioPasswordDTO.class);
    				}
    				catch (Exception ex) {
    					throw new HTTP400BadRequest();
    				}    				
    				
    				verificarUsuario(usuario.usuario, usuario.password);
    				System.out.println("Son iguales");
    				
    				PrintWriter out = response.getWriter();
    				out.println("{\"token\":\"holis\"}");
					
    		}
    		catch (HTTPErrorCode ex) {
            	response.setStatus(ex.getErrorCode());            	
            }
    		catch (Exception ex) {
    			response.setStatus(500);
    		}
    }
}
