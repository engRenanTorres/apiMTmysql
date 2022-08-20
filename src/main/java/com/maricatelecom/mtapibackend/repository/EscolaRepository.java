package com.maricatelecom.mtapibackend.repository;


import com.maricatelecom.mtapibackend.model.Escola;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EscolaRepository extends JpaRepository<Escola, Integer> {
  Escola findByNomeEscola(String nomeEscola);
}
