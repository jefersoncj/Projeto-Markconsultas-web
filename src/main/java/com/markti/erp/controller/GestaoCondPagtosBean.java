package com.markti.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.markti.erp.model.CondPagto;
import com.markti.erp.repository.CondPagtos;
import com.markti.erp.service.CadastroCondPagtoService;
import com.markti.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoCondPagtosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private CondPagtos condPagtos;
	
	@Inject
	private CadastroCondPagtoService cadastroCondPagto;
	
	@Inject
	private FacesMessages messages;
	
	private List<CondPagto> todosCondPagtos;
	private CondPagto condPagtoEdicao = new CondPagto();
	private CondPagto condPagtoSelecionado;
	
	public void prepararNovoCadastro() {
		condPagtoEdicao = new CondPagto();
	}
	
	public void salvar() {
		cadastroCondPagto.salvar(condPagtoEdicao);
		consultar();
		
		messages.info("Condição de pagamento salvo com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:condPagtos-table"));
	}
	
	public void excluir() {
		cadastroCondPagto.excluir(condPagtoSelecionado);
		condPagtoSelecionado = null;
		
		consultar();
		
		messages.info("CondPagto excluída com sucesso!");
	}
	
	public void consultar() {
		todosCondPagtos = condPagtos.todos();
	}

	public List<CondPagto> getTodosCondPagtos() {
		return todosCondPagtos;
	}
	
	

	public CondPagto getCondPagtoEdicao() {
		return condPagtoEdicao;
	}

	public void setCondPagtoEdicao(CondPagto condPagtoEdicao) {
		this.condPagtoEdicao = condPagtoEdicao;
	}

	public CondPagto getCondPagtoSelecionado() {
		return condPagtoSelecionado;
	}

	public void setCondPagtoSelecionado(CondPagto condPagtoSelecionado) {
		this.condPagtoSelecionado = condPagtoSelecionado;
	}
	
}