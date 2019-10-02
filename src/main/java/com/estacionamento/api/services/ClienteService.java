package com.estacionamento.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamento.api.models.Cliente;
import com.estacionamento.api.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository cr;
	
	public Cliente update(Cliente cliente, Cliente novoCliente) {
		cliente.setNome(novoCliente.getNome());
		cliente.setCpf(novoCliente.getCpf());
		cliente.setDataDeNascimento(novoCliente.getDataDeNascimento());
		cliente.setRua(novoCliente.getRua());
		cliente.setNumero(novoCliente.getNumero());
		cliente.setComplemento(novoCliente.getComplemento());
		cliente.setCidade(novoCliente.getCidade());
		cliente.setUF(novoCliente.getUF());
		cliente.setPlaca(novoCliente.getPlaca());
		cliente.setCorDoCarro(novoCliente.getCorDoCarro());
		cliente.setModeloDoCarro(novoCliente.getModeloDoCarro());
		cliente.setAnoDoCarro(novoCliente.getAnoDoCarro());
		cliente.setObservacao(novoCliente.getObservacao());
		return cr.save(cliente);
	}
}
