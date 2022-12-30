package com.sistema.app.inventario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sistema.app.inventario.usuario.Rol;
import com.sistema.app.inventario.usuario.Usuario;
import com.sistema.app.inventario.usuario.UsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)//con la bdd
@Rollback(false)

public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCrearRoles() {
		Rol rolAdmin = new Rol("Administrador");
		Rol rolEditor = new Rol("Editor");
		Rol rolVisitante = new Rol("Visitante");
		
		entityManager.persist(rolAdmin);
		entityManager.persist(rolEditor);
		entityManager.persist(rolVisitante);
		//lo vamos a presistir con la bdd
		//es como guardarlo ala bdd este obj
		
		
	}
	
	@Test
	public void testCrearNuevoUsuarioConUnRol() {//crar un usuario con un unico rol
		Rol rolAdmin = entityManager.find(Rol.class, 1);//xq 1? xq vamos a buscar ddel obj Rol el id 1 de Admin
		Usuario usuario = new Usuario("lory@gmail.com","12345");
		
		//vamos a poner un metodo llamado añadir Rol
		usuario.añadirRol(rolAdmin);
		usuarioRepository.save(usuario);//para guardar el obj usuario
		
	}
	
	@Test
	public void testCrearNuevoUsuarioConDosRoles() {//crar un usuario con dos roles
		Rol rolEditor = entityManager.find(Rol.class, 2);
		Rol rolVisitante = entityManager.find(Rol.class, 3);
		
		Usuario usuario = new Usuario("mimi@gmail.com.com","1234567");
		
		//vamos a poner un metodo llamado añadir Rol
		usuario.añadirRol(rolEditor);
		usuario.añadirRol(rolVisitante);
		usuarioRepository.save(usuario);//para guardar el obj usuario
		
	}
	
	//vamos a añadir un rol a un usuario ya existente
	
	@Test
	public void testAsignarRolAUsuarioExistente() {
		
		Usuario usuario = usuarioRepository.findById(1).get();//busco el uuario cin id 1
		Rol rolEditor = entityManager.find(Rol.class, 2);
		
		//vamos a poner un metodo llamado añadir Rol
		usuario.añadirRol(rolEditor);
		
		
	}
	
	//añadimos metodo para eliminar un rol
	@Test
	public void testElimnarRolDeUnUsuarioExistente() {//para que se elime equals(Object obj) en la clase Rol
		//vamos a busar este usuari0
		Usuario usuario = usuarioRepository.findById(1).get();
		Rol rol = new Rol(2);//le pasaoms el ID del rol a eliminar
		
		usuario.eliminarRol(rol);
		//va a eliminar el usuario 1 el rol 2
	}
	
	//crear nuevo usuario con un solo rol
	@Test
	public void testCrearNuevoUsuarioConNuevoRol() {
		Rol rolRecepcionista = new Rol("Recepcionista");
		Usuario usuario = new Usuario("ali22@hotmail.com","789456");
		
		
		usuario.añadirRol(rolRecepcionista);
		usuarioRepository.save(usuario);
		
	}
	
	@Test
	public void testObtenerUsuario() {
		//vamos a buscar un usuario
		Usuario usuario = usuarioRepository.findById(1).get();
		entityManager.detach(usuario);//los cambios que le haga al obj usuario no se van a guardar  la bdd
		
		System.out.println(usuario.getEmail());
		System.out.println(usuario.getRoles());
	}
	
	//vamos a elimar un suusario

	@Test
	public void testEliminarUsuario() {
		usuarioRepository.deleteById(4);
	}
	//para esro le debemos de elimar el cascada xq sino no lo elimnabas

}
