package EjercicioFinal.Ejercicio4;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import EjercicioFinal.Ejercicio1.Perro;

public class Ejercicio4 
{

public static List<Perro> listado_perro = new ArrayList<Perro>();
	
	/** Método carga la lista de informacin del fichero 
	 * 
	 */
	
	public static void CargarInformacionFichero() {

		String nombre;
		int edad;
		double peso;
		
		File fichero = new File("ficheros/Perros.dat");
		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {
	        while (true) {
	            try {
	            	
	                Perro p = (Perro) lector.readObject();
	                
	                
	                listado_perro.add(p);
	                
	                System.out.println(p);
	                
	            } catch (EOFException e) {
	                break;
	            }
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } catch (ClassNotFoundException e) {
	        System.err.println("Error: Clase no encontrada.");
	        e.printStackTrace();
	    }
	}
	
	public static void GenerarFicheroXML() {
        try {
        	
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element raiz = document.createElement("Perros");
            document.appendChild(raiz);

            for (Perro perro : listado_perro) {
            	
                Element perroNode = document.createElement("Perro");
                
                Element nombreNode = document.createElement("Nombre");
                Text nombreValue = document.createTextNode(perro.getNombre());
                nombreNode.appendChild(nombreValue);
                perroNode.appendChild(nombreNode);

                Element edadNode = document.createElement("Edad");
                Text edadValue = document.createTextNode(String.valueOf(perro.getEdad()));
                edadNode.appendChild(edadValue);
                perroNode.appendChild(edadNode);

                Element pesoNode = document.createElement("Peso");
                Text pesoValue = document.createTextNode(String.valueOf(perro.getPeso()));
                pesoNode.appendChild(pesoValue);
                perroNode.appendChild(pesoNode);
                
                Element descripcionNode = document.createElement("Descripcion");
                Text descripcionValue = document.createTextNode(String.valueOf(perro.getDescripcion()));
                descripcionNode.appendChild(descripcionValue);
                perroNode.appendChild(descripcionNode);
                
                Element RazaNode = document.createElement("Raza");
                Text RazaValue = document.createTextNode(String.valueOf(perro.getRaza()));
                RazaNode.appendChild(RazaValue);
                perroNode.appendChild(RazaNode);
             
                raiz.appendChild(perroNode);
            }

            // Generar ficero XML
            
            Source source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("ficheros//Perros.xml"));
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	public static void main( String [] args )
	{
		System.out.println("*****Informacion_Registrada_Fichero_XML____");
		System.out.println("*******Informacion_Fichero********");
		CargarInformacionFichero();
		GenerarFicheroXML();
		
	}
	
}
