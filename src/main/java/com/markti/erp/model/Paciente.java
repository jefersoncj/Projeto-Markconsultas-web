package com.markti.erp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;


import org.hibernate.validator.constraints.br.CPF;


@Entity
public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "numero_convenio", length = 14)
    private String numConvenio;
    
	@NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "convenio_id")
    private Convenio convenio;
    
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;
    
    @Column(name = "email", length = 100)
    private String email;
    
    
    @CPF
    @Column(name = "cpf", length = 14)
    private String cpf;
    
    @Column(name = "rg", length = 20)
    private String rg;
    
    @NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
    private Date dataNasc;
  
    @Column(name = "fone_fixo", length = 15)
    private String foneFixo;
    
    @Column(name = "celular1", length = 16)
    private String celular1;
    
    @Column(name = "celular2", length = 16)
    private String celular2;
    
    @Column(name = "celular3", length = 16)
    private String celular3;   
  
   
    @Column(name = "nome_mae", length = 100)
    private String nomeMae;
    
    @Column(name = "nome_pai", length = 100)
    private String nomePai;
    
    
    @Column(name = "cod_cep", length = 10)
    private String codCep;
    
    @Column(name = "logradouro", length = 100)
    private String logradouro;
    
    @Column(name = "numero", length = 15)
    private String numero;
    
    @Column(name = "baiirro", length = 100)
    private String bairro;
    
    @Column(name = "cidade", length = 100)
    private String cidade;
    
 
    
	@Enumerated(EnumType.STRING)
    @Column(name = "uf", length = 2)
	private UfSiglas uf;
    
    @Column(name = "complemento", length = 100)
    private String complemento;
    
    @Column(name = "obs", length = 100)
    private String obs;
   
    

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumConvenio() {
		return numConvenio;
	}

	public void setNumConvenio(String numConvenio) {
		this.numConvenio = numConvenio;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getFoneFixo() {
		return foneFixo;
	}

	public void setFoneFixo(String foneFixo) {
		this.foneFixo = foneFixo;
	}

	public String getCelular1() {
		return celular1;
	}

	public void setCelular1(String celular1) {
		this.celular1 = celular1;
	}

	public String getCelular2() {
		return celular2;
	}

	public void setCelular2(String celular2) {
		this.celular2 = celular2;
	}

	public String getCelular3() {
		return celular3;
	}

	public void setCelular3(String celular3) {
		this.celular3 = celular3;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public String getCodCep() {
		return codCep;
	}

	public void setCodCep(String codCep) {
		this.codCep = codCep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public UfSiglas getUf() {
		return uf;
	}

	public void setUf(UfSiglas uf) {
		this.uf = uf;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return nome + "," + " Nº Convênio: " + numConvenio + ", Convênio: " + convenio + ", RG: " + rg;
	}
    
}
