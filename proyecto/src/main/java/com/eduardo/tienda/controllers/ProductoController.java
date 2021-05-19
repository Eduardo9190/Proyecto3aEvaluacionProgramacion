package com.eduardo.tienda.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.tienda.model.ProductoModel;
import com.eduardo.tienda.services.ProductoService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping(path="/productos")
	public ArrayList<ProductoModel> getProductos() {
		return productoService.getProductos();
	}
	
	@PostMapping(path="/newproducto")
	public void postProducto(@RequestBody ProductoModel productoModel) {
		productoModel.validate();
		productoService.addProducto(productoModel);
	}
	
	@GetMapping(path="/productos/{sn}")
	public ProductoModel getProductoBySn(@PathVariable(name="sn") long sn) {
		return productoService.getProducto(sn);
	}
	
	@DeleteMapping(path="/deleteproducto/{sn}")
	public void deleteProducto(@PathVariable(name="sn") long sn) {
		productoService.deleteProducto(sn);
	}
}