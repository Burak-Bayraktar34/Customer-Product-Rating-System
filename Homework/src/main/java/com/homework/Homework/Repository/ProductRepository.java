package com.homework.Homework.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homework.Homework.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
