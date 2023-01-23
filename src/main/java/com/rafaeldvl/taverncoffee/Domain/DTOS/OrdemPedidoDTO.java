package com.rafaeldvl.taverncoffee.Domain.DTOS;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafaeldvl.taverncoffee.Domain.Models.ItemBill;
import com.rafaeldvl.taverncoffee.Domain.Models.OrdemPedido;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class OrdemPedidoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataAbertura;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime dataFechamento;
    @NotBlank
    private String entrega;
    private Integer prioridade;
    private Integer status;
    private List<ItemBill> itemBillList;
    private Integer cliente;
    private Integer atendente;
    private String nomeAtendente;
    private String nomeCliente;


    public OrdemPedidoDTO() {
        super();
    }

    public OrdemPedidoDTO(OrdemPedido obj) {
        this.id = obj.getId();
        this.dataAbertura = obj.getDataAbertura();
        this.dataFechamento = obj.getDataFechamento();
        this.entrega = obj.getEntrega();
        this.prioridade = obj.getPrioridade().getCod();
        this.status = obj.getStatus().getCod();
        this.itemBillList = obj.getItemBillList();
        this.cliente = obj.getCliente().getId();
        this.atendente = obj.getAtendente().getId();
        this.nomeAtendente = obj.getAtendente().getNome();
        this.nomeCliente = obj.getCliente().getNome();
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

    public Integer getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Integer prioridade) {
        this.prioridade = prioridade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ItemBill> getItemBillList() {
        return itemBillList;
    }

    public void setItemBillList(List<ItemBill> itemBillList) {
        this.itemBillList = itemBillList;
    }


    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getAtendente() {
        return atendente;
    }

    public void setAtendente(Integer atendente) {
        this.atendente = atendente;
    }

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public void setNomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

}
