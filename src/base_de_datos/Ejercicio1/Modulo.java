package base_de_datos.Ejercicio1;

public class Modulo {
	private String codigo;
	private String nombre;

	public Modulo(String codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Modulo [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
}
