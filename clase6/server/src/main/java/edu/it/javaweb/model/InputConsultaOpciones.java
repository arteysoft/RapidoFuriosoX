package edu.it.javaweb.model;

public class InputConsultaOpciones {
	public String tipo;
	public String vencimiento;
	public String precio;
	public String strike;
	public String ccl;
	
	public InputConsultaOpciones(String tipo, String vencimiento, String precio, String strike, String ccl) {
		this.tipo = tipo;
		this.vencimiento = vencimiento;
		this.precio = precio;
		this.strike = strike;
		this.ccl = ccl;
	}

	public InputConsultaOpciones() {
	}
}
