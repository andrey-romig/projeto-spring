package com.spring.udemy.spring.entity.compose;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProdutoCategoriaCompose implements Serializable {

    @Column(name = "PCT_CATID")
    private Long categoriaId;

    @Column(name = "PCT_PROID")
    private Long produtoId;

    public ProdutoCategoriaCompose() {}

    public ProdutoCategoriaCompose(Long categoriaId, Long produtoId) {
        this.categoriaId = categoriaId;
        this.produtoId = produtoId;
    }

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ProdutoCategoriaCompose produtoCategoriaCompose = (ProdutoCategoriaCompose) obj;
        return Objects.equals(produtoId, produtoCategoriaCompose.produtoId) &&
                Objects.equals(categoriaId, produtoCategoriaCompose.categoriaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produtoId, categoriaId);
    }

}
