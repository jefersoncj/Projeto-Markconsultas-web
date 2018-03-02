package com.markti.erp.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.markti.erp.model.Medico;
import com.markti.erp.repository.Medicos;



@FacesConverter(forClass = Medico.class, value="medicoConverter")
public class MedicoConverter implements Converter{

	@Inject
	Medicos medicos;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
			 
		Medico retorno = null;
		
			if (value != null && !"".equals(value) && !value.equals("Selecione")) {
				
			
					 retorno = this.medicos.porId(new Long(value));
				
				
				}
			return retorno;
		 
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Medico medico = ((Medico) value);
			return medico.getId() == null ? null
			: medico.getId().toString();
			}
			return null;
			}
	

}
