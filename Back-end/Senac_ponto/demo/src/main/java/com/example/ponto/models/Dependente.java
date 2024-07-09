package com.example.ponto.models;

import com.example.ponto.models.enums.Escolaridade;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

@Entity
public class Dependente extends EntityId {

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
    @Column
    private String nomeDependentes;
    @Column
    private Escolaridade escolaridade;
    @Column
    private LocalDate dataNascimento;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public String getNomeDependentes() {
        return nomeDependentes;
    }

    public void setNomeDependentes(String nomeDependentes) {
        this.nomeDependentes = nomeDependentes;
    }

    public Escolaridade getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Dependentes{" +
                "nomeDependentes='" + nomeDependentes + '\'' +
                ", escolaridade=" + escolaridade +
                ", dataNascimento=" + dataNascimento +
                '}';
    }
}
