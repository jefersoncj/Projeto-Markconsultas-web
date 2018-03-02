package com.markti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.markti.erp.model.Especialidade;

public class Especialidades implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Especialidade porId(Long id) {
		return manager.find(Especialidade.class, id);
	}
	
	public List<Especialidade> todas() {
		return manager.createQuery("from Especialidade", Especialidade.class).getResultList();
	}
	
	
	
	public Especialidade guardar(Especialidade especialidade) {
		return manager.merge(especialidade);
	}
	
	public void remover(Especialidade especialidade) {
		especialidade = porId(especialidade.getId());
		manager.remove(especialidade);
	}

}