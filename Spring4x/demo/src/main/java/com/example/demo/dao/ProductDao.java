package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;

@Repository(value="prodDao")
public interface ProductDao extends JpaRepository<Product, String>{
	
	
	
}
