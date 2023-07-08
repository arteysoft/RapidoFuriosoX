package edu.it;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.it.components.ConectorJPA;
import edu.it.entities.Usuario;
import edu.it.utiles.JWTUtil;

@SpringBootApplication
public class Main {
	
	public static void main(String[] args) {
		System.out.println("Creacion y validacion de token");
		
		var jwt = JWTUtil.crearJWT("123456");
		System.out.println(jwt);
		
		var key = JWTUtil.obtenerKey(jwt, "sub");
		System.out.println(key);
		try {
			Thread.sleep(1050);
			JWTUtil.validarToken(jwt);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
