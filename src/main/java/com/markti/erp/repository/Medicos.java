package com.markti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.markti.erp.model.Especialidade;
import com.markti.erp.model.Medico;

public class Medicos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Medico porId(Long id) {
		return manager.find(Medico.class, id);
	}
	
	public List<Medico> todos() {
		return manager.createQuery("from Medico", Medico.class).getResultList();
	}
	
	
	
	public Medico guardar(Medico medico) {
		return manager.merge(medico);
	}
	public List<Especialidade> todasEspecialidades() {
		return manager.createQuery("from Especialidade", Especialidade.class).getResultList();
	}
	public void remover(Medico medico) {
		medico = porId(medico.getId());
		manager.remove(medico);
	}

}