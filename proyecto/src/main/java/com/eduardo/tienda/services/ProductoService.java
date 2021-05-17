package com.eduardo.tienda.services;


import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.eduardo.tienda.model.Producto;

@Service
public class ProductoService {
	private HashMap<Long,Producto> productos = new HashMap<>();
	
	public boolean addProducto(Producto producto) {
		if(!productos.containsKey(producto.getSN())) {
			this.productos.put(producto.getSN(),producto);
			return true;
		}else {
			return false;
		}
	}
	
	public Collection<Producto> getProductos(){
		return productos.values();
	}
	
	/*
	public Optional<ProductoModel>getProducto(long id){
		Optional<ProductoModel> resultModel=Optional.empty();
		Optional<Producto> resultProducto= productoRepository.findById(id);
		if(resultProducto.isPresent()) {
		Producto producto=resultProducto.get();
		ProductoModel productoModel =productoConverter.entityToModel(producto);
		resultModel= Optional.of(productoModel);
		}
		return resultModel;
		}*/
	
}
