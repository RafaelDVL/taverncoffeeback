package com.rafaeldvl.taverncoffee.Domain.DTOS;

import com.rafaeldvl.taverncoffee.Domain.Models.ItemBill;
import com.rafaeldvl.taverncoffee.Domain.Models.OrdemPedido;
import com.rafaeldvl.taverncoffee.Domain.Models.Produto;

public class ItemBillDTO {
    private Integer id;
    private Integer ordemPedido;
    private String produto;
    private Integer quantidade;
    private Double valorTotalItem;

    public ItemBillDTO(Integer id, OrdemPedido ordemPedido, Produto produto, Integer quantidade, Double valorTotalItem) {
        this.id = id;
        this.ordemPedido = ordemPedido.getId();
        this.produto = produto.getNome();
        this.quantidade = quantidade;
        this.valorTotalItem = valorTotalItem;
    }

    public ItemBillDTO(ItemBill obj) {
        this.id = obj.getId();
        this.ordemPedido = obj.getOrdemPedido().getId();
        this.produto = obj.getProduto().getNome();
        this.quantidade = obj.getQuantidade();
        this.valorTotalItem = obj.getValorTotalItem();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrdemPedido() {
        return ordemPedido;
    }

    public void setOrdemPedido(Integer ordemPedido) {
        this.ordemPedido = ordemPedido;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
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

    public void setValorTotalItem(Double valorTotalItem) {
        this.valorTotalItem = valorTotalItem;
    }
}
