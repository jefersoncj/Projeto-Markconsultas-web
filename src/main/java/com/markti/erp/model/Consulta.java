package com.markti.erp.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;



/**
 *
 * @author jeferson
 */
@Entity
public class Consulta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@ManyToOne
	private Medico medico;
	
	@NotNull
	@ManyToOne
	private Paciente paciente;
	

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_consulta")
	private Date dataConsulta;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", length = 20)
	private TipoConsulta tipo;
	
	@Column(name = "cod_autorizacao", length = 20)
	private Long codAutorizacao;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "status", length = 20)
	private StatusConsulta status;

	@NotNull
	@ManyToOne
	private CondPagto condPagto;
	
	
	private BigDecimal valor;

	
	@ManyToOne
	private Procedimento procedimento;
	
	@Column(name = "obs", length = 150)
	private String obs;

	@Transient
    private String dateFilter;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public TipoConsulta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConsulta tipo) {
		this.tipo = tipo;
	}

	public Long getCodAutorizacao() {
		return codAutorizacao;
	}

	public void setCodAutorizacao(Long codAutorizacao) {
		this.codAutorizacao = codAutorizacao;
	}

	public StatusConsulta getStatus() {
		return status;
	}

	public void setStatus(StatusConsulta status) {
		this.status = status;
	}

	public CondPagto getCondPagto() {
		return condPagto;
	}

	public void setCondPagto(CondPagto condPagto) {
		this.condPagto = condPagto;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Procedimento getProcedimento() {
		return procedimento;
	}

	public void setProcedimento(Procedimento procedimento) {
		this.procedimento = procedimento;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}
	
	public String getDateFilter() {
        return new SimpleDateFormat("dd/MM/yyyy").format(dataConsulta);
    }

    public void setDateFilter(String dateFilter) {
        this.dateFilter = dateFilter;
    }
    	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
