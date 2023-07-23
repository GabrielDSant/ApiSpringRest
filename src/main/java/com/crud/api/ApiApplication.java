package com.crud.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        // Configuração do log4j2 usando o arquivo de configuração
        System.setProperty("log4j.configurationFile", "log4j2.xml");

        SpringApplication.run(ApiApplication.class, args);
    }
}
