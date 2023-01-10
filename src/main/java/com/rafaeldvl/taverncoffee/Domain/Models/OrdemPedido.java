package com.rafaeldvl.taverncoffee.Domain.Models;

import com.rafaeldvl.taverncoffee.Domain.Enums.Status;

import java.time.LocalDateTime;

public class OrdemPedido {

    private Integer id;
    private LocalDateTime dataAbertura = LocalDateTime.now();
    private LocalDateTime dataFechamento;
    private String entrega;
    private Status status;
    private List<Produto> listaProduto;

}
