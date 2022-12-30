package com.sistema.app.inventario;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sistema.app.inventario.carrito.compras.ArticuloCarrito;
import com.sistema.app.inventario.carrito.compras.ArticuloCarritoRepository;
import com.sistema.app.inventario.producto.Producto;
import com.sistema.app.inventario.usuario.Usuario;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class ArticuloCarritoTest {
	
	@Autowired
	private ArticuloCarritoRepository repositorio;
	

	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testAñadirArticulo() {
		Producto producto = entityManager.find(Producto.class, 13);
		Usuario usuario = entityManager.find(Usuario.class, 2);
		
		ArticuloCarrito articulo = new ArticuloCarrito(7,producto,usuario);
		repositorio.save(articulo);
	}
	
	@Test
	public void testAñadirMultipleArticulo() {
		Usuario usuario = new Usuario(1);
		Producto producto1 = new Producto(9);
		Producto producto2 = new Producto(12);
		
		ArticuloCarrito articulo1 = new ArticuloCarrito(10,producto1,usuario);
		ArticuloCarrito articulo2 = new ArticuloCarrito(5,producto2,usuario);
		repositorio.saveAll(List.of(articulo1,articulo2));
	}

}
