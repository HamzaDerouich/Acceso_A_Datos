package base_de_datos.Ejercicio5;

import java.util.ArrayList;

public class Metadatos {

	private String gestor;
	private String driver;
	private String url;
	private String usuario;
	private ArrayList<String> nombres_tablas;

	public Metadatos(String gestor, String driver, String url, String usuario, ArrayList<String> nombres_tablas) {
		super();
		this.gestor = gestor;
		this.driver = driver;
		this.url = url;
		this.usuario = usuario;
		this.nombres_tablas = nombres_tablas;
	}

	public String getGestor() {
		return gestor;
	}

	public void setGestor(String gestor) {
		this.gestor = gestor;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public ArrayList<String> getNombres_tablas() {
		return nombres_tablas;
	}

	public void setNombres_tablas(ArrayList<String> nombres_tablas) {
		this.nombres_tablas = nombres_tablas;
	}
	@Override
	public String toString() {
	    return "Metadatos {" + 
	           "\ngestor=" + gestor + 
	           "\ndriver=" + driver + 
	           "\nurl=" + url + 
	           "\nusuario=" + usuario + 
	           "\nnombres_tablas=" + nombres_tablas + 
	           "\n}";
	}


	
	

	
}
