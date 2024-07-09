package com.example.ponto.models.domain;

import com.example.ponto.models.EntityId;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class HorarioTrabalho extends EntityId {

    @Column(name = "hora_entrada", nullable = false)
    private LocalTime horaEntrada;
    @Column(name = "hora_saida", nullable = false)
    private LocalTime horaSaida;
    @Column(name = "hora_intervalo", nullable = false)
    private LocalTime horaIntervalo;
    @Column(name = "dias_trabalhados", nullable = false)
    private String diasTrabalhados;

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public LocalTime getHoraIntervalo() {
        return horaIntervalo;
    }

    public void setHoraIntervalo(LocalTime horaIntervalo) {
        this.horaIntervalo = horaIntervalo;
    }

    public String getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(String diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    @Override
    public String toString() {
        return "HorarioTrabalho{" +
                "horaPadraoEntrada=" + horaEntrada +
                ", horaPadraoSaida=" + horaSaida +
                ", horaPadraoIntervalo=" + horaIntervalo +
                ", diasTrabalhados='" + diasTrabalhados + '\'' +
                '}';
    }
}
