package com.rafaeldvl.taverncoffee.Domain.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rafaeldvl.taverncoffee.Domain.Enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Atendente extends Pessoa {
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @OneToMany(mappedBy = "atendente")
    private List<OrdemPedido> listaOrdem = new ArrayList<>();

    public Atendente() {
        addPerfil(Perfil.ATENDENTE);
    }
    public Atendente(Integer id, String nome, String cpf, String email, String senha, String telefone, String endereco) {
        super(id, nome, cpf, email, senha, telefone, endereco);
        addPerfil(Perfil.ATENDENTE);
    }
    public List<OrdemPedido> getListaOrdem() {
        return listaOrdem;
    }

    public void addListaOrdem(OrdemPedido ordemPedido) {
        this.listaOrdem.add(ordemPedido);
    }
}
