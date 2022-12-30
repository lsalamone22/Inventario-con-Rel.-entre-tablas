package com.sistema.app.inventario.marca;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.app.inventario.categoria.Categoria;
import com.sistema.app.inventario.categoria.CategoriaRepository;

@Controller
public class MarcaController {
	
	@Autowired
	private MarcaRepository marcaRepositorio;
	
	@Autowired
	private CategoriaRepository categoriaRepositorio;
	
	@GetMapping("/marcas/nueva")
	public String mostrarFormDeCrearMarca(Model modelo) {
		List<Categoria> lisCategoria =  categoriaRepositorio.findAll();
		modelo.addAttribute("lisCategoria", lisCategoria);
		modelo.addAttribute("marca", new Marca());
		return "/marca_form";
	}
	
	@PostMapping("/marca/guardar")
	public String guardarMarca(Marca marca) {
		marcaRepositorio.save(marca);
		return "redirect:/marcas";
	}
	
	@GetMapping("/marcas")
	public String listarMarcas(Model modelo) {
		List<Marca> lisMarcas = marcaRepositorio.findAll();
		modelo.addAttribute("lisMarcas", lisMarcas);
		return "/marcas";
	}
	
	@GetMapping("/marca/editar/{id}")
	public String mostrarFormDeEditarMarca(@PathVariable("id") Integer id,Model modelo) {
		List<Categoria> lisCategoria =  categoriaRepositorio.findAll();
		
		Marca marca = marcaRepositorio.findById(id).get();//obtnemos el id de la marca
		
		modelo.addAttribute("lisCategoria", lisCategoria);
		modelo.addAttribute("marca", marca);
		return "/marca_form";
	}

}
