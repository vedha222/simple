package com.productmanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productmanagement.domain.Product;
import com.productmanagement.repository.ProductRepository;
import com.productmanagement.service.ProductService;

@Service
public class ProductServiceimpl implements ProductService {
	
	@Autowired(required=true)
	private ProductRepository productRepository;
	
	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

}
