package com.estacionamento.api.repository;

import com.estacionamento.api.models.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

  Empresa findEmpresaById(long id);

}