package com.maricatelecom.mtapibackend.controller;

import com.maricatelecom.mtapibackend.controller.form.AlunoForm;
import com.maricatelecom.mtapibackend.model.Aluno;
import com.maricatelecom.mtapibackend.model.dto.AlunoDto;
import com.maricatelecom.mtapibackend.repository.AlunoRepository;
import com.maricatelecom.mtapibackend.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UsuarioController {

  @Autowired
  private AlunoRepository alunoRepository;
  @Autowired
  private EscolaRepository escolaRepository;

  @GetMapping ("/apiTodosUsuarios")
  public List<AlunoDto> getAllUser(){
    List<Aluno> alunos = alunoRepository.findAll();
    return AlunoDto.converter(alunos);
  }

  @GetMapping ("/apiUsuario")
  public List<AlunoDto> getUser(String param){
    if(param == null) {
      List<Aluno> alunos = alunoRepository.findAll();
      return AlunoDto.converter(alunos);
    }
    else {
      List<Aluno> alunos = alunoRepository.getUserByAnyParam(param);
      return AlunoDto.converter(alunos);
    }
  }

  @GetMapping ("/apiUsuarioPorNome")
  public List<AlunoDto> getUserByName(String nomeAluno){
    if(nomeAluno == null) {
      List<Aluno> alunos = alunoRepository.findAll();
      return AlunoDto.converter(alunos);
    }
    else {
      List<Aluno> alunos = alunoRepository.findByNomeAluno(nomeAluno);
      return AlunoDto.converter(alunos);
    }
  }
  @GetMapping ("/apiUsuarioPorEscola")
  public List<AlunoDto> getUserBySchool(String nomeEscola){
    if(nomeEscola == null) {
      List<Aluno> alunos = alunoRepository.findAll();
      return AlunoDto.converter(alunos);
    }
    else {
      List<Aluno> alunos = alunoRepository.findByEscola_NomeEscola(nomeEscola);
      return AlunoDto.converter(alunos);
    }
  }

  @PostMapping("/apiUsuario")
  public ResponseEntity<AlunoDto> activeUser(@RequestBody @Valid AlunoForm alunoForm, UriComponentsBuilder uriBuilder) {
    Aluno alunoPost = alunoForm.converter(escolaRepository);
    alunoRepository.save(alunoPost);
    URI uri = uriBuilder.path("/apiUsuario/{id}").buildAndExpand(alunoPost.getId()).toUri();
    return ResponseEntity.created(uri).body(new AlunoDto(alunoPost));
  }

/*  @GetMapping ("/apiUsuarioDados")
  public List<AlunoDto> getUserData(){
    return AlunoDto.converter(Arrays.asList(alunos));
  }*/

}
