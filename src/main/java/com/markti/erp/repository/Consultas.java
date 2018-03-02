package com.markti.erp.repository;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import com.markti.erp.model.Consulta;




public class Consultas implements Serializable {

	private static final long serialVersionUID = 1L;
		
	@Inject
	private EntityManager manager;
	
	
	List<Consulta> con;
	
	public Consulta porId(Long id) {
		return manager.find(Consulta.class, id);
	}
	
	public List<Consulta> todas() {
		return manager.createQuery("from Consulta", Consulta.class).getResultList();
	}
	
	public List<Consulta> buscaPo(String data) {
		String jpql =  "select c from Consulta c where data_consulta =:data_consulta";
		 Date dateOfBirth = null;
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	        try {
	            dateOfBirth = formatter.parse(data);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
		 TypedQuery<Consulta> query = manager.createQuery(jpql, Consulta.class);
				 query.setParameter("data_consulta",dateOfBirth, TemporalType.DATE);
				
				
				 List<Consulta> listas = query.getResultList();
			/*	 manager.createQuery("select c from Consulta c where c.data_consulta = '%Cicero Jeferson%'",Consulta.class).getResultList();*/
		
				 for (Object object : listas) {
					
					 Consulta con = (Consulta) object;
					System.out.println(con.getPaciente().getNome());
				}
				return listas;
				
		
		
	}
	
	
	public Consulta guardar(Consulta consulta) {
		return manager.merge(consulta);
		
	}
	
	public void remover(Consulta consulta) {
		consulta = porId(consulta.getId());
		manager.remove(consulta);
	}

}