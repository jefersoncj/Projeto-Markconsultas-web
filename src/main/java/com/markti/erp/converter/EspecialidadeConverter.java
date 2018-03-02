package com.markti.erp.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.markti.erp.model.Especialidade;
import com.markti.erp.repository.Especialidades;


@FacesConverter(forClass = Especialidade.class, value="especialidadeConverter")
public class EspecialidadeConverter implements Converter{

	@Inject
	Especialidades especialidades;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
			 
		Especialidade retorno = null;
		
			if (value != null && !"".equals(value) && !value.equals("Selecione")) {
				
			
					 retorno = this.especialidades.porId(new Long(value));
				
				
				}
			return retorno;
		 
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Especialidade especialidade = ((Especialidade) value);
			return especialidade.getId() == null ? null
			: especialidade.getId().toString();
			}
			return null;
			}
	

}
