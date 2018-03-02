package com.markti.erp.model;

public enum TipoConsulta {

	CONSULTA("Consulta"), 
	PROCEDIMENTO("Procedimento"),
	RETORNO("Retorno");
	
	
	private String descricao;

	TipoConsulta(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}