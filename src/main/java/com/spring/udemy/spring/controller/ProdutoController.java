package com.spring.udemy.spring.controller;

import com.spring.udemy.spring.entity.ProdutoEntity;
import com.spring.udemy.spring.service.ProdutoCategoriaService;
import com.spring.udemy.spring.service.ProdutoService;
import org.apache.commons.lang3.CharSet;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.apache.commons.lang3.CharSet.*;

@RestController
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ProdutoCategoriaService produtoCategoriaServiceService;

    public ProdutoController(ProdutoService produtoService, ProdutoCategoriaService produtoCategoriaServiceService) {
        this.produtoService = produtoService;
        this.produtoCategoriaServiceService = produtoCategoriaServiceService;
    }

    @GetMapping("/produtos")
    public List<ProdutoEntity> findAll() {
        return produtoService.recuperarProdutos();
    }

    @GetMapping("/produtos/{id}")
    public @ResponseBody ProdutoEntity findById(@PathVariable Long id) {
        return produtoService.recuperarProdutoById(id);
    }

    @PutMapping("/produtos/adicionarCategoria")
    public void adicionarCategoria(@RequestParam MultiValueMap<String,String> params) {
        Long produtoId = NumberUtils.toLong(params.get("produtoId").get(0).toString());
        Long categoriaId = NumberUtils.toLong(params.get("categoriaId").get(0).toString());

        produtoCategoriaServiceService.criaProdutoCategoria(produtoId, categoriaId);
    }

}
