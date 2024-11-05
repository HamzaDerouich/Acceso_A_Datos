package EjercicioFinal2.ejercicio1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LeerFicheroJson {

	static List<Persona> listado_personas = new ArrayList<Persona>();
	
	public static void LeerPersonas() {
		
		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {

			ListadoPersonas personas = objectMapper.readValue(new File("FicherosJSON/personas.json"),
					ListadoPersonas.class);

			for (Personas p : personas.getPersonas()) 
			{
				 System.out.println("=========================================");
			     System.out.println("Nombre: " + p.getPersona().getNombre());
			     System.out.println("Dni: " + p.getPersona().getDni());
			     System.out.println("Edad: " + p.getPersona().getDni());
				 System.out.println("=========================================");

				 
				 // Añadimos la persona a la lista 
				 
				 listado_personas.add(p.getPersona());
				 
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		LeerPersonas();
	}
}
