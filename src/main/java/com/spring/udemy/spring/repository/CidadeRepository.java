package com.spring.udemy.spring.repository;

import com.spring.udemy.spring.entity.CategoriaEntity;
import com.spring.udemy.spring.entity.CidadeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends CrudRepository<CidadeEntity, Long> {

}
