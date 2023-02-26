package io.github.brunoyillli.crudcidades.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.brunoyillli.crudcidades.entity.CidadeEntidade;

public interface CidadeRepository extends JpaRepository<CidadeEntidade, Long> { 

    public Optional<CidadeEntidade> findByNomeAndEstado(String nome, String estado);
}