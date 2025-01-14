package MapeoOR.Ejercicio13;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity(name = "imparte") 
@Table(name = "imparte") // Nombre de la tabla en la base de datos
public class Imparte implements Serializable{

	@EmbeddedId  			// Indicar que clave primaria es compuesta 
	private ImparteId id;	// Clave compuesta (profesor, modulo)

 
	public Imparte() {
	}
	
	
	
	public Imparte(Profesor profesor, Modulo modulo) {
	    // Inicializamos la clave compuesta con los valores de las claves de las entidades asociadas.
	    this.id = new ImparteId(profesor.getId(), modulo.getCodigo());
	    
	    // Establecemos las relaciones con las entidades.
	    this.profesor = profesor;
	    this.modulo = modulo;
	}



	//En este caso vamos a poner AQUI las anotaciones @ManyToOne y @JoinColumn, 
    //de esta forma usamos @MapsId para mapear
	

	@ManyToOne
    @MapsId("profesor") // Mapea el campo profesor de ImparteId a Profesor
    @JoinColumn(name = "profesor", referencedColumnName = "id")
    private Profesor profesor;

    @ManyToOne
    @MapsId("modulo") // Mapea el campo modulo de ImparteId a Modulo
    @JoinColumn(name = "modulo", referencedColumnName = "codigo")
    private Modulo modulo;

    //@JoinColumn
    //name es el nombre de la columna en la tabla de la bd
    //referencedColumnName el campo que es clave en la otra tabla.
    
    
    
    // Getters y setters
    public ImparteId getId() {
        return id;
    }

    public void setId(ImparteId id) {
        this.id = id;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }
	
    @Override
    public String toString() {
        return "Imparte [id=" + id + ", profesor=" + profesor + ", modulo=" + modulo + "]";
    }
    
    
    
}