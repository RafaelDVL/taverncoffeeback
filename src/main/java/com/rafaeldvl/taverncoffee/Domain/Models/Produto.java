package com.rafaeldvl.taverncoffee.Domain.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rafaeldvl.taverncoffee.Domain.DTOS.ProdutoDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Produto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer estoque;
    private Double preco;
    private String nome;
    private String urlImage;
    private String observacoes;

    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<ItemBill> itemBillList;


    public Produto() {
    }

    public Produto(Integer id, Integer estoque, Double preco, String nome, String urlImage, String observacoes) {
        this.id = id;
        this.estoque = estoque;
        this.preco = preco;
        this.nome = nome;
        this.urlImage = urlImage;
        this.observacoes = observacoes;
    }

    public Produto(ProdutoDTO objDTO) {
        this.id = objDTO.getId();
        this.estoque = objDTO.getEstoque();
        this.preco = objDTO.getPreco();
        this.nome = objDTO.getNome();
        this.urlImage = objDTO.getUrlImage();
        this.observacoes = objDTO.getObservacoes();
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
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

    public List<ItemBill> getItemBillList() {
        return itemBillList;
    }

    public void setItemBillList(List<ItemBill> itemBillList) {
        this.itemBillList = itemBillList;
    }
}
