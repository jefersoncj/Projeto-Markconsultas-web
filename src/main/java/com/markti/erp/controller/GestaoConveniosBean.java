package com.markti.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.markti.erp.model.Convenio;
import com.markti.erp.repository.Convenios;
import com.markti.erp.service.CadastroConvenioService;
import com.markti.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoConveniosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Convenios convenios;
	
	@Inject
	private CadastroConvenioService cadastroConvenio;
	
	@Inject
	private FacesMessages messages;
	
	private List<Convenio> todosConvenios;
	private Convenio convenioEdicao = new Convenio();
	private Convenio convenioSelecionado;
	
	public void prepararNovoCadastro() {
		convenioEdicao = new Convenio();
	}
	
	public void salvar() {
		cadastroConvenio.salvar(convenioEdicao);
		consultar();
		
		messages.info("Convenio salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:convenios-table"));
	}
	
	public void excluir() {
		cadastroConvenio.excluir(convenioSelecionado);
		convenioSelecionado = null;
		
		consultar();
		
		messages.info("Convenio excluída com sucesso!");
	}
	
	public void consultar() {
		todosConvenios = convenios.todos();
	}

	public List<Convenio> getTodosConvenios() {
		return todosConvenios;
	}
	
	

	public Convenio getConvenioEdicao() {
		return convenioEdicao;
	}

	public void setConvenioEdicao(Convenio convenioEdicao) {
		this.convenioEdicao = convenioEdicao;
	}

	public Convenio getConvenioSelecionado() {
		return convenioSelecionado;
	}

	public void setConvenioSelecionado(Convenio convenioSelecionado) {
		this.convenioSelecionado = convenioSelecionado;
	}
	
}