package com.markti.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.markti.erp.model.CondPagto;
import com.markti.erp.repository.CondPagtos;
import com.markti.erp.util.Transacional;

public class CadastroCondPagtoService implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Inject
	private CondPagtos condPagtos;
	
	@Transacional
	public void salvar(CondPagto condPagto) {
		condPagtos.guardar(condPagto);
	}
	
	@Transacional
	public void excluir(CondPagto condPagto) {
		condPagtos.remover(condPagto);
	}

}