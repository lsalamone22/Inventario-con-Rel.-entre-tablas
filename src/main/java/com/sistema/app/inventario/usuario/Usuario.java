package com.sistema.app.inventario.usuario;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String email;

	@Column(length = 10, nullable = false)
	private String password;

	@ManyToMany (cascade = CascadeType.PERSIST,fetch = FetchType.EAGER) //eager -->PARA QUE NOS TRAIGA AL OBJ CON SUS DATOS relacionados
	// 1usario puede tener M role y 1rol le puede petenerce a M usuario
	// muchos usuraio vana tener muchos roles
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	// con join table vamps aunir las tablas le pasamos el nombre de la tabla
	// (usuario_rol)
	// y vamos a juntar los id de uusrio y rol
	// colocamos inverseJoinColumns = @JoinColumn(name = "rol_id")) xq estamos en
	// ñla tabla Uusario, la principal
	private Set<Rol> roles = new HashSet<>();
	// aqui le pasmaos un conunto de roles ya que 1usario puede tener M role

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}
	
	public void añadirRol(Rol rol) {//para poder añadirle un rol a un usuario
		this.roles.add(rol);
		
	}
	
	public void eliminarRol(Rol rol) {
		this.roles.remove(rol);//vamos a eliinar todo el obj rol
	}

	public Usuario(Integer id, String email, String password, Set<Rol> roles) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public Usuario(String email, String password, Set<Rol> roles) {
		super();
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	
	

	public Usuario(Integer id) {
		super();
		this.id = id;
	}

	public Usuario(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	
	public Usuario() {
		super();
	}

}
