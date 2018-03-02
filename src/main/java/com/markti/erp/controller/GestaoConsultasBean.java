package com.markti.erp.controller;

import java.io.Serializable;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;
import org.primefaces.event.ReorderEvent;
import org.primefaces.event.SelectEvent;

import com.markti.erp.model.CondPagto;
import com.markti.erp.model.Consulta;
import com.markti.erp.model.Convenio;
import com.markti.erp.model.Medico;
import com.markti.erp.model.Paciente;
import com.markti.erp.model.Procedimento;
import com.markti.erp.model.StatusConsulta;
import com.markti.erp.model.TipoConsulta;
import com.markti.erp.repository.CondPagtos;
import com.markti.erp.repository.Consultas;
import com.markti.erp.repository.Medicos;
import com.markti.erp.repository.Pacientes;
import com.markti.erp.repository.Procedimentos;
import com.markti.erp.service.CadastroConsultaService;
import com.markti.erp.util.FacesMessages;

@Named
@ViewScoped
public class GestaoConsultasBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Pacientes pacientes;
	
	@Inject
	private CondPagtos condPagtos;
	
	@Inject
	private Procedimentos procedimentos;
	
	@Inject
	private Consultas consultas;
	
	@Inject
	private Medicos medicos;
	
	@Inject
	private CadastroConsultaService cadastroConsulta;
	
	@Inject
	private FacesMessages messages;
	
	
	private List<Consulta> filtroConsulta;
	private List<Convenio> todosConvenios;
	private List<Paciente> todosPacientes;
	private List<Medico> todosMedicos;
	private List<Procedimento> todosProcedimentos;
	private List<CondPagto> todosCondPagtos;
	
	private List<Consulta> todasConsultas;
	private Consulta consultaEdicao = new Consulta();
	
	private Consulta consultaSelecionada;
	
	private boolean value = false;  
	private Date date1 = new Date();
    
    public boolean getValue() {  
        return value;  
    }  
  
    public void setValue() {  
    	
		if (consultaEdicao.getTipo().getDescricao().equals("Procedimento")) {
			value = true;
		}else{
			value = false;
		}
    	
		
      
    } 
    
    
    public Date getDate1() {
        return date1;
    }
 
    public void setDate1(Date date1) {
        this.date1 = date1;
    }
    
	public void prepararNovoCadastro() {
		consultaEdicao = new Consulta();
	}
	
	public String getTip(){
		
		return "procedimento";
		
	}

	
	public void salvar() {
		consultaEdicao.setDataConsulta(date1);
		cadastroConsulta.salvar(consultaEdicao);
		consultar2();
		
		messages.info("Consulta salva com sucesso!");
		
		RequestContext.getCurrentInstance().update(
				Arrays.asList("frm:msgs", "frm:consultas-table"));
	}
	
	public void buscaPorData(SelectEvent event) {
		 SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		 
			todasConsultas = consultas.buscaPo(format.format(event.getObject()));
			
		 RequestContext.getCurrentInstance().update(
					Arrays.asList("frm:msgs", "frm:consultas-table"));
		
	}
	
	public void dataAnterior(){
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date1);
		calendar.add(Calendar.DAY_OF_MONTH, -1);
		date1 = calendar.getTime();
		consultar2();
		
	}
	
	public void proximaData(){
		Calendar calendar = Calendar.getInstance();  
		calendar.setTime(date1);
		calendar.add(Calendar.DAY_OF_MONTH, +1);
		date1 = calendar.getTime();
		consultar2();
		
	}
	public void consultar2() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
		todasConsultas = consultas.buscaPo(format.format(date1));
	}
	
	public void excluir() {
		cadastroConsulta.excluir(consultaSelecionada);
		consultaSelecionada = null;
		
		consultar();
		
		messages.info("Consulta excluída com sucesso!");
	}
	
	
	public void consultar() {
		todasConsultas = consultas.todas();
	}
	
	public List<Convenio> getTodosConvenios() {
		todosConvenios = pacientes.todasConvenios();
		return todosConvenios;
	}

	public List<Consulta> getTodasConsultas() {
		return todasConsultas;
	}
	
	public StatusConsulta[] getStatusConsultas() {
		return StatusConsulta.values();
	}
	
	
	public TipoConsulta[] getTiposConsultas() {
		return TipoConsulta.values();
	}
	
	
	public List<Paciente> getTodosPacientes() {
		todosPacientes = pacientes.todas();
		return todosPacientes;
	}
	
	public List<Medico> getTodosMedicos() {
		todosMedicos = medicos.todos();
		return todosMedicos;
	}
	
	public List<Procedimento> getTodosProcedimentos() {
		todosProcedimentos = procedimentos.todos();
		return todosProcedimentos;
	}
	
	public List<CondPagto> getTodosCondPagtos() {
		todosCondPagtos = condPagtos.todos();
		return todosCondPagtos;
	}
	public Consulta getConsultaEdicao() {
		return consultaEdicao;
	}

	public void setConsultaEdicao(Consulta consultaEdicao) {
		this.consultaEdicao = consultaEdicao;
	}

	public Consulta getConsultaSelecionada() {
		return consultaSelecionada;
	}
	
	

	public void setConsultaSelecionada(Consulta consultaSelecionada) {
		this.consultaSelecionada = consultaSelecionada;
	}
	
	
	
	 public List<Consulta> getFiltroConsulta() {
		return filtroConsulta;
	}

	public void setFiltroConsulta(List<Consulta> filtroConsulta) {
		this.filtroConsulta = filtroConsulta;
	}

	public static String datePattern() {
		   return "dd/MM/yyyy";
		 }
	public static String customFormatDate(Date date) {
		   if (date != null) {
		       DateFormat format = new SimpleDateFormat(datePattern());
		       return format.format(date);
		    }
		   return "";
		}
	
	public void handleDateSelect(SelectEvent event) {
	    RequestContext.getCurrentInstance().execute("PF('Table').filter()");
	}
	
	public void onRowReorder(ReorderEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Row Moved", "From: " + event.getFromIndex() + ", To:" + event.getToIndex());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}