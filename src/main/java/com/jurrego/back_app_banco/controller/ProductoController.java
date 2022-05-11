package com.jurrego.back_app_banco.controller;

import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jurrego.back_app_banco.entities.ProductoEntity;
import com.jurrego.back_app_banco.facade.ProductoFacade;

import java.text.SimpleDateFormat;
import java.text.ParseException;

@RestController
@CrossOrigin( origins = "*" , allowedHeaders = "*")
@RequestMapping("/Controller")
public class ProductoController {
	
	ProductoFacade productoFacade = new ProductoFacade();
	
	
	
	@GetMapping("/consultarProductos")//Para convertirlo en microservicio debe llevar esta anotacion
	public String consultarProductos() {
		String respuesta = null;
		respuesta = "Hola Team Semillero!!";		
		return respuesta;
	}
	
	
	@PostMapping("/crearProducto")
	public String crearProducto(@RequestParam("idProducto") Integer idProducto, @RequestParam("nombre") String nombre,
									@RequestParam("descripcion") String descripcion) {
		
		return null;
//		return productoFacade.crearProducto(idProducto, nombre, descripcion);
	}
	
	@GetMapping("/obtenerProductos")
	public List<ProductoEntity> obtenerLista(){
//		return productoFacade.listadoProductos();
		return null;
	}
	
	@GetMapping("/obtenerProducto")
	public ProductoEntity obtenerProducto(@RequestParam("idProducto") Integer idProducto) {
//		return productoFacade.obtenerProducto(idProducto);
		return null;
	}
	
	@PatchMapping("/editarNombreProducto")
	public String editarNombreProducto(@RequestParam("idProducto") Integer idProducto, 
										@RequestParam("nombreProducto") String nombreProducto) {
//		return productoFacade.editarNombreProducto(idProducto, nombreProducto);
		return null;
	}
	
	@PutMapping("/editarProductoCompleto")
	public String editarProductoCompleto(@RequestParam("idProducto") Integer idProducto,
										@RequestParam("nombreProducto") String nombreProducto,
										@RequestParam("descripcion") String descripcion) {
//		return productoFacade.editarProductoCompleto(idProducto, nombreProducto, descripcion);
		return null;
	}
	
	@DeleteMapping("/eliminarProducto")
	public String eliminarProducto(@RequestParam("idProducto") Integer idProducto) {
//		return productoFacade.eliminarProducto(idProducto);
		return null;
	}

}
