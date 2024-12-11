package MapeoOR.Ejercicio2;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table( name = "profesor" )
public class Profesor 
{
	@Id
	@Column(name = "ID")
	private int id;
	
	private String nombre;
	
	
}
