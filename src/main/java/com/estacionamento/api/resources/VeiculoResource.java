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
  VeiculoRepository vr;

  @Autowired
  PatioRepository pr;

  @GetMapping("/veiculos")
  public List<Veiculo> listaVeiculos() {
    return vr.findAll();
  }

  @GetMapping("/veiculo/{id}") // veiculo ID
  public Veiculo listaVeiculoPorId(@PathVariable(value = "id") long id) {
    return vr.findVeiculoById(id);
  }

  @PostMapping("patio/{id}/veiculo") // patio ID
  public Veiculo salvaVeiculo(@PathVariable(value = "id") long id, @RequestBody Veiculo veiculo) {
    Patio patio = pr.findPatioById(id);
    veiculo.setPatio(patio);
    veiculo.setHrentrada(Calendar.getInstance());
    return vr.save(veiculo);
  }

  @DeleteMapping("/remover/veiculo/{id}") // veiculo ID
  public void deletaVeiculo(@PathVariable(value = "id") long id) {
    Veiculo veiculo = vr.findVeiculoById(id);
    vr.delete(veiculo);
  }

  @PutMapping("/veiculo")
  public Veiculo atualizaVeiculo(@RequestBody Veiculo veiculo) {
    return vr.save(veiculo);
  }

}