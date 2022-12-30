package com.sistema.app.inventario.producto;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.app.inventario.categoria.Categoria;
import com.sistema.app.inventario.categoria.CategoriaRepository;

@Controller
public class ProductoController {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@GetMapping("/productos")
	public String listarProductos(Model modelo) {
		List<Producto> lisProductos = productoRepository.findAll();
		modelo.addAttribute("lisProductos", lisProductos);
		return "/productos";
	}
	
	
	
	@GetMapping("/productos/nuevo")
		public String mostrarFormDeNuevoProducto(Model modelo) {
		List<Categoria> lisCategoria = categoriaRepository.findAll();
		
		modelo.addAttribute("producto", new Producto());
		modelo.addAttribute("lisCategoria", lisCategoria);
		return "/producto_form";
			
		}
	
	@PostMapping("/productos/guardar")
	public String guardarProducto(Producto producto, HttpServletRequest request) {
		
		String[] detallesID = request.getParameterValues("detallesID");
		
		//vamos a pasar un arreglo
		//esto es para obtener datos--nombre de detalle
		String[] detallesNombres = request.getParameterValues("detallesNombres");
		//este será el valor
		String[] detallesValores = request.getParameterValues("detallesValores");
		
		for(int i=0;i<detallesNombres.length ;i++) {
			//aqui vamos a crear un metodo para registrar los detalles
			if(detallesID !=null && detallesID.length > 0) {
				producto.setDetalle(Integer.valueOf(detallesID[i]),detallesNombres[i],detallesValores[i]);
				//[i ]la osicion en la que esta
				//si detalle ID tiene un id loq ue voy ad ecir es que le voy a establecer
				//arreglo delos nombres y valor en la psoicion que vaya 
				
			}else {//si es que llegara a ser nulos
				producto.añadirDetalles(detallesNombres[i],detallesValores[i]);
				
			}
			
		}
		
		productoRepository.save(producto);
		return "redirect:/productos";
	}
	
	
	@GetMapping("/productos/editar/{id}")
	public String mostrarFormParaEditarProducto(@PathVariable("id") Integer id, Model modelo) {
		Producto producto = productoRepository.findById(id).get();
		modelo.addAttribute("producto", producto);
		
		List<Categoria> lisCategoria = categoriaRepository.findAll();
		modelo.addAttribute("lisCategoria", lisCategoria);
		
		return "/producto_form";
	}
	
	@GetMapping("/productos/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") Integer id, Model modelo) {
		productoRepository.deleteById(id);
		return "redirect:/productos";
	}
	
	


}
