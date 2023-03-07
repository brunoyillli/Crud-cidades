package io.github.brunoyillli.crudcidades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.brunoyillli.crudcidades.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Usuario findByNome(String nome);
}
