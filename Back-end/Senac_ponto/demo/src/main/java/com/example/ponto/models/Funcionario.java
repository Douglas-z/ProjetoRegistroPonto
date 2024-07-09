package com.example.ponto.models;

import com.example.ponto.models.domain.RegistroPonto;
import com.example.ponto.models.enums.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity(name = "funcionario")
public class Funcionario extends EntityId {

  @Column
  private String nome;

  @Column
  private String cpf;

  @Column
  private String rg;

  @Column
  private String endereco;

  @Column
  private String ctbs;

  @Column
  private Double salarioContratual;

  @Column
  private Integer cargaHoraria;

  @Enumerated(EnumType.STRING)
  private ModalidadeContratual modalidadeContratual;

  @Column
  private String telefone;

  @Enumerated(EnumType.STRING)
  private EstadoCivil estadoCivil;

  @Column
  private String tituloEleitor;

  @Column
  private String reservista;

  @Column
  private LocalDate dataNasc;

  @Column
  private String pisPasep;

  @Column
  private String registroProfissional;

  @Column
  private String email;

  @Column
  private String sindicato;

  @Column
  private String setor;

  @Column
  private String cnh;

  @Column
  private LocalDate dataAdmissao;

  @ManyToOne
  @JoinColumn(name = "cargo_id")
  private Cargo cargo;

  @ManyToOne
  @JoinColumn(name = "filiacao_id")
  private Filiacao filiacao;

  @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
  private List<Dependente> dependentes;

  @Column
  private String racaCor;

  @Column
  private String religiao;

  @Column
  private Boolean doadorSangue;

  @Enumerated(EnumType.STRING)
  private Genero genero;

  @Enumerated(EnumType.STRING)
  private Turno turno;

  @Column
  private String nacionalidade;

  @Column
  private String redeSocial;

  @Column
  private String areaAtuacao;

  @Column
  private String matricula;

  @Enumerated(EnumType.STRING)
  private Status status;

  @Column
  private String idioma;

  @Column
  private Integer horaExtra;

  @Column
  private LocalTime horaEntrada;

  @Column
  private LocalTime horaSaida;

  @OneToMany(mappedBy = "funcionario")
  private List<Permissoes> permissoes;

  @OneToMany(mappedBy = "funcionario")
  private List<RegistroPonto> registrosPonto;

  public List<RegistroPonto> getRegistrosPonto() {
    return registrosPonto;
  }

  public void setRegistrosPonto(List<RegistroPonto> registrosPonto) {
    this.registrosPonto = registrosPonto;
  }


  public List<Permissoes> getPermissoes() {
    return permissoes;
  }

