package com.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productmanagement.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
