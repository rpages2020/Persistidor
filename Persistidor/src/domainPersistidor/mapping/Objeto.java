package pablosz.demo.domainPersistidor.mapping;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name= "objeto")
public class Objeto
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_objeto")
	private int idObjeto;
	
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="id_clase")
	private Clase clase;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_sesion")
	private SId  sesionObjeto;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_padre")
	private Objeto padre;
	
	private boolean primitivo;
	
	private String nombre;
	
	private String valor;
	
	
	@OneToMany(mappedBy = "padre", cascade = CascadeType.ALL)
	private List<Objeto> objetosHijos;


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
		return sesionObjeto;
	}

	public void setSesion(SId sesion)
	{
		this.sesionObjeto =sesion;
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

	public int getIdObjeto()
	{
		return idObjeto;
	}

	public void setIdObjeto(int idObjeto)
	{
		this.idObjeto=idObjeto;
	}

	public SId getSesionObjeto()
	{
		return sesionObjeto;
	}

	public void setSesionObjeto(SId sesionObjeto)
	{
		this.sesionObjeto=sesionObjeto;
	}

	public Objeto getPadre()
	{
		return padre;
	}

	public void setPadre(Objeto padre)
	{
		this.padre=padre;
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

	public List<Objeto> getObjetosHijos()
	{
		return objetosHijos;
	}

	public void setObjetosHijos(List<Objeto> objetosHijos)
	{
		this.objetosHijos=objetosHijos;
	}

	public void setPrimitivo(boolean primitivo)
	{
		this.primitivo=primitivo;
	}


}