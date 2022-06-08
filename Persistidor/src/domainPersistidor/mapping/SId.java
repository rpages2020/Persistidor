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
