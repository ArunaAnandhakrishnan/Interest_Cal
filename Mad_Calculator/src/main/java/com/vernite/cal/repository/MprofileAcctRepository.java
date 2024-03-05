package com.vernite.cal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vernite.cal.model.Mprofileacct;
import com.vernite.cal.model.Products;

public interface MprofileAcctRepository extends JpaRepository<Mprofileacct, Long> {

	public Products findByProducts(Products products);

	public Optional<Mprofileacct> findByProducts(Optional<Products> productDatas);

}
