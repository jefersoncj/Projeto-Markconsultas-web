package com.markti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.markti.erp.model.Convenio;
import com.markti.erp.model.Paciente;

public class Pacientes implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Paciente porId(Long id) {
		return manager.find(Paciente.class, id);
	}
	
	public List<Paciente> todas() {
		return manager.createQuery("from Paciente", Paciente.class).getResultList();
	}
	
	public List<Convenio> todasConvenios() {
		return manager.createQuery("from Convenio", Convenio.class).getResultList();
	}
	
	public Paciente guardar(Paciente paciente) {
		return manager.merge(paciente);
	}
	
	public void remover(Paciente paciente) {
		paciente = porId(paciente.getId());
		manager.remove(paciente);
	}

}