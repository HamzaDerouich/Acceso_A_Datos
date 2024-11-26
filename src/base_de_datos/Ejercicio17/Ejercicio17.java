package base_de_datos.Ejercicio17;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import ExamenHamzaDerouich.prueba1.Ropa;

public class Ejercicio17 {
	
	static Conexion conexion = new Conexion();
	
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

		int id = Integer.parseInt(datos[0]);
		String nombre = datos[1];
		int idCategoria = Integer.parseInt(datos[2]);
		int idTalla = Integer.parseInt(datos[3]);
		int idColor = Integer.parseInt(datos[4]);
		int idMaterial = Integer.parseInt(datos[5]);
		int stock = Integer.parseInt(datos[6]);
		double precio = Double.parseDouble(datos[7]);
		double coste = Double.parseDouble(datos[8]);
		String estado = datos[9];
		double descuento = Integer.parseInt(datos[10]);

		// Creamos el objeto Producto
		
		Producto producto = new Producto(id, nombre, idCategoria, idTalla, idColor, idMaterial, stock, precio, coste, estado, descuento);
		
		// Insertamos el producto en la base de datos
		
		conexion.Insert(producto);
		

	}

	public static void main(String[] args) 
	{
		LeerFicheroNavavinted();
	}
}
