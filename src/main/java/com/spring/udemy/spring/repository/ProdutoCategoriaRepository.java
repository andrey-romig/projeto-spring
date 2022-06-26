package com.spring.udemy.spring.repository;

import com.spring.udemy.spring.entity.ProdutoCategoriaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoCategoriaRepository extends CrudRepository<ProdutoCategoriaEntity, Long> {
}
