package com.spring.udemy.spring.controller;

import com.spring.udemy.spring.entity.CategoriaEntity;
import com.spring.udemy.spring.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/categorias")
    public @ResponseBody List<CategoriaEntity> findAll() {
        return categoriaService.recuperarTodos();
    }

    @GetMapping("/categorias/{id}")
    public @ResponseBody CategoriaEntity findById(@PathVariable Long id) {
        return categoriaService.recuperarCategoriaById(id);
    }

}
