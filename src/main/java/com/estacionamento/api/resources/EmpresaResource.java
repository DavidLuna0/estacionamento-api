package com.estacionamento.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estacionamento.api.models.Empresa;
import com.estacionamento.api.repository.EmpresaRepository;


@RestController
@RequestMapping(value = "/api")
public class EmpresaResource {

  @Autowired
  EmpresaRepository empresaRepository;

  @GetMapping("/empresas")
  public List<Empresa> listaEmpresas() {
    return empresaRepository.findAll();
  }

  @GetMapping("/empresa/{id}")
  public Empresa listaEmpresaPorId(@PathVariable(value = "id") long id) {
    return empresaRepository.findEmpresaById(id);
  }

  @PostMapping("/empresa")
  public Empresa salvEmpresa(@RequestBody Empresa empresa) {
    return empresaRepository.save(empresa);
  }

  @DeleteMapping("/empresa")
  public void deletaEmpresa(@RequestBody Empresa empresa) {
    empresaRepository.delete(empresa);
  }

  @PutMapping("/empresa")
  public Empresa atualizaEmpresa(@RequestBody Empresa empresa) {
    return empresaRepository.save(empresa);
  }

}