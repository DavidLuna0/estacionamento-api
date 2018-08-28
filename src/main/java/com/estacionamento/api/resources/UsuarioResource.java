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
import com.estacionamento.api.models.Usuario;
import com.estacionamento.api.repository.EmpresaRepository;
import com.estacionamento.api.repository.UsuarioRepository;

@RestController
@RequestMapping(value = "/api")
public class UsuarioResource {

  @Autowired
  UsuarioRepository usuarioRepository;

  @Autowired
  EmpresaRepository empresaRepository;

  @GetMapping("/usuarios")
  public List<Usuario> listaUsuarios() {
    return usuarioRepository.findAll();
  }

  @GetMapping("/usuario/{id}")
  public Usuario listaUsuarioPorId(@PathVariable(value = "id") long id) {
    return usuarioRepository.findUsuarioById(id);
  }

  @PostMapping("/empresa/{empresaId}/usuario")
  public Usuario salvaUsuario(@PathVariable(value = "empresaId") long empresaId, @RequestBody Usuario usuario) {
    Empresa empresa = empresaRepository.findEmpresaById(empresaId);
    usuario.setEmpresa(empresa);
    return usuarioRepository.save(usuario);
  }

  @DeleteMapping("/usuario")
  public void deletaUsuario(@RequestBody Usuario usuario) {
    usuarioRepository.delete(usuario);
  }

  @PutMapping("/usuario")
  public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
    return usuarioRepository.save(usuario);
  }

}