package EjercicioFinal2.ejercicio2;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class LeerFicheroXml
{
	
	public static void Ejercicio2()
	{
		
        try {
            // Crear un contexto JAXB para las clases 'Personas'
        	
            JAXBContext context = JAXBContext.newInstance(Personas.class);

            // Crear el deserializador (unmarshaller)
            
            Unmarshaller unmarshaller = context.createUnmarshaller();

            // Leer el archivo XML y mapearlo a objetos Java
            
            File file = new File("FicherosXML//personas.xml");
            Personas personas = (Personas) unmarshaller.unmarshal(file);

            // Mostrar los resultados
            List<Persona> personaList = personas.getListado_personas_xml();
            for (Persona persona : personaList) {
                System.out.println("DNI: " + persona.getDni());
                System.out.println("Teléfono: " + persona.getTelefono());
                System.out.println("Email: " + persona.getEmail());
                System.out.println("-------------");
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }

	
	}
	
	public static void main( String [] args )
	{
		Ejercicio2();
	}
}
