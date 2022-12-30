package com.sistema.app.inventario.marca;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.sistema.app.inventario.categoria.Categoria;

@Entity
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = true)
	private String nombre;

	@OneToMany // una marca va a tener muhcas categorias
	@JoinColumn(name = "marca_id")
	private List<Categoria> categorias = new ArrayList<>();
	//esta lista se esta vinculando con marca_id que seria el id de la calse marca
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Marca(Integer id, String nombre, List<Categoria> categorias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.categorias = categorias;
	}

	public Marca(Integer id) {
		super();
		this.id = id;

	}

	public Marca(String nombre, List<Categoria> categorias) {
		super();

		this.nombre = nombre;
		this.categorias = categorias;
	}

	public Marca() {
		super();

	}

	

}
