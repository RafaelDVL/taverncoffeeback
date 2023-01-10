package com.rafaeldvl.taverncoffee.Domain.Enums;

public enum Status {
    ABERTO(0, "ABERTO"),
    ANDAMENTO(1, "PRODUZINDO"),
    FECHADO(2, "FECHADO");

    private Integer cod;
    private String descricao;

    Status(Integer cod, String descricao) {
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

    public static Status toEnum(Integer cod){
        if(cod == null){
            return null;
        }
        for(Status o : Status.values()){
            if(cod.equals(o.getCod())){
                return o;
            }
        }
        throw new IllegalArgumentException("Status :" + cod);
    }
}
