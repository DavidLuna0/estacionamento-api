package com.estacionamento.api.repository;

import com.estacionamento.api.models.Patio;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PatioRepository extends JpaRepository<Patio, Long> {

  Patio findPatioById(long id);

}