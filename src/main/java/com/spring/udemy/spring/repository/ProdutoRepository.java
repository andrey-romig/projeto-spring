package com.spring.udemy.spring.repository;

import com.spring.udemy.spring.entity.ProdutoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<ProdutoEntity, Long> {

}