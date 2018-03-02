package com.markti.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.markti.erp.model.Procedimento;
import com.markti.erp.repository.Procedimentos;
import com.markti.erp.service.CadastroProcedimentoService;
import com.markti.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoProcedimentosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Procedimentos procedimentos;
	
	@Inject
	private CadastroProcedimentoService cadastroProcedimento;
	
	@Inject
	private FacesMessages messages;
	
	private List<Procedimento> todosProcedimentos;
	private Procedimento procedimentoEdicao = new Procedimento();
	private Procedimento procedimentoSelecionado;
	
	public void prepararNovoCadastro() {
		procedimentoEdicao = new Procedimento();
	}
	
	public void salvar() {
		cadastroProcedimento.salvar(procedimentoEdicao);
		consultar();
		
		messages.info("Procedimento salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:procedimentos-table"));
	}
	
	public void excluir() {
		cadastroProcedimento.excluir(procedimentoSelecionado);
		procedimentoSelecionado = null;
		
		consultar();
		
		messages.info("Procedimento excluído com sucesso!");
	}
	
	public void consultar() {
		todosProcedimentos = procedimentos.todos();
	}

	public List<Procedimento> getTodosProcedimentos() {
		return todosProcedimentos;
	}
	
	

	public Procedimento getProcedimentoEdicao() {
		return procedimentoEdicao;
	}

	public void setProcedimentoEdicao(Procedimento procedimentoEdicao) {
		this.procedimentoEdicao = procedimentoEdicao;
	}

	public Procedimento getProcedimentoSelecionado() {
		return procedimentoSelecionado;
	}

	public void setProcedimentoSelecionado(Procedimento procedimentoSelecionado) {
		this.procedimentoSelecionado = procedimentoSelecionado;
	}
	
}