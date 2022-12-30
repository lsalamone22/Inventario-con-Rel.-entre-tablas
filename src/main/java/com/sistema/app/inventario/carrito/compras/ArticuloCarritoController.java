package com.sistema.app.inventario.carrito.compras;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.app.inventario.producto.Producto;
import com.sistema.app.inventario.producto.ProductoRepository;
import com.sistema.app.inventario.usuario.Usuario;
import com.sistema.app.inventario.usuario.UsuarioRepository;



@Controller
public class ArticuloCarritoController {
	
	@Autowired
	private ArticuloCarritoRepository repositorio;
	
	@Autowired
	private ProductoRepository proRe;
	
	@Autowired
	private UsuarioRepository usuRe;
	
	@GetMapping("/carrito")
	public String listarUsuarios(Model modelo) {
		List<ArticuloCarrito> lisCarrito = repositorio.findAll();
		modelo.addAttribute("lisCarrito", lisCarrito);
		
		return "/carrito";
	}
	
	@GetMapping("/carrito/nuevo")
	public String mostrarFormDeNuevoCarrito(Model modelo) {
	List<Producto> lisProducto = proRe.findAll();
	List<Usuario> lisUsu = usuRe.findAll();
	
	modelo.addAttribute("carrito", new ArticuloCarrito());
	modelo.addAttribute("lisProducto", lisProducto);
	modelo.addAttribute("lisUsu", lisUsu);
	return "/carrito_form";
		
	}
	
	@PostMapping("/carrito/guardar")
	public String guardarCarrito(ArticuloCarrito carrito) {
						
		repositorio.save(carrito);
		return "redirect:/carrito";
	}
	
	@GetMapping("/carrito/editar/{id}")
	public String mostrarFormParaEditarCarrito(@PathVariable("id") Integer id, Model modelo) {
		
		ArticuloCarrito carrito = repositorio.findById(id).get();//esto va a buscar el id
		modelo.addAttribute("carrito", carrito);
		
		List<Producto> lisProducto = proRe.findAll();
		modelo.addAttribute("lisProducto", lisProducto);//los va a lista RECUERDA DEBE SER IGUAL AL CARRITO/NUEVO
		
		List<Usuario> lisUsu = usuRe.findAll();
		modelo.addAttribute("lisUsu", lisUsu);
		
		return "/carrito_form";
	}
	
	
	@GetMapping("/carrito/eliminar/{id}")
	public String eliminarCarrito(@PathVariable("id") Integer id, Model modelo) {
		repositorio.deleteById(id);
		return "redirect:/carrito";
	}
	
		
	

}
