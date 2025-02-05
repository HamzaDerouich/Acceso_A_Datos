package PostGresSql.Ejercicio12;

public class Direccion {

	private String calle;
	private String poblacion;
	private int cp;

	public Direccion(String calle, String poblacion, int cp) {
		super();
		this.calle = calle;
		this.poblacion = poblacion;
		this.cp = cp;
	}

	

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", poblacion=" + poblacion + ", cp=" + cp + "]";
	}

}
