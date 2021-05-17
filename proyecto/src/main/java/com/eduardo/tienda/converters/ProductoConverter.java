package com.eduardo.tienda.converters;

import org.springframework.stereotype.Component;

import com.eduardo.tienda.model.ProductoModel;
import com.eduardo.tienda.entities.Producto;

@Component
public class ProductoConverter {

	public Producto modelToEntity (ProductoModel productoModel) {
		Producto producto = new Producto();
		producto.setSN(productoModel.getSN());
		producto.setNombre(productoModel.getNombre());
		producto.setFabricante(productoModel.getFabricante());
		producto.setCategoria(productoModel.getCategoria());
		producto.setStock(productoModel.getStock());
		producto.setPrecio(productoModel.getPrecio());
		return producto;
	}
	
	public ProductoModel entityToModel (Producto producto) {
		ProductoModel productoModel = new ProductoModel();
		productoModel.setSN(producto.getSN());
		productoModel.setNombre(producto.getNombre());
		productoModel.setFabricante(producto.getFabricante());
		productoModel.setCategoria(producto.getCategoria());
		productoModel.setStock(producto.getStock());
		productoModel.setPrecio(producto.getPrecio());
		return productoModel;
	}
	
	
}
