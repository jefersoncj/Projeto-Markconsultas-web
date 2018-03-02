package com.markti.erp.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.markti.erp.model.Paciente;
import com.markti.erp.repository.Pacientes;



@FacesConverter(forClass = Paciente.class, value="pacienteConverter")
public class PacienteConverter implements Converter{

	@Inject
	Pacientes pacientes;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
			 
		Paciente retorno = null;
		
			if (value != null && !"".equals(value) && !value.equals("Selecione")) {
				
			
					 retorno = this.pacientes.porId(new Long(value));
				
				
				}
			return retorno;
		 
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Paciente paciente = ((Paciente) value);
			return paciente.getId() == null ? null
			: paciente.getId().toString();
			}
			return null;
			}
	

}
