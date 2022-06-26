package com.spring.udemy.spring.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.spring.udemy.spring.entity.compose.ProdutoCategoriaCompose;

import javax.persistence.*;

@Entity
@Table(name="TB_PRODUTO_CATEGORIA")
public class ProdutoCategoriaEntity {

    @EmbeddedId
    @Column(name="PCT_ID")
    private ProdutoCategoriaCompose id;

    @JsonBackReference
    @ManyToOne
    @MapsId("categoriaId")
    @JoinColumn(name="PCT_CATID")
    private CategoriaEntity categoria;

    @JsonBackReference
    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name="PCT_PROID")
    private ProdutoEntity produto;

    public ProdutoCategoriaEntity() {}

    public ProdutoCategoriaEntity(CategoriaEntity categoria, ProdutoEntity produto) {
        this.categoria = categoria;
        this.produto = produto;
        this.id = new ProdutoCategoriaCompose(categoria.getId(), produto.getId());
    }

    public ProdutoCategoriaCompose getId() {
        return id;
    }

    public void setId(ProdutoCategoriaCompose id) {
        this.id = id;
    }

    public CategoriaEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEntity categoria) {
        this.categoria = categoria;
    }

    public ProdutoEntity getProduto() {
        return produto;
    }

    public void setProduto(ProdutoEntity produto) {
        this.produto = produto;
    }
}
