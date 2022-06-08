package pablosz.demo.domainPersistidor;

import pablosz.demo.domainPersistidorannotations.NotPersistable;
import pablosz.demo.domainPersistidorannotations.Persistable;

@Persistable
public class Persona
{
	@Persistable
	private int dni;
	@NotPersistable
	private String nombre;
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
