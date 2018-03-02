package com.markti.erp.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.markti.erp.model.CondPagto;
import com.markti.erp.repository.CondPagtos;


@FacesConverter(forClass = CondPagto.class, value="condPagtoConverter")
public class CondPagtoConverter implements Converter{

	@Inject
	CondPagtos condPagtos;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
			 
		CondPagto retorno = null;
		
			if (value != null && !"".equals(value) && !value.equals("Selecione")) {
				
			
					 retorno = this.condPagtos.porId(new Long(value));
				
				
				}
			return retorno;
		 
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			CondPagto condPagto = ((CondPagto) value);
			return condPagto.getId() == null ? null
			: condPagto.getId().toString();
			}
			return null;
			}

}
