package com.markti.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.markti.erp.model.Procedimento;
import com.markti.erp.repository.Procedimentos;
import com.markti.erp.util.Transacional;

public class CadastroProcedimentoService implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Inject
	private Procedimentos procedimentos;
	
	@Transacional
	public void salvar(Procedimento procedimento) {
		procedimentos.guardar(procedimento);
	}
	
	@Transacional
	public void excluir(Procedimento procedimento) {
		procedimentos.remover(procedimento);
	}

}