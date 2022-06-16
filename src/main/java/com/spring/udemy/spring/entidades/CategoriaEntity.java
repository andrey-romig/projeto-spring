package com.spring.udemy.spring.entidades;

import javax.persistence.*;

@Entity
@Table(name="TB_CATEGORIA")
public class CategoriaEntity {

    @Id
    @Column(name="CAT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="CAT_NOME")
    private String nome;

    public CategoriaEntity() {}

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

}
