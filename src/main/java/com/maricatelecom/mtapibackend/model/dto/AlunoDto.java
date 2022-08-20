package com.maricatelecom.mtapibackend.model.dto;


import com.maricatelecom.mtapibackend.model.Aluno;

import java.util.List;
import java.util.stream.Collectors;

public class AlunoDto {
  private int id;
  private String nome_aluno;
  private String mensagem;

  public AlunoDto(Aluno aluno) {
    this.id = aluno.getId();
    this.nome_aluno = aluno.getNomeAluno();
    this.mensagem = aluno.getMensagem();
  }

  public static List<AlunoDto> converter(List<Aluno> alunos) {
/*    List<AlunoDto> alunoDtos = new ArrayList<>();
    for (var aluno:
         alunos) {
        alunoDtos.add(new AlunoDto(aluno));
    }
    return alunoDtos;*/
    return alunos.stream().map(AlunoDto::new).collect(Collectors.toList());
  }

  public int getId() {
    return id;
  }

  public String getNome_aluno() {
    return nome_aluno;
  }

  public String getMensagem() {
    return mensagem;
  }
}
