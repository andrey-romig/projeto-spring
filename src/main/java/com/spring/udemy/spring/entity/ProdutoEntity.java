package com.spring.udemy.spring.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity
@Table(name="TB_PRODUTO")
public class ProdutoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PRO_ID")
    private Long id;

    @Column(name="PRO_NOME")
    private String nome;

    @Column(name="PRO_PRECO")
    private BigDecimal preco;

    @JsonManagedReference
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ProdutoCategoriaEntity> produtoCategoria = new HashSet<>();

    public ProdutoEntity() {}

    public ProdutoEntity(Long id, String nome) {
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Set<ProdutoCategoriaEntity> getProdutoCategoria() {
        return produtoCategoria;
    }

    public void setProdutoCategoria(Set<ProdutoCategoriaEntity> produtoCategorias) {
        this.produtoCategoria = produtoCategorias = new HashSet<>();
    }

    public void addCategoria(CategoriaEntity categoria) {
        ProdutoCategoriaEntity produtoCategoria = new ProdutoCategoriaEntity(categoria, this);

        if (this.produtoCategoria == null) this.produtoCategoria = new HashSet<>();
        this.produtoCategoria.add(produtoCategoria);
        categoria.getProdutoCategoria().add(produtoCategoria);
    }

    public void removeCategoria(CategoriaEntity categoria) {
        for (Iterator<ProdutoCategoriaEntity> iterator = produtoCategoria.iterator(); iterator.hasNext(); ) {
            ProdutoCategoriaEntity produtoCategoria = iterator.next();

            if (produtoCategoria.getProduto().equals(this) && produtoCategoria.getCategoria().equals(categoria)) {
                iterator.remove();
                produtoCategoria.getCategoria().getProdutoCategoria().remove(produtoCategoria);
                produtoCategoria.setCategoria(null);
                produtoCategoria.setProduto(null);
            }
        }
    }
}
