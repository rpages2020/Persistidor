package pablosz.demo.domainPersistidor;

import java.util.ArrayList;

import pablosz.demo.domainPersistidorannotations.Persistable;

public class Persona2
{
	private int dni;
	@Persistable
	private String nombre;
	private ArrayList<String> telefonos;
	
	
	
	public ArrayList<String> getTelefonos()
	{
		return telefonos;
	}
	public void setTelefonos(ArrayList<String> telefonos)
	{
		this.telefonos=telefonos;
	}
	public int getDni()
	{
		return dni;
	}
	public void setDni(int dni)
	{
		this.dni=dni;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
}
