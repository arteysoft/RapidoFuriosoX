package edu.it.model;

import javax.persistence.*;

@Entity
@Table(name="alumnos")
public class Alumno {
	@Id
    private String id;
    private String nombre;
    private String apellido;
    private String calle;
    private String calleNumero;
    private String estado;
    private String pais;
        
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCalleNumero() {
		return calleNumero;
	}

	public void setCalleNumero(String calleNumero) {
		this.calleNumero = calleNumero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Alumno() {
    }

	public Alumno(String id, String nombre, String apellido, String calle, String calleNumero, String estado,
			String pais) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.calle = calle;
		this.calleNumero = calleNumero;
		this.estado = estado;
		this.pais = pais;
	}
}
