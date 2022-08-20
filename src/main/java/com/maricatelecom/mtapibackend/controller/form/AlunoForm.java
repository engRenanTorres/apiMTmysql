package com.maricatelecom.mtapibackend.controller.form;


import com.maricatelecom.mtapibackend.model.Aluno;
import com.maricatelecom.mtapibackend.model.Escola;
import com.maricatelecom.mtapibackend.repository.EscolaRepository;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;

public class AlunoForm {
  @NotNull
  @NotEmpty @Length(max = 100)
  private String nomeAluno;
  @Max(1)
  private Integer statusAluno;

  private String serie;

  private String mensagem;
  @ManyToOne
  @Nullable
  private String nomeEscola;

  public AlunoForm() {
  }

  public Aluno converter(EscolaRepository escolaRepository) {
    Escola escola = escolaRepository.findByNomeEscola(nomeEscola);
    return new Aluno(nomeAluno, statusAluno,serie,mensagem,escola);
  }

  public String getNomeAluno() {
    return nomeAluno;
  }

  public void setNomeAluno(String nomeAluno) {
    this.nomeAluno = nomeAluno;
  }

  public int getStatusAluno() {
    return statusAluno;
  }

  public void setStatusAluno(int statusAluno) {
    this.statusAluno = statusAluno;
  }

  @Nullable
  public String getSerie() {
    return serie;
  }

  public void setSerie(@Nullable String serie) {
    this.serie = serie;
  }

  @Nullable
  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(@Nullable String mensagem) {
    this.mensagem = mensagem;
  }

  @Nullable
  public String getNomeEscola() {
    return nomeEscola;
  }

  public void setNomeEscola(@Nullable String nomeEscola) {
    this.nomeEscola = nomeEscola;
  }
}
