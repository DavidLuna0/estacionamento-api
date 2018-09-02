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
	private long cnpj;

	@Column(nullable = false)
	private long inscricao;

	@Column(nullable = false)
	private String endRua;

	@Column(nullable = false)
	private int endNum;

	private String endComp;

	@Column(nullable = false)
	private String endBairro;

	@Column(nullable = false)
	private String endCidade;

	@Column(nullable = false)
	private String endEstado;

	@Column(nullable = false)
	private long contatoEmpresa;

	@Column(nullable = false)
	private String emailEmpresa;

	@Column(nullable = false)
	private String responsavel;

	@Column(nullable = false)
	private long contatoResp;

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

	public String getRazaosocial() {
		return this.razaoSocial;
	}

	public void setRazaosocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomefantasia() {
		return this.nomeFantasia;
	}

	public void setNomefantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public long getCnpj() {
		return this.cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public long getInscricao() {
		return this.inscricao;
	}

	public void setInscricao(long inscricao) {
		this.inscricao = inscricao;
	}

	public String getEndrua() {
		return this.endRua;
	}

	public void setEndrua(String endRua) {
		this.endRua = endRua;
	}

	public int getEndnum() {
		return this.endNum;
	}

	public void setEndnum(int endNum) {
		this.endNum = endNum;
	}

	public String getEndcomp() {
		return this.endComp;
	}

	public void setEndcomp(String endComp) {
		this.endComp = endComp;
	}

	public String getEndbairro() {
		return this.endBairro;
	}

	public void setEndbairro(String endBairro) {
		this.endBairro = endBairro;
	}

	public String getEndcidade() {
		return this.endCidade;
	}

	public void setEndcidade(String endCidade) {
		this.endCidade = endCidade;
	}

	public String getEndestado() {
		return this.endEstado;
	}

	public void setEndestado(String endEstado) {
		this.endEstado = endEstado;
	}

	public long getContatoempresa() {
		return this.contatoEmpresa;
	}

	public void setContatoempresa(long contatoEmpresa) {
		this.contatoEmpresa = contatoEmpresa;
	}

	public String getEmailempresa() {
		return this.emailEmpresa;
	}

	public void setEmailempresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}

	public String getResponsavel() {
		return this.responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public long getContatoresp() {
		return this.contatoResp;
	}

	public void setContatoresp(long contatoResp) {
		this.contatoResp = contatoResp;
	}

	public String getEmailresp() {
		return this.emailResp;
	}

	public void setEmailresp(String emailResp) {
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