package com.markti.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.markti.erp.model.Convenio;
import com.markti.erp.model.Paciente;
import com.markti.erp.model.UfSiglas;
import com.markti.erp.repository.Pacientes;
import com.markti.erp.service.CadastroPacienteService;
import com.markti.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoPacientesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pacientes pacientes;
	
	@Inject
	private CadastroPacienteService cadastroPacientes;
	
	@Inject
	private FacesMessages messages;
	
	private List<Paciente> todosPacientes;
	private List<Convenio> todosConvenios;
	private Paciente pacienteEdicao = new Paciente();
	private Paciente pacienteSelecionado;
	
	public void prepararNovoCadastro() {
		pacienteEdicao = new Paciente();
	}
	
	public void salvar() {
		cadastroPacientes.salvar(pacienteEdicao);
		consultar();
		
		messages.info("Paciente salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:pacientes-table"));
	}
	
	public void excluir() {
		cadastroPacientes.excluir(pacienteSelecionado);
		pacienteSelecionado = null;
		
		consultar();
		
		messages.info("Paciente excluído com sucesso!");
	}
	
	public void consultar() {
		todosPacientes = pacientes.todas();
	}

	public List<Paciente> getTodosPacientes() {
		return todosPacientes;
	}
	
	public List<Convenio> getTodosConvenios() {
		todosConvenios = pacientes.todasConvenios();
		return todosConvenios;
	}
	
	public UfSiglas[] getUfSiglas() {
		return UfSiglas.values();
	}

	public Paciente getPacienteEdicao() {
		return pacienteEdicao;
	}
	

	public void setPacienteEdicao(Paciente pacienteEdicao) {
		this.pacienteEdicao = pacienteEdicao;
	}

	public Paciente getPacienteSelecionado() {
		return pacienteSelecionado;
	}

	public void setPacienteSelecionado(Paciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}
	
}