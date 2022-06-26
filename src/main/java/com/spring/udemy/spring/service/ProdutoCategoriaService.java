package com.spring.udemy.spring.service;

import com.spring.udemy.spring.entity.CategoriaEntity;
import com.spring.udemy.spring.entity.ProdutoCategoriaEntity;
import com.spring.udemy.spring.entity.ProdutoEntity;
import com.spring.udemy.spring.repository.CategoriaRepository;
import com.spring.udemy.spring.repository.ProdutoCategoriaRepository;
import com.spring.udemy.spring.repository.ProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class ProdutoCategoriaService {

    private final ProdutoCategoriaRepository produtoCategoriaRepository;
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoCategoriaService(ProdutoCategoriaRepository produtoCategoriaRepository, ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoCategoriaRepository = produtoCategoriaRepository;
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public void criaProdutoCategoria(Long produtoId, Long categoriaId) {
        ProdutoEntity produto = produtoRepository.findById(Long.valueOf(produtoId)).orElseGet(null);
        CategoriaEntity categoria = categoriaRepository.findById(Long.valueOf(categoriaId)).orElseGet(null);

        produto.addCategoria(categoria);

        produtoRepository.save(produto);
    }

}
