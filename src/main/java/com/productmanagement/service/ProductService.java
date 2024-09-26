package com.productmanagement.service;

import java.util.List;

import com.productmanagement.domain.Product;

public interface ProductService {

	Product save(Product product);

	List<Product> findAll();

}
