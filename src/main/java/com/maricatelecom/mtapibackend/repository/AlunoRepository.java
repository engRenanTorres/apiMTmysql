package com.maricatelecom.mtapibackend.repository;



import com.maricatelecom.mtapibackend.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

  //quando começa com findby o spring faz query automaticamente
  List<Aluno> findByNomeAluno(String nomeAluno);

  //quando a query for feita por um atributo de um entidade, vem o nome da classe primeiro e depois o atributo procurado
  List<Aluno> findByEscola_NomeEscola(String nomeEscola);

  //se não usar o padrão de nomeclatura findBy precisa utilizar a @Query
  @Query("SELECT a FROM Aluno a WHERE a.escola.nomeEscola = :param OR a.nomeAluno = :param OR a.serie = :param")
  List<Aluno> getUserByAnyParam(String param);
}
