package com.sistema.app.inventario.categoria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@GetMapping("/categorias")
	public String listarCategorias(Model modelo) {
		List<Categoria> lisCategoria = categoriaRepository.findAll();
		modelo.addAttribute("listaCategorias", lisCategoria);
		return "/categorias";
	}
	
	@GetMapping("/categorias/nuevo")
	public String mostrarFormDeNuevaCategoria(Model modelo) {
		modelo.addAttribute("categoria", new Categoria());//nueva instancias o nuevo obj
		//para accder a cada atributo y establecer un nuevo valor
		
		return "/categoria_form";
	}
	
	
	@PostMapping("/categorias/guardar")
	public String guardarCategoria(Categoria categoria) {
		categoriaRepository.save(categoria);
		return "redirect:/categorias";
	}
	
	

}
