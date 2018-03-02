package com.markti.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.markti.erp.model.Consulta;
import com.markti.erp.repository.Consultas;
import com.markti.erp.util.Transacional;

public class CadastroConsultaService implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Inject
	private Consultas consultas;
	
	@Transacional
	public void salvar(Consulta consulta) {
		consultas.guardar(consulta);
	}
	
	@Transacional
	public void excluir(Consulta consulta) {
		consultas.remover(consulta);
	}

}