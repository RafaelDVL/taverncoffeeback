package com.rafaeldvl.taverncoffee.Domain.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rafaeldvl.taverncoffee.Domain.Enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa{
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<OrdemPedido> listaOrdem = new ArrayList<>();

    public Cliente() {
        addPerfil(Perfil.CLIENTE);
    }
    public Cliente(Integer id, String nome, String cpf, String email, String senha, String telefone, String endereco) {
        super(id, nome, cpf, email, senha, telefone, endereco);
        addPerfil(Perfil.CLIENTE);
    }
    public List<OrdemPedido> getListaOrdem() {
        return listaOrdem;
    }

    public void addListaOrdem(OrdemPedido ordemPedidos) {
        this.listaOrdem.add(ordemPedidos);
    }
}
