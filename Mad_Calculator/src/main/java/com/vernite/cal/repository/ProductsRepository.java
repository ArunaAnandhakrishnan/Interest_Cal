package com.vernite.cal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Products;
import java.util.List;


public interface ProductsRepository extends JpaRepository<Products, Long> {

	public Products findByName(String name);
}
