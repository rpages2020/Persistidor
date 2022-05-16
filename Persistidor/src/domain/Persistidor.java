package domain;

import java.lang.reflect.*;
import domain.Persona;
public class Persistidor
{
	@SuppressWarnings("unchecked")
	public boolean store(int sId, Object obj) {
		boolean guardo = true;
		// ver si guarda o actualiza, supongo que sera buscar en la base si tiene un objeto asociado
		try{
		String sClass = obj.getClass().toString();
		Class clazz = Class.forName(sClass.substring(6));
		Field atributos[] = clazz.getDeclaredFields();
		
//	 obtener el nombre de los atributos ,  el tipo, y valores persistibles
		for(Field atr: atributos)
		{
			System.out.println(atr.getName());
			mostrarValores(atr, obj);
		
		}
	}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
		return guardo;
	}



public void mostrarValores(Field atr, Object obj) throws IllegalArgumentException, IllegalAccessException{
	atr.setAccessible(true);
	Object aux = atr.get(obj);
	System.out.println(aux);
	System.out.println(atr.getType().toString());
	atr.setAccessible(false);
}

}
