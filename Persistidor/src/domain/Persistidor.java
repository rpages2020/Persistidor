package domain;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.List;

//import org.slf4j.Logger;

import com.sun.org.apache.xml.internal.utils.StringComparable;

import domain.Persona;

public class Persistidor
{
	@SuppressWarnings("unchecked")
	public boolean store(int sId, Object obj)
	{
		boolean guardo=true;
		// ver si guarda o actualiza, supongo que sera buscar en la base si
		// tiene un objeto asociado
		
		persistirSId(sId);
		
		try
		{

			Class clazz = obtenerClazz(obj);
			
			persistirClase(clazz.toString().substring(6), sId);
			
			Field atributos[]=obtenerAtributos(clazz);

			Annotation anotaciones[]=obtenerAnotaciones(clazz);
			for(int i=0; i<anotaciones.length; i++)
			{
				System.out.println(anotaciones[i]);
			}
			boolean clasePersistible = verificarPersistencia(anotaciones);

			if(clasePersistible)
			{
				System.out.println("--Clase @Persistable verificar campos @NotPersistables--");
				for(Field atr:atributos){
					Annotation anotacionesDeAtributo[] = obtenerAnotaciones(atr);
					if(!verificarNoPersistencia(anotacionesDeAtributo)){
						persistirAtributo(atr);
						mostrarValores(atr,obj);
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
						persistirAtributo(atr);
						mostrarValores(atr,obj);
					}
				}
			}
		}

		catch(Exception ex)
		{
			ex.printStackTrace();
		}

		return guardo;
	}

	public void mostrarValores(Field atr, Object obj) throws IllegalArgumentException,IllegalAccessException
	{
		atr.setAccessible(true);
		Object aux=atr.get(obj);
		System.out.println(aux);
		System.out.println(atr.getType().toString());
		atr.setAccessible(false);
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
	
	public void persistirSId(int sId){
		//TODO
	}
	
	public void persistirClase(String clase, int sId){// auto incrementable el id hace falta??
		//TODO
	}
	public void persistirAtributo(Field atr){
		//TODO
	}
	
	
}