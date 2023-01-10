package com.rafaeldvl.taverncoffee.Domain.Models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Atendente extends Pessoa {

    private static final long serialVersionUID = 1L;
    @OneToMany(mappedBy = "atendente")
    private List<OrdemPedido> listaOrdem = new ArrayList<>();

    public Atendente() {
    }

    public Atendente(Integer id, String cpf, String email, String senha, String telefone, String endereco) {
        super(id, cpf, email, senha, telefone, endereco);
    }

    public List<OrdemPedido> getListaOrdem() {
        return listaOrdem;
    }

    public void setListaOrdem(List<OrdemPedido> listaOrdem) {
        this.listaOrdem = listaOrdem;
    }
}
