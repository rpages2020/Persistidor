package pablosz.demo.domainPersistidor;

import java.lang.annotation.Annotation;

import java.lang.reflect.*;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

//import org.slf4j.Logger;

import com.sun.org.apache.xml.internal.utils.StringComparable;

import pablosz.demo.domainPersistidor.Persona;
import pablosz.demo.domainPersistidor.mapping.Atributo;
import pablosz.demo.domainPersistidor.mapping.Clase;
import pablosz.demo.domainPersistidor.mapping.Objeto;
import pablosz.demo.domainPersistidor.mapping.SId;

public class Persistidor
{
	@Autowired
	EntityManager em;
	
	@Autowired
	Facade facade;
	
	@SuppressWarnings("unchecked")
	public boolean store(int sId, Object obj)
	{
		Clase claseEnTabla;
		boolean accion = false;
		SId sesion = new  SId();
		if(persistirSId(sId)){
			facade.persistirIdSesion(sesion);
		}else{
		
		try
		{
			
			Class clazz = obtenerClazz(obj);
			String clase = clazz.toString().substring(6);// ver de cambiar esto
			
			List<Clase> clasesGuardadas= facade.obtenerClasesPorSId(sId);//TODO
			for(Clase c:clasesGuardadas){
				if(c.getNombre().compareTo(clase) == 0){
					accion = true;
					claseEnTabla = c;/// se fija si actualiza o guarda 	
			}
			}
			if(!accion){ // actualiza   //trae todo lo del objeto y cambia lo que  hay que cambiar
				List<Objeto> objetosDeSId = facade.encontrarObjetoPorSesion(sId);
				for(Objeto objeto: objetosDeSId){
					Clase claseDeObjeto = objeto.getClase();
					if(claseDeObjeto.getNombre().compareTo(claseEnTabla.getNombre())== 0){
						//TODO // actualizara los datos segun sena persistibles
						break;
					}
				}
			}else{
			persistirClase(clase, sId);
			int idClaseGuardada = facade.traerIdClase();
			}
	
			
			Field atributos[]= obtenerAtributos(clazz); //Desde aca es lo mismo simplemente persiste los atributos  
			Annotation anotacionesDeClase[] = obtenerAnotaciones(clazz);
//			for(int i=0; i<anotaciones.length; i++)	{System.out.println(anotaciones[i]);}

			if(verificarPersistencia(anotacionesDeClase))
			{
				System.out.println("--Clase @Persistable verificar campos @NotPersistables--");
				for(Field atr:atributos){
					Annotation anotacionesDeAtributo[] = obtenerAnotaciones(atr);
					if(!verificarNoPersistencia(anotacionesDeAtributo)){
						//persistirAtributo(atr, obj);
						//mostrarValores(atr,obj);
					}
				}
			}
			else
			{
				System.out.println("--Clase sin  @Persisitable verificar campos @Persistables--");
				for(Field atr:atributos)
				{
					Annotation anotacionesDeAtributo[] = obtenerAnotaciones(atr);
					if(verificarPersistencia(anotacionesDeAtributo)){
						//persistirAtributo(atr);
						//mostrarValores(atr,obj);
					}
				}
			}
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		}
		return accion;
	}

	public void mostrarValores(Field atr, Object obj) throws IllegalArgumentException,IllegalAccessException
	{
		atr.setAccessible(true);
		Object aux=atr.get(obj);
		System.out.println(aux);
		System.out.println(atr.getType().toString());
		atr.setAccessible(false);// cuidado nico dijo algo-- borrar
	}

	public Class obtenerClazz(Object obj) throws Exception
	{
		String sClass=obj.getClass().toString();
		Class clazz=Class.forName(sClass.substring(6));
		//System.out.println("----"+clazz.toString().substring(6));
		return clazz;
	}

	public Field[] obtenerAtributos(Class clazz)
	{
		return clazz.getDeclaredFields();
	}
	

	public Annotation[] obtenerAnotaciones(Class clazz)
	{
		return clazz.getAnnotations();
	}
	public Annotation[] obtenerAnotaciones(Field atr)
	{
		return atr.getAnnotations();
	}

	public boolean verificarPersistencia(Annotation anotaciones[])
	{
		boolean persistible=false;
		for(int i=0; i<anotaciones.length; i++)
		{
			System.out.println(anotaciones[i].toString().substring(8));
			if(anotaciones[i].toString().substring(8).equals("Persistable(persistable=true)"))
			{
				persistible=true;
			}
		}
		return persistible;
	}
	
	public boolean verificarNoPersistencia(Annotation anotaciones[])
	{
		boolean notPersistible = false;
		for(int i=0; i<anotaciones.length; i++)
		{
			System.out.println(anotaciones[i].toString().substring(8));
			if(anotaciones[i].toString().substring(8).equals("NotPersistable(persistable=false)"))
			{
				notPersistible=true;
			}

		}
		return notPersistible;
	}
	
	public boolean persistirSId(int sId){// puede cambiar si conozco otros metodos para traer uno solo 
		//TODO
		boolean persistir = true;
		
			if(facade.buscarIdDeSesion(sId)==null){
				persistir = false;
		}
		return persistir;
	}
	
	public void persistirClase(String clase, int sId){// auto incrementable el id hace falta??
		Clase objetoClase = new Clase();
		objetoClase.setNombre(clase);
		facade.persistirClase(objetoClase);
	}
	public void persistirAtributo(Field atr, Object ob){
		//TODO
		Atributo a = new Atributo(); 
		atr.setAccessible(true);
		a.setValor(atr.get(ob).toString());
		a.setNombre(atr.getName().toString());
		a.setTipo(atr.getType().toString());
		
		facade.persistirAtributo();
	}
	
	
}