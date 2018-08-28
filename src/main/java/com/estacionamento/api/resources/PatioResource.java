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
  PatioRepository pr;

  @Autowired
  EmpresaRepository er;

  @GetMapping("/patios")
  public List<Patio> listaPatios() {
    return pr.findAll();
  }

  @GetMapping("/patio/{id}") // patio ID
  public Patio listaPatioPorId(@PathVariable(value = "id") long id) {
    return pr.findPatioById(id);
  }

  @PostMapping("/empresa/{id}/patio") // empresa ID
  public Patio salvaPatio(@PathVariable(value = "id") long id, @RequestBody Patio patio) {
    Empresa empresa = er.findEmpresaById(id);
    patio.setEmpresa(empresa);
    return pr.save(patio);
  }

  @DeleteMapping("/remover/patio/{id}") // patio ID
  public void deletaPatio(@PathVariable(value = "id") long id) {
    Patio patio = pr.findPatioById(id);
    pr.delete(patio);
  }

  @PutMapping("/patio")
  public Patio atualizaPatio(@RequestBody Patio patio) {
    return pr.save(patio);
  }

}