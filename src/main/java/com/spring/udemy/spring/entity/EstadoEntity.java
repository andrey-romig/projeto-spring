package com.spring.udemy.spring.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TB_ESTADO")
public class EstadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "EST_ID")
    private Long id;

    @Column(name = "EST_NOME")
    private String nome;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL)
    private Set<CidadeEntity> cidades = new HashSet<>();

    public EstadoEntity() {

    }

    public EstadoEntity(Long id, String nome) {
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

    public Set<CidadeEntity> getCidades() {
        return cidades;
    }

    public void setCidades(Set<CidadeEntity> cidades) {
        this.cidades = cidades;
    }
}
