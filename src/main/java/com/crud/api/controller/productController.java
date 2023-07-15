package com.crud.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.crud.api.repository.productRepository;
import com.crud.api.model.product;

import java.util.List;

//Serve para indicar que nossa classe é um controller
@RestController
// O Request Mapping serve pra dizer para o spring qual o endpoint que esse Controller/Classe toma conta;
@RequestMapping("/products")
public class productController {
    //O GetMapping serve para dizer para o string que o método responde ao método Get

    private productRepository ProductRepository;

    @Autowired
    public productController(productRepository ProductRepository){
        this.ProductRepository = ProductRepository;
    }
    @GetMapping
    // No java precisamos dizer o que volta da "classe" no caso 'void' é vazio.
    // Aqui voltamos o ResponseEntity que é uma classe responsavel pela montagem do response;
    public ResponseEntity<List<product>> getAllProduct(){
        // .ok == "status 200"
        List<product> product = ProductRepository.findAll();
        if (!product.isEmpty()) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<product> createUser(@RequestBody product Product) {
        product createdproduct = ProductRepository.save(Product);
        return new ResponseEntity<>(createdproduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<product> getUser(@PathVariable Long id) {
        product Product = ProductRepository.findById(id).orElse(null);
        if (Product != null) {
            return new ResponseEntity<>(Product, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
