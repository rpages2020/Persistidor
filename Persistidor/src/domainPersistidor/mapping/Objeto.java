package pablosz.demo.domainPersistidor.mapping;

import javax.persistence.*;


@Entity
@Table(name= "objeto")
public class Objeto
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_objeto")
	private int idObjeto;
	
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="id_clase")
	private Clase clase;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name = "id_sesion")
	private SId  sesion;
	
//	@ManyToOne
//	@JoinColumn(name="id_objeto")
	private int id_padre;
	
	private boolean primitivo;
	
	private String nombre;
	
	private String valor;

	public int getIdObjeto()
	{
		return idObjeto;
	}

	public void setIdObjeto(int idObjeto)
	{
		this.idObjeto=idObjeto;
	}

	public Clase getClase()
	{
		return clase;
	}

	public void setClase(Clase clase)
	{
		this.clase=clase;
	}

	public SId getSesion()
	{
		return sesion;
	}

	public void setSesion(SId sesion)
	{
		this.sesion=sesion;
	}

//	public Objeto getId_padre()
//	{
//		return id_padre;
//	}
//
//	public void setId_padre(Objeto id_padre)
//	{
//		this.id_padre=id_padre;
//	}

	public boolean isPrimitivo()
	{
		return primitivo;
	}

	public int getId_padre()
	{
		return id_padre;
	}

	public void setId_padre(int id_padre)
	{
		this.id_padre=id_padre;
	}

	public void setPrimitivo(boolean primitivo)
	{
		this.primitivo=primitivo;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}

	public String getValor()
	{
		return valor;
	}

	public void setValor(String valor)
	{
		this.valor=valor;
	}	

	
}
