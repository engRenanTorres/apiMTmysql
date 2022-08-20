package com.maricatelecom.mtapibackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TbMarTelecomEscola", schema = "MaricaTelecomTestes")
public class Escola {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int id;
  public String nomeEscola;

  @OneToMany(mappedBy = "escola")
  public List<Aluno> alunos;
 /*

  public String serie;

  public String turma;

  public String id_escola;*/

  public int getId() {
    return id;
  }

  public String getNomeEscola() {
    return nomeEscola;
  }

  public List<Aluno> getAlunos() {
    return alunos;
  }
}
