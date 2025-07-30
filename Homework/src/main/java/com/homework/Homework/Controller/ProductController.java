package com.homework.Homework.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homework.Homework.Service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService productSer;
	
	@GetMapping("/all")
	public String MarksAndProducts() {
		return productSer.GetMarksWithProducts();
	}
	
	@GetMapping("/assign")
	public ResponseEntity<String> assignMarkToProduct(@RequestParam Long productId,
	                                                  @RequestParam Long markId) {
	    productSer.addMarkToProduct(productId, markId);
	    return ResponseEntity.ok("Mark assigned to product successfully.");
	}
}
