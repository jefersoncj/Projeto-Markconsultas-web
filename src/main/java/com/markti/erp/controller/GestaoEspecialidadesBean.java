package com.markti.erp.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import com.markti.erp.model.Especialidade;
import com.markti.erp.repository.Especialidades;
import com.markti.erp.service.CadastroEspecialidadeService;
import com.markti.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoEspecialidadesBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Especialidades especialidades;
	
	@Inject
	private CadastroEspecialidadeService cadastroEspecialidade;
	
	@Inject
	private FacesMessages messages;
	
	private List<Especialidade> todasEspecialidades;
	private Especialidade especialidadeEdicao = new Especialidade();
	private Especialidade especialidadeSelecionado;
	
	public void prepararNovoCadastro() {
		especialidadeEdicao = new Especialidade();
	}
	
	public void salvar() {
		cadastroEspecialidade.salvar(especialidadeEdicao);
		consultar();
		
		messages.info("Especialidade salva com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:especialidades-table"));
	}
	
	public void excluir() {
		cadastroEspecialidade.excluir(especialidadeSelecionado);
		especialidadeSelecionado = null;
		
		consultar();
		
		messages.info("Especialidade excluída com sucesso!");
	}
	
	public void consultar() {
		todasEspecialidades = especialidades.todas();
	}

	public List<Especialidade> getTodasEspecialidades() {
		return todasEspecialidades;
	}
	
	

	public Especialidade getEspecialidadeEdicao() {
		return especialidadeEdicao;
	}

	public void setEspecialidadeEdicao(Especialidade especialidadeEdicao) {
		this.especialidadeEdicao = especialidadeEdicao;
	}

	public Especialidade getEspecialidadeSelecionado() {
		return especialidadeSelecionado;
	}

	public void setEspecialidadeSelecionado(Especialidade especialidadeSelecionado) {
		this.especialidadeSelecionado = especialidadeSelecionado;
	}
	
}