package PostGresSql.Ejercicio3;

public class Mascota {

	private int id;
	private String nombre;
	private String especie;
	private String raza;


	public Mascota(String nombre, String especie, String raza) {
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
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

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	@Override
	public String toString() {
		return "Mascota [id=" + id + ", nombre=" + nombre + ", especie=" + especie + ", raza=" + raza + "]";
	}

}
