package com.sistema.app.inventario;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.sistema.app.inventario.categoria.Categoria;
import com.sistema.app.inventario.categoria.CategoriaRepository;



@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class CategoriaRepositoryTest {
	
	@Autowired
	private CategoriaRepository repositorio;
	
	
	@Test
	
	public void testCrearCategoria() {
		Categoria categoriaGuardada = repositorio.save(new Categoria("Tecnologia"));
		
		assertThat(categoriaGuardada.getId()).isGreaterThan(0);
		//si el id de la nueva categoria es > a 0 (osea si es que se a guardado)
		//msj de exito que se guardo bien
	}

}