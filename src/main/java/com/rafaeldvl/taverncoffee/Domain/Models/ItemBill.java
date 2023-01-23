package com.rafaeldvl.taverncoffee.Domain.Models;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ItemBill implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "ordem_pedido_id")
    private OrdemPedido ordemPedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private Integer quantidade;
    private Double valorTotalItem;
    public ItemBill() {
    }
    public ItemBill(OrdemPedido ordemPedido, Produto produto, Integer quantidade) {
        this.ordemPedido = ordemPedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotalItem = quantidade * produto.getPreco();
    }

    public ItemBill(Integer id,OrdemPedido ordemPedido, Produto produto, Integer quantidade) {
        this.id = id;
        this.ordemPedido = ordemPedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorTotalItem = quantidade * produto.getPreco();
    }
    public void aumentarQuantidade(Integer valor) {
        this.quantidade += valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrdemPedido getOrdemPedido() {
        return ordemPedido;
    }

    public void setOrdemPedido(OrdemPedido ordemPedido) {
        this.ordemPedido = ordemPedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValorTotalItem() {
        return valorTotalItem;
    }

}
