package com.eduardo.tienda.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.tienda.model.ProductoModel;
import com.eduardo.tienda.repositories.ProductoRepository;
import com.eduardo.tienda.converters.ProductoConverter;
import com.eduardo.tienda.entities.Producto;
import com.eduardo.tienda.errors.BadRequestException;
import com.eduardo.tienda.errors.NotFoundException;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoConverter productoConverter;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public void addProducto(ProductoModel productoModel) {
		Producto producto = productoConverter.modelToEntity(productoModel);
		long id = producto.getID();
		Optional<Producto> findProductoEntity = productoRepository.findById(id);
		if(!findProductoEntity.isEmpty()) {
			throw new BadRequestException();
		}
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
	
	public ProductoModel getProducto(long id) {
		Optional<Producto> findProductoEntity = productoRepository.findById(id);
		if(findProductoEntity.isEmpty()) {
			throw new NotFoundException();
		}
		Producto producto = productoRepository.findById(id).get();
		ProductoModel result = productoConverter.entityToModel(producto);
		return result;
	}
	
	public void deleteProducto(long id) {
		Optional<Producto> findProductoModel = productoRepository.findById(id);
		if(findProductoModel.isEmpty()) {
			throw new NotFoundException();
		}
		productoRepository.deleteById(id);
	}
	
}