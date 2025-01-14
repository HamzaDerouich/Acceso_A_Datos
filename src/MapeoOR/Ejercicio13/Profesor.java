package MapeoOR.Ejercicio13;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


@Entity(name ="profesor")  //entidad
@Table(name ="profesor")	//nombre de la tabla
public class Profesor implements Serializable{
	
	@Id						//Clave primaria
	@Column (name="id")		//Se corresponde con la columna id
	private int id;
	
	@Column (name="nombre")
	private String nombre;
	
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imparte> impartidos;

	
	public Profesor() {
		super();
	}
	public Profesor(int id, String nombre) {

		this.id = id;
		this.nombre = nombre;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public List<Imparte> getImpartidos() {
		return impartidos;
	}
	public void setImpartidos(List<Imparte> impartidos) {
		this.impartidos = impartidos;
	}
	
	public String mostrarImpartidos(){
		String modulos="";
		for(Imparte I: impartidos){
			modulos=modulos+" "+I.getModulo()+"\n";
		}
		return modulos;
	}
	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", Impartidos=" + mostrarImpartidos() + "]";
	}

	
	
	

}