package com.rafaeldvl.taverncoffee.Domain.Models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa{

    private static final long serialVersionUID = 1L;

    @OneToMany(mappedBy = "cliente")
    List<OrdemPedido> listaOrdem = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(Integer id, String nome, String cpf, String email, String senha, String telefone, String endereco) {
        super(id, nome, cpf, email, senha, telefone, endereco);
    }

    public List<OrdemPedido> getListaOrdem() {
        return listaOrdem;
    }

    public void setListaOrdem(List<OrdemPedido> listaOrdem) {
        this.listaOrdem = listaOrdem;
    }
}
