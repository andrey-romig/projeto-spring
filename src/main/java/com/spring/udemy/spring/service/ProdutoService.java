package com.spring.udemy.spring.service;

import com.spring.udemy.spring.entity.ProdutoEntity;
import com.spring.udemy.spring.exception.ObjectNotFoundException;
import com.spring.udemy.spring.repository.ProdutoRepository;
import com.spring.udemy.spring.service.base.ServiceBase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService extends ServiceBase {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public ProdutoEntity recuperarProdutoById(Long id) {
        return produtoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(getObjetoNaoEncontradoByIdMsg(id, ProdutoEntity.class.getSimpleName())));
    }

    public List<ProdutoEntity> recuperarProdutos() {
        return (List<ProdutoEntity>) produtoRepository.findAll();
    }

}
