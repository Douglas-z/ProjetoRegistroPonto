package com.example.ponto.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Filiacao extends EntityId {

    @Column
    private String nomeMae;
    @Column
    private String nomePai;
    @Column
    private String telPai;
    @Column
    private String telMae;

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getTelPai() {
        return telPai;
    }

    public void setTelPai(String telPai) {
        this.telPai = telPai;
    }

    public String getTelMae() {
        return telMae;
    }

    public void setTelMae(String telMae) {
        this.telMae = telMae;
    }

    @Override
    public String toString() {
        return "Filiacao{" +
                "nomeMae='" + nomeMae + '\'' +
                ", nomePai='" + nomePai + '\'' +
                ", telPai='" + telPai + '\'' +
                ", telMae='" + telMae + '\'' +
                '}';
    }
}
