package com.markti.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.markti.erp.model.Convenio;
import com.markti.erp.repository.Convenios;
import com.markti.erp.util.Transacional;

public class CadastroConvenioService implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Inject
	private Convenios convenios;
	
	@Transacional
	public void salvar(Convenio convenio) {
		convenios.guardar(convenio);
	}
	
	@Transacional
	public void excluir(Convenio convenio) {
		convenios.remover(convenio);
	}

}