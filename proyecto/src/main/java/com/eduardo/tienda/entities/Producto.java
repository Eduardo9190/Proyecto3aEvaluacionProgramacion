package com.eduardo.tienda.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Producto {
	
	@Id
	@Column(name="sn")
	private long sn;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="fabricante")
	private String fabricante;
	
	@Column(name="categoria")
	private String categoria;
	
	@Column(name="stock")
	private int stock;
	
	@Column(name="precio")
	private double precio;
	
	public Producto() {
		super();
	}
	
	public Producto(long sn, String nombre, String fabricante, String categoria, int stock, double precio) {
		super();
		this.sn = sn;
		this.nombre = nombre;
		this.fabricante = fabricante;
		this.categoria = categoria;
		this.stock = stock;
		this.precio = precio;
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
	
	
	
	
	
	
}
