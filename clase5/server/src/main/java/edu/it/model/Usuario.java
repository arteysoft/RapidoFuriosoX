package edu.it.model;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	public String id;
	@Column(name="nombre_usuario")
	public String nombreUsuario;
	@Column(name="password_encriptada")
	public String passwordEncriptada;
	public String salt;
	public String token;
	public String refresh_token;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getPasswordEncriptada() {
		return passwordEncriptada;
	}
	public void setPasswordEncriptada(String passwordEncriptada) {
		this.passwordEncriptada = passwordEncriptada;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
    
    
}
