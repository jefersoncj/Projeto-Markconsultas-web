package com.markti.erp.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
public class Especialidade implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty
	@Size(max = 150)
	@Column(name = "desc_especialidade", nullable = false, length = 150)
    private String dsEspecialidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsEspecialidade() {
		return dsEspecialidade;
	}

	public void setDsEspecialidade(String dsEspecialidade) {
		this.dsEspecialidade = dsEspecialidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dsEspecialidade == null) ? 0 : dsEspecialidade.hashCode());
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
		Especialidade other = (Especialidade) obj;
		if (dsEspecialidade == null) {
			if (other.dsEspecialidade != null)
				return false;
		} else if (!dsEspecialidade.equals(other.dsEspecialidade))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
