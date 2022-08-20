package com.maricatelecom.mtapibackend.model;

import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "TbMarTelecomMensagemApp", schema = "MaricaTelecomTestes")
public class Message {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Nullable
  private String midia;
  @Nullable
  private String foto;
  @Nullable
  private String mensagem;
  @Nullable
  private String pdf;
  @Nullable
  private String mensagem_instante;
  @Nullable
  private int tempo_exibicao;

  public int getId() {
    return id;
  }
  public String getMidia() {
    return midia;
  }

  public String getFoto() {
    return foto;
  }

  public String getMensagem() {
    return mensagem;
  }

  public String getPdf() {
    return pdf;
  }

  public String getMensagem_instante() {
    return mensagem_instante;
  }

  public int getTempo_exibicao() {
    return tempo_exibicao;
  }
}
