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

import javax.persistence.ForeignKey;;

@Entity
@Table(name="TB_VEICULO")
public class Veiculo implements Serializable {

  private static final long serialVersionUID = 1L;

  	@Id
  	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String placa;

	@Column(nullable = false)
	private String hrEntrada;

	@Column(nullable = true)
	private String hrSaida;

	@Column(nullable = false)
	private int status;

	@Column(nullable = false)
	private double valor;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "patio_veiculo_fk"), nullable = false)
	@JsonBackReference
	private Patio patio = new Patio();

	public long getId()
	{
		return this.id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public String getPlaca()
	{
		return this.placa;
	}

	public void setPlaca(String placa)
	{
		this.placa = placa;
	}

	public String getHrEntrada()
	{
		return this.hrEntrada;
	}

	public void setHrEntrada(String hrEntrada)
	{
		this.hrEntrada = hrEntrada;
	}

	public String getHrSaida()
	{
		return this.hrSaida;
	}

	public void setHrSaida(String hrSaida)
	{
		this.hrSaida = hrSaida;
	}

	public int getStatus()
	{
		return this.status;
	}

	public void setStatus(int status)
	{
		this.status = status;
	}

	public double getValor()
	{
		return this.valor;
	}

	public void setValor(double valor)
	{
		this.valor = valor;
	}

	public Patio getPatio() {
		return this.patio;
	}

	public void setPatio(Patio patio) {
		this.patio = patio;
	}

}