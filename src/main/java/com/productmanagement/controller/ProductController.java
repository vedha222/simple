package com.productmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.productmanagement.VM.ProductVM;
import com.productmanagement.domain.Product;
import com.productmanagement.service.ProductService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;



@Controller
@CrossOrigin("*")
@RequestMapping("/api")
public class ProductController {
	
	@Autowired(required=true)
	private ProductService productService;
	
	@PostMapping("/product/save")
	 public ResponseEntity<Product> save(@RequestBody ProductVM productvm){
		Product product = new Product();
		 
		product.setProductName(productvm.getProductName());
		product.setProductCost(productvm.getProductCost());
		product.setProductOfferprice(productvm.getProductOfferprice());
	
		 
		Product result = productService.save(product);
		 
		 return ResponseEntity.ok().body(result);
	 }

	@GetMapping("/product/all")
	public ResponseEntity<List<ProductVM>> getProductList(){
		
		List<Product> productList = productService.findAll();
		List<ProductVM> productLists = new ArrayList<ProductVM>();
		productList.stream().forEach(product ->{
			
			ProductVM productvm = new ProductVM();
			
			productvm.setId(product.getId());
			productvm.setProductName(product.getProductName());
			productvm.setProductCost(product.getProductCost());
			productvm.setProductOfferprice(product.getProductOfferprice());
			
			productLists.add(productvm);
			
		});
		return ResponseEntity.ok().body(productLists);
		
	}
	
	
}
