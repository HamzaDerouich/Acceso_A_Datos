package EjercicioFinal2.ejercicio3;

public class PersonaFusion 
{
	private String nombre;
	private String dni;
	private int edad;
	private String telefono;
	private String mail;
	
	public PersonaFusion(String nombre, String dni, int edad, String telefono, String mail) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.telefono = telefono;
		this.mail = mail;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "PersonaFusion [nombre=" + nombre + ", dni=" + dni + ", edad=" + edad + ", telefono=" + telefono
				+ ", mail=" + mail + "]";
	}
		
}
