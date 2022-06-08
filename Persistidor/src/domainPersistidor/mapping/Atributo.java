package pablosz.demo.domainPersistidor.mapping;

import javax.persistence.*;
@Entity
@Table(name="atributo")
public class Atributo
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_atributo")
	private int idAtributo;
	
	@ManyToOne
	@JoinColumn(name="id_Objeto")
	private Objeto objeto;
	
	private String nombre;
	
	private String tipo;
	
	private String valor;// quizas deberia ser un enum o  check

	public int getIdAtributo()
	{
		return idAtributo;
	}

	public void setIdAtributo(int idAtributo)
	{
		this.idAtributo=idAtributo;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo=tipo;
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

