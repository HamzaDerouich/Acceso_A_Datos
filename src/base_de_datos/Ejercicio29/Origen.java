package base_de_datos.Ejercicio29;

import java.io.Serializable;

public class Origen  implements Serializable
{
	private int id;
    private String region;
    private String pais;
    
	public String getRegion() {
		return region;
	}

	public void setOrigen(String origen) {
		this.region = origen;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Origen [origen=" + region + ", pais=" + pais + "]";
	}
	
	
    
    
}
