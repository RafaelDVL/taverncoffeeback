package com.rafaeldvl.taverncoffee.Domain.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rafaeldvl.taverncoffee.Domain.DTOS.AtendenteDTO;
import com.rafaeldvl.taverncoffee.Domain.Enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Atendente extends Pessoa {
    private static final long serialVersionUID = 1L;
    @JsonIgnore
    @OneToMany(mappedBy = "atendente")
    private List<OrdemPedido> listaOrdem = new ArrayList<>();

    public Atendente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }
    public Atendente(Integer id, String nome, String cpf, String email, String senha, String telefone, String endereco) {
        super(id, nome, cpf, email, senha, telefone, endereco);
        addPerfil(Perfil.CLIENTE);
    }

    public Atendente(AtendenteDTO obj) {
        super();
        this.setId(obj.getId());
        this.setNome(obj.getNome());
        this.setCpf(obj.getCpf());
        this.setEmail(obj.getEmail());
        this.setSenha(obj.getSenha());
        this.setTelefone(obj.getTelefone());
        this.setEndereco(obj.getEndereco());
        this.perfil = obj.getPerfil().stream().map(Perfil::getCod).collect(Collectors.toSet());
        this.setDatacriacao(obj.getDatacriacao());
    }

    public List<OrdemPedido> getListaOrdem() {
        return listaOrdem;
    }

    public void setListaOrdem(List<OrdemPedido> ordemPedidos) {

        this.listaOrdem = ordemPedidos;
    }
}
