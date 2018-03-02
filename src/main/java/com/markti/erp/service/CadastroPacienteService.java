package com.markti.erp.service;

import java.io.Serializable;

import javax.inject.Inject;


import com.markti.erp.model.Paciente;
import com.markti.erp.repository.Pacientes;
import com.markti.erp.util.Transacional;

public class CadastroPacienteService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Pacientes pacientes;
	
	@Transacional
	public void salvar(Paciente paciente) {
		pacientes.guardar(paciente);
	}
	
	@Transacional
	public void excluir(Paciente paciente) {
		pacientes.remover(paciente);
	}

}