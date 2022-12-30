package com.sistema.app.inventario.producto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "producto_detalles")
public class ProductoDetalle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(length = 45, nullable = false, unique = false)
	private String nombre;
	
	@Column(length = 45, nullable = false, unique = false)
	private String valor;
	
	@ManyToOne//un productos puede tener muhcos detalles
	//por eso en producto_detalle es many
	@JoinColumn(name = "producto_id")
	//los detalles del prod. van a estar relacionados con el producto_id
	private Producto producto;

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

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public ProductoDetalle(Integer id, String nombre, String valor, Producto producto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.valor = valor;
		this.producto = producto;
	}

	public ProductoDetalle(String nombre, String valor, Producto producto) {
		super();
		this.nombre = nombre;
		this.valor = valor;
		this.producto = producto;
	}

	public ProductoDetalle() {
		super();
	}
	
	@Override
	public String toString() {
		//voy a imprimir el valor y nombre de los detalles
		return nombre + " - " + valor;
	}
	
	
}
