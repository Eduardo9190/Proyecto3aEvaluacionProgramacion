package com.eduardo.tienda.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.tienda.entities.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	List<Producto> findBySn(long sn);
	List<Producto> deleteBySn(Producto producto);
}
