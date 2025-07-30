package com.homework.Homework.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.homework.Homework.Entity.Mark;

import com.homework.Homework.Entity.Product;
import com.homework.Homework.Repository.MarkRepository;
import com.homework.Homework.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRep;
     
	
	@Autowired
	MarkRepository markRepository;

	String output="";
	
	public void addMarkToProduct(Long productId, Long markId) {
	    Product product = productRep.findById(productId)
	        .orElseThrow(() -> new RuntimeException("Product not found"));

	    Mark mark = markRepository.findById(markId)
	        .orElseThrow(() -> new RuntimeException("Mark not found"));

	    product.getMarks().add(mark);
	    productRep.save(product);
	}
	
	public String GetMarksWithProducts(){
		output="";
		productRep.findAll().forEach(product->{
			
			output+=product.getProductId()+" "+product.getProductName()+" "+product.getProductPrice()+" "+"<br>";
			
		});
		
		return output;

	}
	
}
