package com.rafaeldvl.taverncoffee.Domain.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rafaeldvl.taverncoffee.Domain.Enums.Prioridade;
import com.rafaeldvl.taverncoffee.Domain.Enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value = "O")
public class OrdemPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataAbertura = LocalDateTime.now();
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataFechamento;
    private String entrega;
    private Prioridade prioridade;
    private Status status;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "atendente_id")
    private Atendente atendente;

    @JsonIgnore
    @OneToMany(mappedBy = "ordemPedido", fetch = FetchType.EAGER)
    private List<ItemBill> itemBillList = new ArrayList<>();

    public OrdemPedido() {
        setPrioridade(Prioridade.MEDIA);
        setStatus(Status.ABERTO);
    }

    public OrdemPedido(Integer id, String entrega, Status status, Cliente cliente, Atendente atendente, Prioridade prioridade) {
        this.id = id;
        this.entrega = entrega;
        this.status = status;
        this.cliente = cliente;
        this.atendente = atendente;
        this.prioridade = prioridade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDateTime dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public LocalDateTime getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(LocalDateTime dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public List<ItemBill> getItemBillList() {
        return itemBillList;
    }

    public void addItemBillList(ItemBill itemNovo) {
        for(ItemBill item: itemBillList){
            if(item.getProduto().equals(itemNovo.getProduto())) {
                item.aumentarQuantidade(itemNovo.getQuantidade());
            }
        }
        this.itemBillList.add(itemNovo);
    }

    public void removeItemBillList(ItemBill itemNovo){
        for(ItemBill item: itemBillList){
            if(item.getProduto().equals(itemNovo.getProduto())) {
                this.itemBillList.remove(item);
            }
        }
    }
    public void setItemBillList(List<ItemBill> itemBillList) {
        this.itemBillList = itemBillList;
    }
}
