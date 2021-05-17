package com.eduardo.tienda.services;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.tienda.model.ProductoModel;
import com.eduardo.tienda.repositories.ProductoRepository;
import com.eduardo.tienda.converters.ProductoConverter;
import com.eduardo.tienda.entities.Producto;
import com.eduardo.tienda.errors.NotFoundException;

@Service
public class ProductoService {
	@Autowired
	private ProductoConverter productoConverter;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public void addProducto(ProductoModel productoModel) {
		Producto producto = productoConverter.modelToEntity(productoModel);
		productoRepository.save(producto);
	}

	public ArrayList<ProductoModel> getProductos() {
		List<Producto> productos = productoRepository.findAll();
		ArrayList<ProductoModel> result = new ArrayList<>();
		for(Producto producto: productos) {
			result.add(productoConverter.entityToModel(producto));
		}
		return result;
	}
	
	public Optional<ProductoModel> getProducto(long id) {
		Optional<ProductoModel> resultModel = Optional.empty();
		Optional<Producto> resultProducto = productoRepository.findById(id);
		if(resultProducto.isPresent()) {
			resultModel = Optional.of(productoConverter.entityToModel(resultProducto.get()));
		}
		return resultModel;
	}
	
	public void deleteProducto(long sn) {
		Optional<ProductoModel> resultModel = Optional.empty();
		Optional<Producto> resultProducto = productoRepository.findById(sn);
		if(resultProducto.isPresent()) {
		   productoRepository.deleteById(sn);
		}else {
			throw new NotFoundException();
		}
	}
	
}
