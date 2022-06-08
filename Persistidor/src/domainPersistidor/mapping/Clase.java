package pablosz.demo.domainPersistidor.mapping;
import pablosz.demo.domainPersistidor.mapping.SId;
import javax.persistence.*;
@Entity
@Table(name="clasess")
public class Clase
{

	@Id
	@Column(name="id_clase")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idClase;
	
	@ManyToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="id_sesion")
	//@Column (name = "id_sesion")
	private SId sesion;
	
	@Column(name="nombre")
	private String nombre;

	public int getIdClase()
	{
		return idClase;
	}

	public void setIdClase(int idClase)
	{
		this.idClase=idClase;
	}

	public SId getSesion()
	{
		return sesion;
	}

	public void setSesion(SId sesion)
	{
		this.sesion=sesion;
	}

	public String getNombre()
	{
		return nombre;
	}

//	public int getSesion()
//	{
//		return sesion;
//	}
//
//	public void setSesion(int sesion)
//	{
//		this.sesion=sesion;
//	}

	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
}
