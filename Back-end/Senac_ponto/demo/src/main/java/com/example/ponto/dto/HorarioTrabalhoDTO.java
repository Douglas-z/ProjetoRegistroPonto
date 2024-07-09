package com.example.ponto.dto;

import com.example.ponto.models.domain.HorarioTrabalho;

import java.time.LocalTime;

public class HorarioTrabalhoDTO {

    private Long id;
    private LocalTime horaEntrada;
    private LocalTime horaSaida;
    private LocalTime horaIntervalo;
    private String diasTrabalhados;

    public HorarioTrabalhoDTO() {
    }

    public HorarioTrabalhoDTO(Long id, LocalTime horaEntrada, LocalTime horaSaida, LocalTime horaIntervalo, String diasTrabalhados) {
        this.id = id;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.horaIntervalo = horaIntervalo;
        this.diasTrabalhados = diasTrabalhados;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public static HorarioTrabalhoDTO fromEntity(HorarioTrabalho entity) {
        return new HorarioTrabalhoDTO(
                entity.getId(),
                entity.getHoraEntrada(),
                entity.getHoraSaida(),
                entity.getHoraIntervalo(),
                entity.getDiasTrabalhados()
        );
    }

    public HorarioTrabalho toEntity() {
        HorarioTrabalho entity = new HorarioTrabalho();
        entity.setId(this.id);
        entity.setHoraEntrada(this.horaEntrada);
        entity.setHoraSaida(this.horaSaida);
        entity.setHoraIntervalo(this.horaIntervalo);
        entity.setDiasTrabalhados(this.diasTrabalhados);
        return entity;
    }

    @Override
    public String toString() {
        return "HorarioTrabalhoDTO{" +
                "id=" + id +
                ", horaEntrada=" + horaEntrada +
                ", horaSaida=" + horaSaida +
                ", horaIntervalo=" + horaIntervalo +
                ", diasTrabalhados='" + diasTrabalhados + '\'' +
                '}';
    }
}
