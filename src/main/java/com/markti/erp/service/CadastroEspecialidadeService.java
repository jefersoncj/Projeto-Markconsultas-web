package com.markti.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.markti.erp.model.Especialidade;
import com.markti.erp.repository.Especialidades;
import com.markti.erp.util.Transacional;

public class CadastroEspecialidadeService implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Inject
	private Especialidades especialidades;
	
	@Transacional
	public void salvar(Especialidade especialidade) {
		especialidades.guardar(especialidade);
	}
	
	@Transacional
	public void excluir(Especialidade especialidade) {
		especialidades.remover(especialidade);
	}

}