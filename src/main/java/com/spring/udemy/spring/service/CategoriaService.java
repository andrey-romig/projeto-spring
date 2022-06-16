package com.spring.udemy.spring.service;

import com.spring.udemy.spring.entidades.CategoriaEntity;
import com.spring.udemy.spring.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public CategoriaEntity recuperarCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

}
