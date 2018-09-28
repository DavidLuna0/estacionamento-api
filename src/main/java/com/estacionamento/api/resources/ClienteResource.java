package com.estacionamento.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estacionamento.api.models.Cliente;
import com.estacionamento.api.repository.ClienteRepository;

@RestController
@RequestMapping(value="/api")
public class ClienteResource {

	@Autowired
	ClienteRepository cr;
	
	@GetMapping("/clientes")
	public List<Cliente> listaClientes() {
		return cr.findAll();
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente listaClientePorId(@PathVariable(value = "id")long id) {
		return cr.findClienteById(id);
	}
	
	@DeleteMapping
	public void deletaCliente(@PathVariable(value = "id")long id) {
		Cliente cliente = cr.findClienteById(id);
		cr.delete(cliente);
	}
	
	@PutMapping
	public Cliente atualizaCliente(@RequestBody Cliente cliente ) {
		return cr.save(cliente);
	}
}
