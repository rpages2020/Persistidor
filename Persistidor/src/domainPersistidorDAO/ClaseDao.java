package pablosz.demo.domainPersistidorDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pablosz.demo.domainPersistidor.mapping.Clase;

@Component
public class ClaseDao
{
	@Autowired
	EntityManager em;
	
	
	public List<Clase> findAll(int sId){
		String hql ="";
		//hql+="SELECT nombre ";
	    hql+="FROM clase ";
		hql+="WHERE p.id_sesion =:x ";
		Query q = em.createQuery(hql);
		q.setParameter("x",sId);
	   return q.getResultList();
	}
	@Transactional ( value = TxType.REQUIRED)
	public void persistClass(Clase clase){
		em.persist(clase);
	}

}
