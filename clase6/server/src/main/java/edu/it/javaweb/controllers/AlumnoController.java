package edu.it.javaweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import edu.it.javaweb.components.ConectorJPA;
import edu.it.javaweb.components.Utiles;
import edu.it.javaweb.errores.BadRequestException;
import edu.it.javaweb.errores.NotFoundException;
import edu.it.javaweb.model.Alumno;

@RestController
@RequestMapping("/api/alumno")
public class AlumnoController {
	@GetMapping(path="/inventar")
	public Alumno generarAlumnoRandom() {
		return Utiles.generarAlumnoRandom();
	}
	
	@GetMapping(path="/{id}")
	public Alumno obtenerUnAlumnoPorId(@PathVariable("id") String id) {
		var conectorJPA = new ConectorJPA();
		var em = conectorJPA.getEntityManager(); // EntityManager				
		var query = em.createQuery("FROM Alumno a where id = :idParam", Alumno.class);
		query.setParameter("idParam", id);
		var resultado = query.getResultList();
		if (resultado.size() == 0) {
			throw new NotFoundException();
		}		
		
		var alu = resultado.get(0);
		em.close();
		
		return alu;
	}
	
	@GetMapping
	public List<Alumno> obtenerAlumnosPorFiltro(
									@RequestParam(value = "nombre" ,required = false) String nombre, 
									@RequestParam(value = "estado", required = true) String estado) {
		
		StringBuilder strSQL = new StringBuilder("FROM Alumno a WHERE estado = :estadoParam ");
		if (nombre != null) {
			strSQL.append("AND nombre = :nombreParam");
		}
		
		var conectorJPA = new ConectorJPA();
		var em = conectorJPA.getEntityManager(); // EntityManager				
		var query = em.createQuery(strSQL.toString(), Alumno.class);
		query.setParameter("estadoParam", estado);
		
		if (nombre != null) {
			query.setParameter("nombreParam", nombre);
		}
		
		var resultado = query.getResultList();
		em.close();
		
		return resultado;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void agregarAlumno(@RequestBody Alumno alumno) {
		var conectorJPA = new ConectorJPA();
		var em = conectorJPA.getEntityManager();
		var tx = em.getTransaction();
		tx.begin();
		em.merge(alumno);
		tx.commit();
		em.close();
	}
	
	@PutMapping(path="/{id}")
	public void modificarAlumno(
						@RequestBody Alumno alumno, 
						@PathVariable("id") String id) {
		
		if (id.equals(alumno.getId())==false) {
			throw new BadRequestException();
		}
		
		agregarAlumno(alumno);
	}
	
	@DeleteMapping(path="/{id}")
	public void borrarAlumno(@PathVariable("id") String id) {
		System.out.println("BORRAR EL ALUMNO CON ID " + id);
	}
}
