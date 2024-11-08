package ExamenHamzaDerouich.prueba5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Ejercicio5 {

	static List<PrecioJson> listado_precio = new ArrayList<PrecioJson>();

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

		// Creamos el objeto precio

		int id = Integer.parseInt(datos[0]);

		double precio = Double.parseDouble(datos[7]);

		PrecioJson precio_json = new PrecioJson(id, precio);

		// Lo añadimos a la listado de precios

		listado_precio.add(precio_json);

	}

	public static void GenerarFicheroJson() {

		File fichero = new File("FicherosJSON/precio.json");
		ObjectMapper escritor = new ObjectMapper();
		escritor.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			escritor.writeValue(fichero, listado_precio);
			System.out.println("Precios registrados!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("*****Informacion_Registrada_Fichero_JSON____");
		LeerFicheroNavavinted();
		GenerarFicheroJson();
	}

}
