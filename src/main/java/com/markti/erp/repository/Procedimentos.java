package com.markti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.markti.erp.model.Procedimento;

public class Procedimentos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Procedimento porId(Long id) {
		return manager.find(Procedimento.class, id);
	}
	
	public List<Procedimento> todos() {
		return manager.createQuery("from Procedimento", Procedimento.class).getResultList();
	}
	
	
	
	public Procedimento guardar(Procedimento procedimento) {
		return manager.merge(procedimento);
	}
	
	public void remover(Procedimento procedimento) {
		procedimento = porId(procedimento.getId());
		manager.remove(procedimento);
	}

}