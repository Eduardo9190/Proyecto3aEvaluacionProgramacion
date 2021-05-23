package com.eduardo.tienda.model;

import com.eduardo.tienda.errors.BadRequestException;

public class ProductoModel {
	
	private long id;
	private long sn;
	private String nombre;
	private String fabricante;
	private String categoria;
	private int stock;
	private double precio;
	
	public ProductoModel() {
		super();
	}
	public ProductoModel(long id, long sn, String nombre, String fabricante, String categoria, int stock, double precio) {
		super();
		this.id = id;
		this.sn = sn;
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.categoria = categoria;
		this.stock = stock;
		this.precio = precio;
	}
	
	public long getID() {
		return id;
	}
	
	public void setID(long id) {
		this.id = id;
	}
	
	public long getSN() {
		return sn;
	}
	public void setSN(long sn) {
		this.sn = sn;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	public boolean validate() throws BadRequestException {
		if(nombre!=null 
				&& nombre.matches("^(([a-zA-ZÁÉÍÓÚáéíóú])+|\\s)+$")
				&& id>0
				&& sn>0
				&& categoria!=null
				&& categoria.matches("^(([a-zA-ZÁÉÍÓÚáéíóú])+|\\s)+$")
				&& fabricante!=null
				&& fabricante.matches("^(([a-zA-ZÁÉÍÓÚáéíóú])+|\\s)+$")
				&& stock > 0
				&& precio > 0) {
			return true;
		}
		throw new BadRequestException();
	}
}
