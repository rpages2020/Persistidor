package pablosz.demo.domainPersistidor;

import java.util.List;



import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pablosz.demo.Perfil;
import pablosz.demo.domainPersistidor.mapping.Clase;
import pablosz.demo.domainPersistidor.mapping.Objeto;
import pablosz.demo.domainPersistidor.mapping.SId;
import pablosz.demo.domainPersistidorDAO.ClaseDao;
import pablosz.demo.domainPersistidorDAO.ObjetoDao;
import pablosz.demo.domainPersistidorDAO.SesionDao;
import pablosz.demo.metodosEntrenamiento.PerfilDAOImp;
@Component//para poder inyectarlo con autowired en otro lado
public class Facade
{
 @Autowired
	private PerfilDAOImp p; 
	
 public Perfil encotrarPerfil(){
	 return p.findPerfilById();
 }
	@Autowired
	ObjetoDao objetoDao;
	
	@Autowired
	ClaseDao claseDao;
	
	@Autowired
	SesionDao sesionDao;
	
	public SId buscarIdDeSesion(int id){
		return sesionDao.find(id);
	}
	
	@Transactional
	public void persistirIdSesion(SId o){
		sesionDao.persistSession(o);
	}

	public List<Clase> obtenerClasesPorSId(int sId)
	{
		return claseDao.findAll(sId);
	}
	
	public int traerIdClase()
	{
		return 0;
	}

	public List<Objeto> encontrarObjetoPorSesion(int sId)
	{	
		return objetoDao.findBySId(sId);
	}

	public void borrarObjetosHijos(int idObjeto) // tienen que ser recursiva
	{
		
		
	}
	
	public List<Objeto> buscarPorIdPadre(int idPadre){
		return objetoDao.findByFatherId(idPadre);
	}
	@Transactional
	public void persistirClase(Clase clase)
	{
		claseDao.persistClass(clase);	
	}

	public void persistirObjeto(Objeto objeto)
	{
		objetoDao.persistObject(objeto);
	}

	
	
	
//	public List<String> obtenerClasesPorSId(int sId){//TODO
//		
//		return claseDao.findAll(sId);//obtiene una lista de Strings los cuales hayq ue comparar
//											// con el String del la clase del objeto a persistir
//	}
//	
//	public void persistirClase(Clase clase){
//		claseDao.persistClass(clase);
//	}
//	
}
