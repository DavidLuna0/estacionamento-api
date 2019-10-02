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

import com.estacionamento.api.models.Cliente;
import com.estacionamento.api.models.Empresa;
import com.estacionamento.api.repository.ClienteRepository;
import com.estacionamento.api.repository.EmpresaRepository;
import com.estacionamento.api.services.ClienteService;

@RestController
@RequestMapping(value="/api")
public class ClienteResource {

	@Autowired
	ClienteRepository cr;
	
	@Autowired
	EmpresaRepository er;
	
	@Autowired
	ClienteService cs;
	
	@GetMapping("/empresa/{id}/clientes")
	public List<Cliente> listaClientes(@PathVariable(value = "id") long id) {
		Empresa empresa = er.findEmpresaById(id);
		return empresa.getClientes();
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente listaClientePorId(@PathVariable(value = "id") long id) {
		return cr.findClienteById(id);
	}
	
	@PostMapping("/empresa/{id}/cliente") // empresa ID
	public Cliente salvaCliente(@PathVariable(value = "id") long id, @RequestBody Cliente cliente) {
		Empresa empresa = er.findEmpresaById(id);
		cliente.setEmpresa(empresa);
		return cr.save(cliente);
	}
	
	@DeleteMapping("/remover/cliente/{id}")
	public void deletaCliente(@PathVariable(value = "id") long id) {
		Cliente cliente = cr.findClienteById(id);
		cr.delete(cliente);
	}
	
	@PutMapping("/atualizar/cliente/{id}")
	public Cliente atualizaCliente(@PathVariable(value = "id") long id, @RequestBody Cliente dados) {
		Cliente cliente = cr.findClienteById(id);
		return cs.update(cliente, dados);
	}
}
