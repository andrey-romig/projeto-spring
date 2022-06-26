package com.spring.udemy.spring.entity;

import com.spring.udemy.spring.repository.CidadeRepository;

import javax.persistence.*;

@Entity
@Table(name = "TB_CIDADE")
public class CidadeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "CID_ID")
    private Long id;

    @Column(name = "CID_NOME")
    private String nome;

    @ManyToOne
    @JoinColumn(name="CID_ESTID")
    private EstadoEntity estado;

    public CidadeEntity() {

    }

    public CidadeEntity(Long id, String nome, EstadoEntity estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
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

    public EstadoEntity getEstado() {
        return estado;
    }

    public void setEstado(EstadoEntity estado) {
        this.estado = estado;
    }
}
