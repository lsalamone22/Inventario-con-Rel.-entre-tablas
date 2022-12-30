package com.sistema.app.inventario.producto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sistema.app.inventario.categoria.Categoria;

@Entity
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 128, nullable = false, unique = true)
	private String nombre;

	private float precio;

	@ManyToOne//muchos productos pueden tiene  categorgia 1
	@JoinColumn(name = "categoria_id") // se va a unir a una columna que sera esa
	private Categoria categoria;
	// 1 categoria puede tener muchos productos

	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL)
	// va a estar mapeado por el producto (que esta en la clase de producto detalle)
	// cascada es cuando se persista un obj en hibernate tamb persista a sus hijos
	// osea a los que stan relacionados a este obj
	private List<ProductoDetalle> detalles = new ArrayList<>();
	//esta lista se esta vinculando con producot_id que seria el id de la calse producto
	
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	// vamos a añadir detalles a un Array
	public void añadirDetalles(String nombre, String valor) {
		this.detalles.add(new ProductoDetalle(nombre, valor, this));
	}

	public List<ProductoDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<ProductoDetalle> detalles) {
		this.detalles = detalles;
	}
	
	public void setDetalle(Integer id, String nombre, String valor) {
		this.detalles.add(new ProductoDetalle(id,nombre,valor,this));
	}

	public Producto(Integer id, String nombre, float precio, Categoria categoria) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Producto() {
		super();
	}
	
	

	public Producto(Integer id) {
		super();
		this.id = id;
	}

	public Producto(String nombre, float precio, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Producto(String nombre) {
		super();
		this.nombre = nombre;
	}

}
