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
		if(!productoRepository.findBySn(producto.getSN()).isEmpty()) {
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
	
	public ProductoModel getProducto(long sn) {
		if(!productoRepository.findBySn(sn).isEmpty()) {
			throw new BadRequestException();
		}
		ProductoModel productoModel = productoConverter.entityToModel(productoRepository.findBySn(sn).get(0));
		return productoModel;
	}
	
	public void deleteProducto(long sn) {
		if(productoRepository.findBySn(sn).isEmpty()) {
			throw new NotFoundException();
		}
		Producto producto = productoRepository.findBySn(sn).get(0);
		productoRepository.deleteBySn(producto);
	}
	
}
