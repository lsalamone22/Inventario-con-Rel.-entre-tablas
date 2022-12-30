package com.sistema.app.inventario.carrito.compras;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sistema.app.inventario.producto.Producto;
import com.sistema.app.inventario.usuario.Usuario;

@Entity
@Table(name = "articulo_carrito")
public class ArticuloCarrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int cantidad;
	
	@ManyToOne
	@JoinColumn(name = "producto_id")// se va a unir a una columna que sera esa
	private Producto producto;//1 produtcto puede sera gregado pr muchos usuarios en su carrito
	//y ese producto va a estar mapeado con producto_id la clase
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")// se va a unir a una columna que sera esa
	private Usuario usuario;//1 usuario puede agregar muchos productos a su carrito
	//y ese usuario va a estar mapeado con usuario_id la clase

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ArticuloCarrito(Integer id, int cantidad, Producto producto, Usuario usuario) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.producto = producto;
		this.usuario = usuario;
	}

	public ArticuloCarrito() {
		super();
	}

	public ArticuloCarrito(int cantidad, Producto producto, Usuario usuario) {
		super();
		this.cantidad = cantidad;
		this.producto = producto;
		this.usuario = usuario;
	}
	
	
	

}
