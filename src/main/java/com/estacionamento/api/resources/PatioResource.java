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
import com.estacionamento.api.models.Patio;
import com.estacionamento.api.repository.EmpresaRepository;
import com.estacionamento.api.repository.PatioRepository;

@RestController
@RequestMapping(value = "/api")
public class PatioResource {

  @Autowired
  PatioRepository patioRepository;

  @Autowired
  EmpresaRepository empresaRepository;

  @GetMapping("/patios")
  public List<Patio> listaPatios() {
    return patioRepository.findAll();
  }

  @GetMapping("/patio/{id}")
  public Patio listaPatioPorId(@PathVariable(value = "id") long id) {
    return patioRepository.findPatioById(id);
  }

  @PostMapping("/empresa/{empresaId}/patio")
  public Patio salvaPatio(@PathVariable(value = "empresaId") long empresaId, @RequestBody Patio patio) {
    Empresa empresa = empresaRepository.findEmpresaById(empresaId);
    patio.setEmpresa(empresa);
    return patioRepository.save(patio);
  }

  @DeleteMapping("/patio")
  public void deletaPatio(@RequestBody Patio patio) {
    patioRepository.delete(patio);
  }

  @PutMapping("/patio")
  public Patio atualizaPatio(@RequestBody Patio patio) {
    return patioRepository.save(patio);
  }

}