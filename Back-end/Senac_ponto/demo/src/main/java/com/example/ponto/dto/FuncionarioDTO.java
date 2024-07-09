package com.example.ponto.dto;

import com.example.ponto.models.Funcionario;

import java.time.LocalDate;

public class FuncionarioDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private LocalDate dataAdmissao;

    public FuncionarioDTO() {}

    public FuncionarioDTO(Long id, String nome, String cpf, String email, LocalDate dataAdmissao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataAdmissao = dataAdmissao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public static FuncionarioDTO fromEntity(Funcionario entity) {
        return new FuncionarioDTO(
                entity.getId(),
                entity.getNome(),
                entity.getCpf(),
                entity.getEmail(),
                entity.getDataAdmissao()
        );
    }

    public static Funcionario toEntity(FuncionarioDTO funcionarioDTO) {
        Funcionario entity = new Funcionario();
        entity.setId(funcionarioDTO.getId());
        entity.setNome(funcionarioDTO.getNome());
        entity.setCpf(funcionarioDTO.getCpf());
        entity.setEmail(funcionarioDTO.getEmail());
        entity.setDataAdmissao(funcionarioDTO.getDataAdmissao());
        return entity;
    }

    @Override
    public String toString() {
        return "FuncionarioDTO{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                '}';
    }
}
