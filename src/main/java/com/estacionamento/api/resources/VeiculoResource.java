package com.estacionamento.api.resources;

import java.util.Calendar;
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

import com.estacionamento.api.models.Patio;
import com.estacionamento.api.models.Veiculo;
import com.estacionamento.api.repository.PatioRepository;
import com.estacionamento.api.repository.VeiculoRepository;

@RestController
@RequestMapping(value = "/api")
public class VeiculoResource {

  @Autowired
  VeiculoRepository veiculoRepository;

  @Autowired
  PatioRepository patioRepository;

  @GetMapping("/veiculos")
  public List<Veiculo> listaVeiculos() {
    return veiculoRepository.findAll();
  }

  @GetMapping("/veiculo/{id}")
  public Veiculo listaVeiculoPorId(@PathVariable(value = "id") long id) {
    return veiculoRepository.findById(id);
  }

  @PostMapping("patio/{patioId}/veiculo")
  public Veiculo salvaVeiculo(@PathVariable(value = "patioId") long patioId, @RequestBody Veiculo veiculo) {
    Patio patio = patioRepository.findPatioById(patioId);
    veiculo.setPatio(patio);
    veiculo.setHrentrada(Calendar.getInstance());
    return veiculoRepository.save(veiculo);
  }

  @DeleteMapping("/veiculo")
  public void deletaVeiculo(@RequestBody Veiculo veiculo) {
    veiculoRepository.delete(veiculo);
  }

  @PutMapping("/veiculo")
  public Veiculo atualizaVeiculo(@RequestBody Veiculo veiculo) {
    return veiculoRepository.save(veiculo);
  }

}