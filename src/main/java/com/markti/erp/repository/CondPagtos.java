package com.markti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.markti.erp.model.CondPagto;

public class CondPagtos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public CondPagto porId(Long id) {
		return manager.find(CondPagto.class, id);
	}
	
	public List<CondPagto> todos() {
		return manager.createQuery("from CondPagto", CondPagto.class).getResultList();
	}
	
	
	
	public CondPagto guardar(CondPagto condPagto) {
		return manager.merge(condPagto);
	}
	
	public void remover(CondPagto condPagto) {
		condPagto = porId(condPagto.getId());
		manager.remove(condPagto);
	}

}