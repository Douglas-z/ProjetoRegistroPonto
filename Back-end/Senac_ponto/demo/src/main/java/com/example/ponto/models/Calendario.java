package com.example.ponto.models;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Calendario extends EntityId {

    @Column
    private LocalDate data;
    @Column
    private boolean feriado;
    @Column
    private boolean finalDeSemana;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public boolean isFeriado() {
        return feriado;
    }

    public void setFeriado(boolean feriado) {
        this.feriado = feriado;
    }

    public boolean isFinalDeSemana() {
        return finalDeSemana;
    }

    public void setFinalDeSemana(boolean finalDeSemana) {
        this.finalDeSemana = finalDeSemana;
    }
}
