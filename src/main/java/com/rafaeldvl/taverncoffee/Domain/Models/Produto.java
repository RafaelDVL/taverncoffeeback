package com.rafaeldvl.taverncoffee.Domain.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer estoque;
    private String nome;
    private String urlImage;
    private String observacoes;


    @JsonIgnore
    @ManyToMany(mappedBy = "listaProduto")
    private List<OrdemPedido> listaOrdem = new ArrayList<>();

    public Produto() {
    }

    public Produto(Integer id, Integer estoque, String nome, String urlImage, String observacoes) {
        this.id = id;
        this.estoque = estoque;
        this.nome = nome;
        this.urlImage = urlImage;
        this.observacoes = observacoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public List<OrdemPedido> getListaOrdem() {
        return listaOrdem;
    }

    public void addListaOrdem(OrdemPedido ordemPedido) {
        this.listaOrdem.add(ordemPedido);
    }
}
