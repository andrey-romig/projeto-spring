package com.spring.udemy.spring;

import com.spring.udemy.spring.entity.*;
import com.spring.udemy.spring.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CursoSpringUdemyApplication implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;
    private final ProdutoRepository produtoRepository;
    private final ProdutoCategoriaRepository produtoCategoriaRepository;
    private final EstadoRepository estadoRepository;
    private final CidadeRepository cidadeRepository;

    public CursoSpringUdemyApplication(CategoriaRepository categoriaRepository, ProdutoRepository produtoRepository, ProdutoCategoriaRepository produtoCategoriaRepository, EstadoRepository estadoRepository, CidadeRepository cidadeRepository) {
        this.categoriaRepository = categoriaRepository;
        this.produtoRepository = produtoRepository;
        this.produtoCategoriaRepository = produtoCategoriaRepository;
        this.estadoRepository = estadoRepository;
        this.cidadeRepository = cidadeRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringUdemyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        CategoriaEntity categoria1 = new CategoriaEntity(null, "Informática");
        CategoriaEntity categoria2 = new CategoriaEntity(null, "Escritório");

        ProdutoEntity produto1 = new ProdutoEntity(null, "Computador");
        ProdutoEntity produto2 = new ProdutoEntity(null, "Impressora");
        ProdutoEntity produto3 = new ProdutoEntity(null, "Mouse");

        ProdutoCategoriaEntity produtoCategoria1 = new ProdutoCategoriaEntity(categoria1, produto1);
        ProdutoCategoriaEntity produtoCategoria2 = new ProdutoCategoriaEntity(categoria1, produto2);
        ProdutoCategoriaEntity produtoCategoria3 = new ProdutoCategoriaEntity(categoria1, produto3);
        ProdutoCategoriaEntity produtoCategoria4 = new ProdutoCategoriaEntity(categoria2, produto2);

        EstadoEntity estado1 = new EstadoEntity(null, "Minas Gerais");
        EstadoEntity estado2 = new EstadoEntity(null, "São Paulo");

        CidadeEntity cidade1 = new CidadeEntity(null, "Uberlandia", estado1);
        CidadeEntity cidade2 = new CidadeEntity(null, "São Paulo", estado2);
        CidadeEntity cidade3 = new CidadeEntity(null, "Campinas", estado2);

        estado1.getCidades().addAll(Arrays.asList(cidade1));
        estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));

        estadoRepository.saveAll(Arrays.asList(estado1, estado2));
        cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
        categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
        produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
        produtoCategoriaRepository.saveAll(Arrays.asList(produtoCategoria1, produtoCategoria2, produtoCategoria3, produtoCategoria4));
    }

}
