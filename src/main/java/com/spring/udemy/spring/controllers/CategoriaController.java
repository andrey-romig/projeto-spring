package com.spring.udemy.spring.controllers;

import com.spring.udemy.spring.entidades.CategoriaEntity;
import com.spring.udemy.spring.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody CategoriaEntity findById(@RequestParam("id") Long categoriaId) {
        return categoriaService.recuperarCategoriaById(categoriaId);
    }

}
