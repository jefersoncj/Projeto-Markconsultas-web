package com.markti.erp.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.markti.erp.model.Convenio;
import com.markti.erp.repository.Convenios;


@FacesConverter(forClass = Convenio.class, value="convenioConverter")
public class ConvenioConverter implements Converter{

	@Inject
	Convenios convenios;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
			 
		Convenio retorno = null;
		
			if (value != null && !"".equals(value) && !value.equals("Selecione")) {
				
			
					 retorno = this.convenios.porId(new Long(value));
				
				
				}
			return retorno;
		 
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Convenio convenio = ((Convenio) value);
			return convenio.getId() == null ? null
			: convenio.getId().toString();
			}
			return null;
			}
	

}
