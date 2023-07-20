package com.crud.api.repository;

import com.crud.api.model.Product;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@EnableAutoConfiguration
// A extender o JpaRepository é nessário passar o model e o tipo de identificação que ele espera no caso o type do ID
public interface ProductRepository extends JpaRepository<Product, Long> {
}
