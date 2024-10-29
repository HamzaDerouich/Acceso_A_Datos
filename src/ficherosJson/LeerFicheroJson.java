package ficherosJson;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;

public class LeerFicheroJson {

	public static void LeerFicheroJSON() {
		
		ObjectMapper mapper = new ObjectMapper();

		// LEER una cadena json

		String ruta_json = "FicherosJSON/Alumnos.json";

		ArrayList<Alumno> lista_alumnos = new ArrayList<>();
		
		Alumno alumno = new Alumno();

		try {
			
			ArrayList<Alumno> productos = mapper.readValue(new File("FicherosJSON/Alumnos.json"),
                    mapper.getTypeFactory().constructCollectionType(ArrayList.class, Alumno.class));

			
		 for (Alumno alumno2 : productos) 
		 {
				System.out.println("______Datos_Alumno__");
				System.out.println("Nombre: " + alumno2.getNombre());
				System.out.println("Edad: " + alumno2.getEdad());
				System.out.println("Dni: " + alumno2.getDni());
		 }
			
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	public static void main(String[] args) 
	{
		LeerFicheroJSON();
	}

}
