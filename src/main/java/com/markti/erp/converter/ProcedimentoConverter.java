package com.markti.erp.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.markti.erp.model.Procedimento;
import com.markti.erp.repository.Procedimentos;



@FacesConverter(forClass = Procedimento.class, value="procedimentoConverter")
public class ProcedimentoConverter implements Converter{
	@Inject
	Procedimentos procedimentos;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
			 
		Procedimento retorno = null;
		
			if (value != null && !"".equals(value) && !value.equals("Selecione")) {
				
			
					 retorno = this.procedimentos.porId(new Long(value));
				
				
				}
			return retorno;
		 
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Procedimento procedimentos = ((Procedimento) value);
			return procedimentos.getId() == null ? null
			: procedimentos.getId().toString();
			}
			return null;
			}
	
}
