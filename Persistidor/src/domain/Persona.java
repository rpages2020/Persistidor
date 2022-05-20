package domain;
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
