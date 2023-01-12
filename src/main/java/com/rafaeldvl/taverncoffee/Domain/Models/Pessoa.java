package com.rafaeldvl.taverncoffee.Domain.Models;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafaeldvl.taverncoffee.Domain.Enums.Perfil;

import javax.persistence.*;
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



    private String nome;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String email;
    private String senha;
    private String telefone;
    private String endereco;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "PERFIS")
    Set<Integer> perfil = new HashSet<>();

    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime datacriacao = LocalDateTime.now();

    public Pessoa() {
        addPerfil(Perfil.CLIENTE);
    }

    public Pessoa(Integer id, String nome, String cpf, String email, String senha, String telefone, String endereco) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
        this.endereco = endereco;
        addPerfil(Perfil.CLIENTE);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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
        return Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome) && Objects.equals(cpf, pessoa.cpf) && Objects.equals(email, pessoa.email) && Objects.equals(senha, pessoa.senha) && Objects.equals(telefone, pessoa.telefone) && Objects.equals(endereco, pessoa.endereco) && Objects.equals(perfil, pessoa.perfil) && Objects.equals(datacriacao, pessoa.datacriacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, email, senha, telefone, endereco, perfil, datacriacao);
    }
}
