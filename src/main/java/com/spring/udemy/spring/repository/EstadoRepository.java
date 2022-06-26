package com.spring.udemy.spring.repository;

import com.spring.udemy.spring.entity.CidadeEntity;
import com.spring.udemy.spring.entity.EstadoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends CrudRepository<EstadoEntity, Long> {

}
