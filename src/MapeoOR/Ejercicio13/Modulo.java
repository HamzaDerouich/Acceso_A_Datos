package MapeoOR.Ejercicio13;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity(name ="modulo")		// identifica la clase como una entidad 
@Table(name = "modulo") 	// Nombre de la tabla en la base de datos
public class Modulo implements Serializable{
    @Id						//Clave primaria
    private String codigo;
    private String nombre;
    
    //Relaciones
    // con nota
    //mappedBy = "id.modulo" pq en nota tenemos (NotaId(alumno,modulo),nota)
    @OneToMany(mappedBy = "id.modulo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Nota> notas;
    
    // con profesor
    //mappedBy = "modulo" pq en imparte hemos definido la ManyToOne y queda más sencillo
    @OneToMany(mappedBy = "modulo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Imparte> imparte;
    
    // Getters y setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
	@Override
	public String toString() {
		return "Modulo [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((imparte == null) ? 0 : imparte.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((notas == null) ? 0 : notas.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Modulo other = (Modulo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (imparte == null) {
			if (other.imparte != null)
				return false;
		} else if (!imparte.equals(other.imparte))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (notas == null) {
			if (other.notas != null)
				return false;
		} else if (!notas.equals(other.notas))
			return false;
		return true;
	}
    
    
}