package com.markti.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.markti.erp.model.Medico;
import com.markti.erp.repository.Medicos;
import com.markti.erp.util.Transacional;

public class CadastroMedicoService implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Inject
	private Medicos medicos;
	
	@Transacional
	public void salvar(Medico medico) {
		medicos.guardar(medico);
	}
	
	@Transacional
	public void excluir(Medico medico) {
		medicos.remover(medico);
	}

}