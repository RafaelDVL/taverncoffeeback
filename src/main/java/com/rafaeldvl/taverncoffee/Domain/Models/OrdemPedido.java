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
import java.util.Objects;

@Entity
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

    @JsonIgnore
    @ElementCollection
    @JoinTable(name = "ordempedido_produtos", joinColumns = {@JoinColumn(name ="ordempedido_id")}, inverseJoinColumns = {@JoinColumn(name = "produto_id")})
    private List<Produto> listaProduto = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "atendente_id")
    private Atendente atendente;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Produto> getListaProduto() {
        return listaProduto;
    }

    public void addListaProduto(Produto Produto) {
        this.listaProduto.add(Produto);
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

    public Prioridade getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Prioridade prioridade) {
        this.prioridade = prioridade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemPedido that = (OrdemPedido) o;
        return Objects.equals(id, that.id) && Objects.equals(dataAbertura, that.dataAbertura) && Objects.equals(dataFechamento, that.dataFechamento) && Objects.equals(entrega, that.entrega) && prioridade == that.prioridade && status == that.status && Objects.equals(listaProduto, that.listaProduto) && Objects.equals(cliente, that.cliente) && Objects.equals(atendente, that.atendente);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, dataAbertura, dataFechamento, entrega, prioridade, status, listaProduto, cliente, atendente);
    }
}
