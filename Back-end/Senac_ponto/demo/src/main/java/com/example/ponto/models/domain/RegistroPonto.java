package com.example.ponto.models.domain;

import com.example.ponto.models.EntityId;
import com.example.ponto.models.Funcionario;
import com.example.ponto.models.enums.TipoRegistro;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class RegistroPonto extends EntityId {

    @Column(name = "data_hora")
    private LocalDateTime dataHora;
    @Column(name = "hora_ponto", nullable = false)
    private LocalDateTime horaPonto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_registro", nullable = false)
    private TipoRegistro tipoRegistro;

    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDateTime getHoraPonto() {
        return horaPonto;
    }

    public void setHoraPonto(LocalDateTime horaBatida) {
        this.horaPonto = horaBatida;
    }

    public TipoRegistro getTipoRegistro() {
        return tipoRegistro;
    }

    public void setTipoRegistro(TipoRegistro tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }

    @Override
    public String toString() {
        return "RegistroPonto{" +
                "horaPonto=" + horaPonto +
                ", tipoRegistro=" + tipoRegistro +
                ", funcionario=" + funcionario +
                '}';
    }
}
