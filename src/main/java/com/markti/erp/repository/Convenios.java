package com.markti.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.markti.erp.model.Convenio;

public class Convenios implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Convenio porId(Long id) {
		return manager.find(Convenio.class, id);
	}
	
	public List<Convenio> todos() {
		return manager.createQuery("from Convenio", Convenio.class).getResultList();
	}
	
	
	
	public Convenio guardar(Convenio convenio) {
		return manager.merge(convenio);
	}
	
	public void remover(Convenio convenio) {
		convenio = porId(convenio.getId());
		manager.remove(convenio);
	}

}