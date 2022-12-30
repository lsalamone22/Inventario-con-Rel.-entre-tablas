package com.sistema.app.inventario.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@GetMapping("/usuarios")
		public String listarUsuarios(Model modelo) {
			List<Usuario> lisUsuarios = usuarioRepository.findAll();
			modelo.addAttribute("lisUsuarios", lisUsuarios);
			
			return "/usuarios";
		}
	
	@GetMapping("/usuarios/nuevo")
	public String mostrarFormDeRegistroDeUsuario(Model modelo) {
		List<Rol> lisRoles = rolRepository.findAll();
		modelo.addAttribute("lisRoles", lisRoles);
		modelo.addAttribute("usuario", new Usuario());//nueva instancia
		return "/usuario_form";
	}

	
	@PostMapping("/usuarios/guardar")
	public String guardarUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
		return "redirect:/usuarios";
		
	}
	
	@GetMapping("/usuarios/editar/{id}")
	public String mostrarFormParaEditarUsuario(@PathVariable("id") Integer id, Model modelo) {
		Usuario usuario = usuarioRepository.findById(id).get();
		modelo.addAttribute("usuario", usuario);
		
		List<Rol> lisRoles = rolRepository.findAll();
		modelo.addAttribute("lisRoles", lisRoles);
		
		return "/usuario_form";
	}
	
	@GetMapping("/usuarios/eliminar/{id}")
	public String eliminarUsuario(@PathVariable("id") Integer id, Model modelo) {
		usuarioRepository.deleteById(id);
		return "redirect:/usuarios";
	}
	
	
	

}
