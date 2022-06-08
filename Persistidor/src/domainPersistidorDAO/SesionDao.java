package pablosz.demo.domainPersistidorDAO;


import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pablosz.demo.domainPersistidor.mapping.SId;

@Component
public class SesionDao
{
	@Autowired
	private EntityManager em;
	
	
	
	public SId find(int id_sesion){
		
		return em.find(SId.class, id_sesion);
	}
	@Transactional ( value = TxType.REQUIRED)
	public void persistSession(SId o){
		System.out.println("va a persistir desde SesionDao");
		//SId o = new SId();
		//o.setsId(id);
		em.persist(o);
	}
	
}
