package edu.it.model;

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
	
	public static InputConsultaOpciones build() {
		return new InputConsultaOpciones();
	}

	public InputConsultaOpciones setTipo(String tipo) {
		this.tipo = tipo;
		return this;
	}

	public InputConsultaOpciones setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
		return this;
	}

	public InputConsultaOpciones setPrecio(String precio) {
		this.precio = precio;
		return this;
	}

	public InputConsultaOpciones setStrike(String strike) {
		this.strike = strike;
		return this;
	}

	public InputConsultaOpciones setCcl(String ccl) {
		this.ccl = ccl;
		return this;
	}
	public InputConsultaOpciones listo() {
		return this;
	}
}
