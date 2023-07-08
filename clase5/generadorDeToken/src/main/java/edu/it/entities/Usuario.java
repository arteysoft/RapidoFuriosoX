package edu.it.entities;

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
}
