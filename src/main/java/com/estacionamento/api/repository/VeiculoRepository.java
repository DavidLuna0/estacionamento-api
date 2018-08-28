package com.estacionamento.api.repository;

import com.estacionamento.api.models.Veiculo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

  Veiculo findById(long id);

}