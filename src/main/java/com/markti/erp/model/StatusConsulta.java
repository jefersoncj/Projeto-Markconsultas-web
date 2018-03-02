package com.markti.erp.model;

public enum StatusConsulta {

	ABERTA("Aberta"), 
	ENCERRADA("Encerrada"),
	CANCELADA("Cancelada");
	
	private String descricao;

	StatusConsulta(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}