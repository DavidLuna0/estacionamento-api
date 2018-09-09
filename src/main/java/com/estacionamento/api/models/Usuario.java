package com.estacionamento.api.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.ForeignKey;

@Entity
@Table(name="TB_USUARIO")
public class Usuario implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
  
  @Column(nullable = false)
  private String nome;
  
  @Column(nullable = false, unique = true)
  private String usuario;
  
  @Column(nullable = false)
  private String senha;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "empresa_usuario_fk"), nullable = false)
	@JsonBackReference
  private Empresa empresa = new Empresa();

	public long getId()
	{
		return this.id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return this.nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getUsuario()
	{
		return this.usuario;
	}

	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	public String getSenha()
	{
		return this.senha;
	}

	public void setSenha(String senha)
  {
    this.senha = senha;
  }

  public Empresa getEmpresa() {
    return this.empresa;
  }

  public void setEmpresa(Empresa empresa) {
    this.empresa = empresa;
  }

}