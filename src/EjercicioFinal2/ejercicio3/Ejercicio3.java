package EjercicioFinal2.ejercicio3;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.ObjectMapper;

import EjercicioFinal2.ejercicio1.ListadoPersonas;
import EjercicioFinal2.ejercicio2.Persona;
import EjercicioFinal2.ejercicio2.Personas;

public class Ejercicio3 {

	static List<EjercicioFinal2.ejercicio1.Personas> listado_personas_json = new ArrayList<>();
	static List<Persona> listado_personas_xml = new ArrayList<>();
	static List<PersonaFusion> listado_personas_xml_json = new ArrayList<PersonaFusion>();

	
	public static void LeerFicheroXMl() {

		try {
			// Crear un contexto JAXB para las clases 'Personas'

			JAXBContext context = JAXBContext.newInstance(Personas.class);

			// Crear el deserializador (unmarshaller)

			Unmarshaller unmarshaller = context.createUnmarshaller();

			// Leer el archivo XML y mapearlo a objetos Java

			File file = new File("FicherosXML//personas.xml");
			Personas personas = (Personas) unmarshaller.unmarshal(file);

			// Mostrar los resultados
			
			listado_personas_xml = personas.getListado_personas_xml();
			

		} catch (JAXBException e) {
			e.printStackTrace();
		}

	}

	public static void LeerFicheroJson() {

		ObjectMapper objectMapper = new ObjectMapper();
		try {

			ListadoPersonas personas = objectMapper.readValue(new File("FicherosJSON/personas.json"),
					ListadoPersonas.class);

			listado_personas_json = personas.getPersonas();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void FusionarPersona()
	{
		for (EjercicioFinal2.ejercicio1.Personas p1 : listado_personas_json) 
		{
			for (Persona p2 : listado_personas_xml) 
			{
				if( p1.getPersona().getDni().equals(p2.getDni()))
				{
					PersonaFusion pf = new PersonaFusion(p1.getPersona().getNombre(), p1.getPersona().getDni(), p1.getPersona().getEdad(), p2.getTelefono(), p2.getEmail());
					listado_personas_xml_json.add(pf);
				}
			}
		}	
	}
	
	
	public static void main(String[] args) 
	{
		LeerFicheroJson();
		LeerFicheroXMl();
		FusionarPersona();
		System.out.println("======Personas_Fusionadas======");
		for (PersonaFusion p : listado_personas_xml_json) 
		{
			System.out.println("=================================");
			System.out.println("Nombre: " + p.getNombre());
			System.out.println("Dni: "+ p.getDni());
			System.out.println("Edad: "+ p.getEdad());
			System.out.println("Telefono: " + p.getTelefono());
			System.out.println("Mail: "+ p.getMail());
			System.out.println("=================================");

		}
	}

}
