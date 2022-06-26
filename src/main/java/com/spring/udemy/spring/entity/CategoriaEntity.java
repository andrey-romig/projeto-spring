package com.spring.udemy.spring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name = "TB_CATEGORIA")
public class CategoriaEntity {

    @Id
    @Column(name = "CAT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CAT_NOME")
    private String nome;

    @JsonManagedReference
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProdutoCategoriaEntity> produtoCategoria = new HashSet<>();

    public CategoriaEntity() {
    }

    public CategoriaEntity(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<ProdutoCategoriaEntity> getProdutoCategoria() {
        return produtoCategoria;
    }

    public void setProdutoCategoria(Set<ProdutoCategoriaEntity> produtoCategorias) {
        this.produtoCategoria = produtoCategorias;
    }

    public void addProduto(ProdutoEntity produto) {
        ProdutoCategoriaEntity produtoCategoria = new ProdutoCategoriaEntity(this, produto);

        if (this.produtoCategoria == null) this.produtoCategoria = new HashSet<>();
        this.produtoCategoria.add(produtoCategoria);
        produto.getProdutoCategoria().add(produtoCategoria);
    }

    public void removeProduto(ProdutoEntity produto) {
        for (Iterator<ProdutoCategoriaEntity> iterator = produtoCategoria.iterator(); iterator.hasNext(); ) {
            ProdutoCategoriaEntity produtoCategoria = iterator.next();

            if (produtoCategoria.getCategoria().equals(this) && produtoCategoria.getProduto().equals(produto)) {
                iterator.remove();
                produtoCategoria.getProduto().getProdutoCategoria().remove(produtoCategoria);
                produtoCategoria.setCategoria(null);
                produtoCategoria.setProduto(null);
            }
        }
    }

}
