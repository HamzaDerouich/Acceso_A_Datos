package EjercicioFinal2.ejercicio2;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "personas")
public class Personas {

	private List<Persona> listado_personas_xml;

	@XmlElement(name = "persona")
	public List<Persona> getListado_personas_xml() {
		return listado_personas_xml;
	}

	public void setListado_personas_xml(List<Persona> listado_personas_xml) {
		this.listado_personas_xml = listado_personas_xml;
	}

}
