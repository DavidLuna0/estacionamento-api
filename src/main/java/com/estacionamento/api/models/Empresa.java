package com.estacionamento.api.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "TB_EMPRESA")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String razaoSocial;

	@Column(nullable = false)
	private String nomeFantasia;

	@Column(nullable = false)
	private String cnpj;

	@Column(nullable = false)
	private String inscricao;

	@Column(nullable = false)
	private String endRua;

	@Column(nullable = false)
	private String endNum;

	private String endComp;

	@Column(nullable = false)
	private String endBairro;

	@Column(nullable = false)
	private String endCidade;

	@Column(nullable = false)
	private String endEstado;

	@Column(nullable = false)
	private String contatoEmpresa;

	@Column(nullable = false)
	private String emailEmpresa;

	@Column(nullable = false)
	private String responsavel;

	@Column(nullable = false)
	private String contatoResp;

	@Column(nullable = false)
	private String emailResp;

	@OneToMany(mappedBy = "empresa", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List<Patio> patios = new ArrayList<Patio>();

	@OneToMany(mappedBy = "empresa", orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	@JsonManagedReference
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRazaoSocial() {
		return this.razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return this.nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricao() {
		return this.inscricao;
	}

	public void setInscricao(String inscricao) {
		this.inscricao = inscricao;
	}

	public String getEndRua() {
		return this.endRua;
	}

	public void setEndRua(String endRua) {
		this.endRua = endRua;
	}

	public String getEndNum() {
		return this.endNum;
	}

	public void setEndNum(String endNum) {
		this.endNum = endNum;
	}

	public String getEndComp() {
		return this.endComp;
	}

	public void setEndComp(String endComp) {
		this.endComp = endComp;
	}

	public String getEndBairro() {
		return this.endBairro;
	}

	public void setEndBairro(String endBairro) {
		this.endBairro = endBairro;
	}

	public String getEndCidade() {
		return this.endCidade;
	}

	public void setEndCidade(String endCidade) {
		this.endCidade = endCidade;
	}

	public String getEndEstado() {
		return this.endEstado;
	}

	public void setEndEstado(String endEstado) {
		this.endEstado = endEstado;
	}

	public String getContatoEmpresa() {
		return this.contatoEmpresa;
	}

	public void setContatoEmpresa(String contatoEmpresa) {
		this.contatoEmpresa = contatoEmpresa;
	}

	public String getEmailEmpresa() {
		return this.emailEmpresa;
	}

	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getContatoresp() {
		return this.contatoResp;
	}

	public void setContatoResp(String contatoResp) {
		this.contatoResp = contatoResp;
	}

	public String getEmailResp() {
		return this.emailResp;
	}

	public void setEmailResp(String emailResp) {
		this.emailResp = emailResp;
	}

	public List<Patio> getPatios() {
		return this.patios;
	}

	public void setPatios(List<Patio> patios) {
		this.patios = patios;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}