package com.rafaeldvl.taverncoffee.Domain.Models;

import com.rafaeldvl.taverncoffee.Domain.Enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Pessoa implements Serializable {


    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    private String email;
    private String senha;
    private String telefone;
    private String endereço;
    private Set<Integer> perfil = new HashSet<>();
    private LocalDateTime datacriacao = LocalDateTime.now();

    public Pessoa() {
        addPerfil(Perfil.CLIENTE);
    }

    public Pessoa(Integer id, String cpf, String email, String senha, String telefone, String endereço) {
        this.id = id;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereço = endereço;
        addPerfil(Perfil.CLIENTE);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public Set<Perfil> getPerfil() {
        return perfil.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void addPerfil(Perfil perfil) {
        this.perfil.add(perfil.getCod());
    }

    public LocalDateTime getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(LocalDateTime datacriacao) {
        this.datacriacao = datacriacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(email, pessoa.email) && Objects.equals(senha, pessoa.senha) && Objects.equals(telefone, pessoa.telefone) && Objects.equals(endereço, pessoa.endereço) && Objects.equals(perfil, pessoa.perfil) && Objects.equals(datacriacao, pessoa.datacriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpf, email, senha, telefone, endereço, perfil, datacriacao);
    }
}
