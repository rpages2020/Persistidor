package test;
import java.lang.reflect.*;
import domain.*;
import java.sql.*;
public class testPersistidor

{
	@SuppressWarnings("unchecked")
	public static void main(String[] args)
	{
	Persistidor persistidor = new Persistidor();	
	Persona2 p2= new Persona2();
	p2.setDni(18192019);
	p2.setNombre("Fernando");
	Persona p = new Persona();
	p.setDni(36566754);
	p.setNombre("Ruben");
		boolean resp = persistidor.store(1, p2);
	
	}
}	
		
//		
//		System.out.print(p.getClass().toString()+"\n");
//		try
//		{
//		// denimos el nombre de la clase (incluyendo el paquete)
//		String sClass = "domain.Persona";
//		// obtengo una instancia de Class apuntando a la clase
//		Class clazz = Class.forName(sClass);
//		// obtengo la lista de methods (de tipo Method) de la clase
//		Method mtdos[] = clazz.getDeclaredMethods();
//		// recorro la lista de methods y muestro sus nombres
//		Field atributos[] = clazz.getDeclaredFields();
//		
//		for(Method mtd: mtdos)
//		{
//		System.out.println(mtd.getName());
//		}
//		for(Field atr: atributos)
//		{
//		System.out.println(atr.getName());
//		}
//		}
//		catch(Exception ex)
//		{
//		ex.printStackTrace();
//		throw new RuntimeException(ex);
//	}
//	}
	
	

