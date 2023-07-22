package edu.it.javaweb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import edu.it.javaweb.components.BlackScholes;
import edu.it.javaweb.components.Constantes;
import edu.it.javaweb.model.Alumno;
import edu.it.javaweb.model.InputConsultaOpciones;
import edu.it.javaweb.model.PrecioVolatilidad;
import utiles.Calculadora;

@RestController
@RequestMapping("/api/opciones")
public class OpcionesController {
	@GetMapping
	public String calcularConUrlString() {
		return "hola";
	}
	
	@PostMapping
	public List<PrecioVolatilidad> calcularOpcionesPost(@RequestBody InputConsultaOpciones inputConsultaOpciones) {
		System.out.println(new Gson().toJson(inputConsultaOpciones));
		return Calculadora.calcular(inputConsultaOpciones);
	}
}
