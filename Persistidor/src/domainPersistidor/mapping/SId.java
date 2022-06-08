package pablosz.demo.domainPersistidor.mapping;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.stereotype.Component;

@Entity
@Table(name= "sesion")
public class SId
{
	@Id
	@Column(name="id_sesion")
	private int sId;
	
	
	@OneToMany(mappedBy = "sesion",cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_sesion")
	private List<Clase> clases = new  ArrayList<>();
	
	@OneToMany(mappedBy = "sesionObjeto", cascade = CascadeType.ALL)
	private List<Objeto> objetos = new  ArrayList<>();
	
	public List<Clase> getClases()
	{
		return clases;
	}
	public void setClases(List<Clase> clases)
	{
		this.clases=clases;
	}
	public List<Objeto> getObjetos()
	{
		return objetos;
	}
	public void setObjetos(List<Objeto> objetos)
	{
		this.objetos=objetos;
	}
	public void vincularClase(Clase clase){
		//clase.setSesion(this);
		clases.add(clase);
	}
	public int getsId()
	{
		return sId;
	}

	public void setsId(int sId)
	{
		this.sId=sId;
	} 
	
}
