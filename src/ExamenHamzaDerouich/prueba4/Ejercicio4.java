package ExamenHamzaDerouich.prueba4;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class Ejercicio4 {

	static List<RopaXml> listado_ropa = new ArrayList<RopaXml>();

	/**
	 * Método que lee el fichero ropa.csv
	 */
	public static void LeerFicheroNavavinted() {
		File fichero = new File("ficheros/navavinted.csv");
		try (BufferedReader bf = new BufferedReader(new FileReader(fichero))) {

			String linea = "";
			String[] datos;
			while ((linea = bf.readLine()) != null) {
				datos = linea.split(";");
				TratamientoLinea(datos);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que trata la linea recibida por el fichero se lo pasa como argumento
	 * un array, el split se hace en el bucle
	 * 
	 * @param datos
	 */

	private static void TratamientoLinea(String[] datos) {

		String nombre = datos[1];
		String talla = datos[3];
		String color = datos[4];
		String estado = datos[9];
		
		// Creamos el objeto ropa 
		

		RopaXml ropa_xml = new RopaXml(nombre, talla, color, estado);
		
		
		// Lo añadimos a la listado de ropas 
		
		listado_ropa.add(ropa_xml);
		
	}

	public static void GenerarFicheroXML() {
		try {

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			Element raiz = document.createElement("Ropa");
			document.appendChild(raiz);

			for (RopaXml ropa : listado_ropa) {

				Element ropaNode = document.createElement("Ropa");

				Element nombreNode = document.createElement("Nombre");
				Text nombreValue = document.createTextNode(ropa.getNombre());
				nombreNode.appendChild(nombreValue);
				ropaNode.appendChild(nombreNode);

				Element tallaNode = document.createElement("Talla");
				Text tallaValue = document.createTextNode(ropa.getTalla());
				tallaNode.appendChild(tallaValue);
				ropaNode.appendChild(tallaNode);

				Element colorNode = document.createElement("Color");
				Text colorValue = document.createTextNode(ropa.getColor());
				colorNode.appendChild(colorValue);
				ropaNode.appendChild(colorNode);

				Element estadoNode = document.createElement("Estado");
				Text estadoValue = document.createTextNode(ropa.getEstado());
				estadoNode.appendChild(estadoValue);
				ropaNode.appendChild(estadoNode);

				raiz.appendChild(ropaNode);
			}

			// Generar ficero XML

			Source source = new DOMSource(document);
			StreamResult result = new StreamResult(new File("ficheros//Ropa.xml"));
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.transform(source, result);

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("Fichero generado correctamente!!");
		LeerFicheroNavavinted();
		GenerarFicheroXML();

	}

}
