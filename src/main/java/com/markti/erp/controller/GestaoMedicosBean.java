package com.markti.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;


import com.markti.erp.model.Especialidade;
import com.markti.erp.model.Medico;
import com.markti.erp.repository.Medicos;
import com.markti.erp.service.CadastroMedicoService;
import com.markti.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoMedicosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Medicos medicos;
	
	@Inject
	private CadastroMedicoService cadastroMedico;
	
	@Inject
	private FacesMessages messages;
	
	private List<Medico> todosMedicos;
	private Medico medicoEdicao = new Medico();
	private Medico medicoSelecionado;
	private List<Especialidade> todasEspecialidades;
	
	public void prepararNovoCadastro() {
		medicoEdicao = new Medico();
	}
	
	public void salvar() {
		cadastroMedico.salvar(medicoEdicao);
		consultar();
		
		messages.info("Medico salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:medicos-table"));
	}
	
	public void excluir() {
		cadastroMedico.excluir(medicoSelecionado);
		medicoSelecionado = null;
		
		consultar();
		
		messages.info("Medico excluído com sucesso!");
	}
	
	public void consultar() {
		todosMedicos = medicos.todos();
	}

	public List<Medico> getTodosMedicos() {
		return todosMedicos;
	}
	
	public List<Especialidade> getTodasEspecialidades() {
		todasEspecialidades = medicos.todasEspecialidades();
		return todasEspecialidades;
	}
	

	public Medico getMedicoEdicao() {
		return medicoEdicao;
	}

	public void setMedicoEdicao(Medico medicoEdicao) {
		this.medicoEdicao = medicoEdicao;
	}

	public Medico getMedicoSelecionado() {
		return medicoSelecionado;
	}

	public void setMedicoSelecionado(Medico medicoSelecionado) {
		this.medicoSelecionado = medicoSelecionado;
	}
	
}