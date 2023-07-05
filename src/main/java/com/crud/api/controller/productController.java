package com.crud.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Serve para indicar que nossa classe é um controller
@RestController
// O Request Mapping serve pra dizer para o spring qual o endpoint que esse Controller/Classe toma conta;
@RequestMapping("/products")
public class productController {
    //O GetMapping serve para dizer para o string que o método responde ao método Get
    @GetMapping

    // No java precisamos dizer o que volta da "classe" no caso 'void' é vazio.
    // Aqui voltamos o ResponseEntity que é uma classe responsavel pela montagem do response;
    public ResponseEntity getAllProduct(){
        // .ok == "status 200"
        return ResponseEntity.ok("deu Ok!");
    }
}
