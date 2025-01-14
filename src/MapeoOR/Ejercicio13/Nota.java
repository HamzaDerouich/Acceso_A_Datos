package MapeoOR.Ejercicio13;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity				  // Define la clase como una entidad JPA.
@Table(name = "nota") // Nombre de la tabla en la base de datos
public class Nota implements Serializable{

      @EmbeddedId  		 // Indicar que clave primaria es compuesta 
      private NotaId id; // representada por la clase NotaId que es (alumno, modulo)
      private Double nota;
      
	//La clase Nota no tiene directamente las anotaciones @ManyToOne ni @JoinColumn, 
    //que estarán en la clase NotaId.
      
      
      
    // Constructores, getters y setters
    public Nota() {}

    public Nota(NotaId id, Double nota) {
        this.id = id;
        this.nota = nota;

        
    }
    
    public NotaId getId() {
        return id;
    }
    public void setId(NotaId id) {
        this.id = id;
    }
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }

   

	@Override
	public String toString() {
		return "Nota [id=" + id + ", nota=" + nota + "]"+"\n";
	}

    
    
}