package com.eduardo.tienda.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.tienda.errors.BadRequestException;
import com.eduardo.tienda.model.Producto;
import com.eduardo.tienda.services.ProductoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductoController {
	
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping(path="productos")
	public Collection<Producto> getProductos(){
		return productoService.getProductos();
	}
	
	@PostMapping(path="newproductos")
	public void postProducto(@RequestBody Producto producto) {
		producto.validate();
		if(!productoService.addProducto(producto)) {
			throw new BadRequestException();
		}
	}
	/*
	@DeleteMapping(path="deleteproducto")
	public void deleteProducto(long sn) {
		Optional<ProductoModel> resultModel=Optional.empty();
		Optional<Producto> resultProducto= productoRepository.findById(sn);
		if(resultProducto.isPresent()) {
		   productoRepository.deleteById(sn);
		}else {
			throw new NotFoundException();
		}
	}*/
}