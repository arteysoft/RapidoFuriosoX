package edu.it;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.it.components.ConectorJPA;
import edu.it.entities.Usuario;

@SpringBootApplication
public class Main {
	public static void crearUsuario() {
		var em = new ConectorJPA().getEntityManager();
		var tx = em.getTransaction();
		tx.begin();
		
		var usuario = new Usuario();
		
		usuario.id = UUID.randomUUID().toString();
		usuario.nombreUsuario = "max";
		var passwordEnClear = "max33RedBull";
		usuario.salt = String.join(UUID.randomUUID().toString(), UUID.randomUUID().toString());
		usuario.passwordEncriptada = DigestUtils.sha256Hex(passwordEnClear + usuario.salt);
		
		em.persist(usuario);		
		tx.commit();
		em.close();
	}
	public static void verificarUsuario(String usuario, String passwordEnClear) {
		var em = new ConectorJPA().getEntityManager();
		var qr = em.createQuery("FROM Usuario u where u.nombreUsuario = :nomusu", Usuario.class);
		qr.setParameter("nomusu", usuario);
		
		var lista = qr.getResultList();
		
		if (lista.size() == 0) {
			throw new RuntimeException("Guarda que no hay nada con ese nombre en la tabla");
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
			System.out.println("Difieren");
		}
		
		/* 
		 * El ejercicio es:
		 * Identificar si el usuario es valido o no. y mostrar el resultado por pantalla
		 * 
		 */
		
		em.close();
	}
	public static void main(String[] args) {
		System.out.println("Creacion de usuarios");
		
		// crearUsuario();
		verificarUsuario("max", "max33RedBul0");
	}
}
