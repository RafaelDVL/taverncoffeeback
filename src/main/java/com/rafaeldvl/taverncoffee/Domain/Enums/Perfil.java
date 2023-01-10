package com.rafaeldvl.taverncoffee.Domain.Enums;

public enum Perfil {

    ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), ATENDENTE(2, "ROLE_CLIENTE");
    private Integer cod;
    private String descricao;

    Perfil(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }
    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Perfil toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Perfil p: Perfil.values()){
            if(cod.equals(p.getCod())){
                return p;
            }
        }
        throw new IllegalArgumentException("Códifo de Perfil invalido: " + cod);
    }
}
