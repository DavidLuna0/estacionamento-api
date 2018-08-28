package com.estacionamento.api.repository;

import com.estacionamento.api.models.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

  Usuario findUsuarioById(long id);

}