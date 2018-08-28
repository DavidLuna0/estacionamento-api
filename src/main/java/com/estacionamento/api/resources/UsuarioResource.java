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
  UsuarioRepository ur;

  @Autowired
  EmpresaRepository er;

  @GetMapping("/usuarios")
  public List<Usuario> listaUsuarios() {
    return ur.findAll();
  }

  @GetMapping("/usuario/{id}") // usuario ID
  public Usuario listaUsuarioPorId(@PathVariable(value = "id") long id) {
    return ur.findUsuarioById(id);
  }

  @PostMapping("/empresa/{id}/usuario") // empresa ID
  public Usuario salvaUsuario(@PathVariable(value = "id") long id, @RequestBody Usuario usuario) {
    Empresa empresa = er.findEmpresaById(id);
    usuario.setEmpresa(empresa);
    return ur.save(usuario);
  }

  @DeleteMapping("/remover/usuario/{id}") // usuario ID
  public void deletaUsuario(@PathVariable(value = "id") long id) {
    Usuario usuario = ur.findUsuarioById(id);
    ur.delete(usuario);
  }

  @PutMapping("/usuario")
  public Usuario atualizaUsuario(@RequestBody Usuario usuario) {
    return ur.save(usuario);
  }

}