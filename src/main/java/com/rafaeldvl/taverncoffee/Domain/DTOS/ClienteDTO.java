package com.rafaeldvl.taverncoffee.Domain.DTOS;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rafaeldvl.taverncoffee.Domain.Enums.Perfil;
import com.rafaeldvl.taverncoffee.Domain.Models.Cliente;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ClienteDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotNull(message = "O campo NOME é obrigatorio!")
    private String nome;
    @CPF
    @NotNull(message = "O campo CPF é obrigatorio!")
    private String cpf;
    @NotNull(message = "O campo EMAIL é obrigatorio!")
    private String email;
    @NotNull(message = "O campo SENHA é obrigatorio!")
    private String senha;
    @NotNull(message = "O campo TELEFONE é obrigatorio!")
    private String telefone;
    @NotNull(message = "Endereço requerido!")
    private String endereco;
    private Set<Integer> perfil = new HashSet<>();
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime datacriacao = LocalDateTime.now();

    public ClienteDTO() {
        addPerfil(Perfil.CLIENTE);
    }

    public ClienteDTO(Cliente obj) {
        super();
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.senha = obj.getSenha();
        this.telefone = obj.getTelefone();
        this.endereco = obj.getEndereco();
        this.perfil = obj.getPerfil().stream().map(o -> o.getCod()).collect(Collectors.toSet());
        this.datacriacao = obj.getDatacriacao();
        this.addPerfil(Perfil.CLIENTE);
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
        return perfil.stream().map(o -> Perfil.toEnum(o)).collect(Collectors.toSet());
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
}
