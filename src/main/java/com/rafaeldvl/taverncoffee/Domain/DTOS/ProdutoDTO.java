package com.rafaeldvl.taverncoffee.Domain.DTOS;

import com.rafaeldvl.taverncoffee.Domain.Models.OrdemPedido;
import com.rafaeldvl.taverncoffee.Domain.Models.Produto;

import java.io.Serializable;
import java.util.List;

public class ProdutoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private Integer estoque;

    private Double preco;
    private String nome;
    private String urlImage;
    private String observacoes;

    private List<OrdemPedido> listaOrdem;

    public ProdutoDTO() {
    }
    public ProdutoDTO(Produto obj) {
        this.id = obj.getId();
        this.estoque = obj.getEstoque();
        this.preco = obj.getPreco();
        this.nome = obj.getNome();
        this.urlImage = obj.getUrlImage();
        this.observacoes = obj.getObservacoes();
        this.listaOrdem= obj.getListaOrdem();
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

    public List<OrdemPedido> getListaOrdem() {
        return listaOrdem;
    }

    public void setListaOrdem(List<OrdemPedido> listaOrdem) {
        this.listaOrdem = listaOrdem;
    }
}
