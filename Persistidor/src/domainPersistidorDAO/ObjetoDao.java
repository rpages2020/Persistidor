package pablosz.demo.domainPersistidorDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pablosz.demo.domainPersistidor.mapping.Objeto;

@Component
public class ObjetoDao
{
	@Autowired
	EntityManager em;
	
	public List<Objeto>findBySId(int sId)
	{
		String hql ="";
	//	hql+="SELECT nombre ";
	    hql+="FROM objeto ";
		hql+="WHERE p.id_sesion =:x ";
		Query q = em.createQuery(hql);
		q.setParameter("x",sId);
		return q.getResultList();
	}

	public List<Objeto> findByFatherId(int idObjeto)
	{
		String hql ="";
		//	hql+="SELECT nombre ";
		    hql+="FROM objeto ";
			hql+="WHERE p.id_padre =:x ";
			Query q = em.createQuery(hql);
			q.setParameter("x",idObjeto);
			return q.getResultList();
	}
	@Transactional
	public void persistObject(Objeto objeto)
	{
		em.persist(objeto);
		
	}
	
	
}


