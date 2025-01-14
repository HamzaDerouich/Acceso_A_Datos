package MapeoOR.Ejercicio13;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ImparteId implements Serializable{

	int profesor;
	String modulo;
	
	public ImparteId() {
		}

    public ImparteId(int profesor, String modulo) {
        this.profesor = profesor;
        this.modulo = modulo;
    }
	
	public int getProfesor() {
		return profesor;
	}

	public void setProfesor(int profesor) {
		this.profesor = profesor;
	}

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modulo == null) ? 0 : modulo.hashCode());
		result = prime * result + profesor;
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
		ImparteId other = (ImparteId) obj;
		if (modulo == null) {
			if (other.modulo != null)
				return false;
		} else if (!modulo.equals(other.modulo))
			return false;
		if (profesor != other.profesor)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ImparteId [profesor=" + profesor + ", modulo=" + modulo + "]";
	}
	
	
	

}