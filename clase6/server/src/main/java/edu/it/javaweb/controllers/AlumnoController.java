package edu.it.javaweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import edu.it.javaweb.components.Utiles;
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
		System.out.println(id);
		return generarAlumnoRandom();
	}
	
	@GetMapping
	public List<Alumno> obtenerAlumnosPorFiltro(
									@RequestParam("nombre") String nombre, 
									@RequestParam("estado") String estado) {
		
		System.out.println("parametro nombre");
		System.out.println(nombre);
		System.out.println("parametro estado");
		System.out.println(estado);
		
		return new ArrayList<Alumno>();
	}

	@PostMapping
	public void agregarAlumno(@RequestBody Alumno alumno) {
		System.out.println("Persistir este alumno en la base de datos");
		System.out.println(new Gson().toJson(alumno));
	}
	
	@PutMapping(path="/{id}")
	public void modificarAlumno(
						@RequestBody Alumno alumno, 
						@PathVariable("id") String id) {
		
		System.out.println("Persistir este alumno en la base de datos UPDATE");
		System.out.println("Con el id: " + id);
	}
	
	@DeleteMapping(path="/{id}")
	public void borrarAlumno(@PathVariable("id") String id) {
		System.out.println("BORRAR EL ALUMNO CON ID " + id);
	}
}
