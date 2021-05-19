package com.eduardo.tienda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.tienda.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
