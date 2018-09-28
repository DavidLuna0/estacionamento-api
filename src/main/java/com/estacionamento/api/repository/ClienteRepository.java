package com.estacionamento.api.repository;

import com.estacionamento.api.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Cliente findClienteById(long id);
}
