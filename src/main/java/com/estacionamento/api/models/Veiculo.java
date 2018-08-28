package com.estacionamento.api.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.ForeignKey;;

@Entity
@Table(name="TB_VEICULO")
public class Veiculo implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private long id;
	private String placa;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar hrEntrada;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar hrSaida;

  private Integer status;
	private BigDecimal valor;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "patio_fk"), nullable = false)
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

	public Calendar getHrentrada()
	{
		return this.hrEntrada;
	}

	public void setHrentrada(Calendar hrEntrada)
	{
		this.hrEntrada = hrEntrada;
	}

	public Calendar getHrsaida()
	{
		return this.hrSaida;
	}

	public void setHrsaida(Calendar hrSaida)
	{
		this.hrSaida = hrSaida;
	}

	public Integer getStatus()
	{
		return this.status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public BigDecimal getValor()
	{
		return this.valor;
	}

	public void setValor(BigDecimal valor)
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