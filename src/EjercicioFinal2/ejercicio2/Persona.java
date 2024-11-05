package EjercicioFinal2.ejercicio2;

import javax.xml.bind.annotation.XmlElement;

public class Persona {

    private String dni;
    private String telefono;
    private String email;

    public Persona() {
    }

    public Persona(String dni, String telefono, String email) {
        this.dni = dni;
        this.telefono = telefono;
        this.email = email;
    }


    @XmlElement(name = "dni")
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @XmlElement(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @XmlElement(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