  public void setPermissoes(List<Permissoes> permissoes) {
    this.permissoes = permissoes;
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

  public String getRg() {
    return rg;
  }

  public void setRg(String rg) {
    this.rg = rg;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public String getCtbs() {
    return ctbs;
  }

  public void setCtbs(String ctbs) {
    this.ctbs = ctbs;
  }

  public Integer getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(Integer cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  public Double getSalarioContratual() {
    return salarioContratual;
  }

  public void setSalarioContratual(Double salarioContratual) {
    this.salarioContratual = salarioContratual;
  }

  public ModalidadeContratual getModalidadeContratual() {
    return modalidadeContratual;
  }

  public void setModalidadeContratual(ModalidadeContratual modalidadeContratual) {
    this.modalidadeContratual = modalidadeContratual;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public EstadoCivil getEstadoCivil() {
    return estadoCivil;
  }

  public void setEstadoCivil(EstadoCivil estadoCivil) {
    this.estadoCivil = estadoCivil;
  }

  public String getTituloEleitor() {
    return tituloEleitor;
  }

  public void setTituloEleitor(String tituloEleitor) {
    this.tituloEleitor = tituloEleitor;
  }

  public String getReservista() {
    return reservista;
  }

  public void setReservista(String reservista) {
    this.reservista = reservista;
  }

  public LocalDate getDataNasc() {
    return dataNasc;
  }

  public void setDataNasc(LocalDate dataNasc) {
    this.dataNasc = dataNasc;
  }

  public String getPisPasep() {
    return pisPasep;
  }

  public void setPisPasep(String pisPasep) {
    this.pisPasep = pisPasep;
  }

  public String getRegistroProfissional() {
    return registroProfissional;
  }

  public void setRegistroProfissional(String registroProfissional) {
    this.registroProfissional = registroProfissional;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSindicato() {
    return sindicato;
  }

  public void setSindicato(String sindicato) {
    this.sindicato = sindicato;
  }

  public String getSetor() {
    return setor;
  }

  public void setSetor(String setor) {
    this.setor = setor;
  }

  public String getCnh() {
    return cnh;
  }

  public void setCnh(String cnh) {
    this.cnh = cnh;
  }

  public LocalDate getDataAdmissao() {
    return dataAdmissao;
  }

  public void setDataAdmissao(LocalDate dataAdmissao) {
    this.dataAdmissao = dataAdmissao;
  }

  public Cargo getCargo() {
    return cargo;
  }

  public void setCargo(Cargo cargo) {
    this.cargo = cargo;
  }

  public List<Dependente> getDependentes() {
    return dependentes;
  }

  public void setDependentes(List<Dependente> dependentes) {
    this.dependentes = dependentes;
  }

  public Filiacao getFiliacao() {
    return filiacao;
  }

  public void setFiliacao(Filiacao filiacao) {
    this.filiacao = filiacao;
  }

  public String getRacaCor() {
    return racaCor;
  }

  public void setRacaCor(String racaCor) {
    this.racaCor = racaCor;
  }

  public String getReligiao() {
    return religiao;
  }

  public void setReligiao(String religiao) {
    this.religiao = religiao;
  }

  public Boolean getDoadorSangue() {
    return doadorSangue;
  }

  public void setDoadorSangue(Boolean doadorSangue) {
    this.doadorSangue = doadorSangue;
  }

  public Genero getGenero() {
    return genero;
  }

  public void setGenero(Genero genero) {
    this.genero = genero;
  }

  public Turno getTurno() {
    return turno;
  }

  public void setTurno(Turno turno) {
    this.turno = turno;
  }

  public String getNacionalidade() {
    return nacionalidade;
  }

  public void setNacionalidade(String nacionalidade) {
    this.nacionalidade = nacionalidade;
  }

  public String getRedeSocial() {
    return redeSocial;
  }

  public void setRedeSocial(String redeSocial) {
    this.redeSocial = redeSocial;
  }

  public String getAreaAtuacao() {
    return areaAtuacao;
  }

  public void setAreaAtuacao(String areaAtuacao) {
    this.areaAtuacao = areaAtuacao;
  }

  public String getMatricula() {
    return matricula;
  }

  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getIdioma() {
    return idioma;
  }

  public void setIdioma(String idioma) {
    this.idioma = idioma;
  }

  public Integer getHoraExtra() {
    return horaExtra;
  }

  public void setHoraExtra(Integer horaExtra) {
    this.horaExtra = horaExtra;
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

  @Override
  public String toString() {
    return "Funcionario{" +
            "nome='" + nome + '\'' +
            ", cpf='" + cpf + '\'' +
            ", rg='" + rg + '\'' +
            ", endereco='" + endereco + '\'' +
            ", ctbs='" + ctbs + '\'' +
            ", salarioContratual=" + salarioContratual +
            ", cargaHoraria=" + cargaHoraria +
            ", modalidadeContratual=" + modalidadeContratual +
            ", telefone='" + telefone + '\'' +
            ", estadoCivil=" + estadoCivil +
            ", tituloEleitor='" + tituloEleitor + '\'' +
            ", reservista='" + reservista + '\'' +
            ", dataNasc=" + dataNasc +
            ", pisPasep='" + pisPasep + '\'' +
            ", registroProfissional='" + registroProfissional + '\'' +
            ", email='" + email + '\'' +
            ", sindicato='" + sindicato + '\'' +
            ", setor='" + setor + '\'' +
            ", cnh='" + cnh + '\'' +
            ", dataAdmissao=" + dataAdmissao +
            ", cargo=" + cargo +
            ", filiacao=" + filiacao +
            ", dependentes=" + dependentes +
            ", racaCor='" + racaCor + '\'' +
            ", religiao='" + religiao + '\'' +
            ", doadorSangue=" + doadorSangue +
            ", genero=" + genero +
            ", turno=" + turno +
            ", nacionalidade='" + nacionalidade + '\'' +
            ", redeSocial='" + redeSocial + '\'' +
            ", areaAtuacao='" + areaAtuacao + '\'' +
            ", matricula='" + matricula + '\'' +
            ", status=" + status +
            ", idioma='" + idioma + '\'' +
            ", horaExtra=" + horaExtra +
            ", horaEntrada=" + horaEntrada +
            ", horaSaida=" + horaSaida +
            ", permissoes=" + permissoes +
            '}';
  }
}