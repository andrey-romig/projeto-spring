package com.spring.udemy.spring.repository;

import com.spring.udemy.spring.entidades.CategoriaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaEntity, Long> {

    public Optional<CategoriaEntity> findById(Long id);

}
