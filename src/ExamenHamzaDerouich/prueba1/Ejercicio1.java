package ExamenHamzaDerouich.prueba1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import ficheros.serializable.MiObjectOutputStream;

public class Ejercicio1 {

	static List<Ropa> listado_ropa = new ArrayList<Ropa>();

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

		int id = Integer.parseInt(datos[0]);
		String nombre = datos[1];
		String talla = datos[3];
		String color = datos[4];
		int stock = Integer.parseInt(datos[6]);
		double precio = Double.parseDouble(datos[7]);
		double coste = Double.parseDouble(datos[8]);
		String estado = datos[9];
		int descuento = Integer.parseInt(datos[10]);
		
		// Creamos el objeto ropa 
		

		Ropa ropa = new Ropa(id, nombre, talla, color, stock, precio, coste, estado, descuento);
		
		// Lo añadimos a la listado de ropas 
		
		listado_ropa.add(ropa);
		
	}

	public static String PasarFicheroBinario() {
		File fichero = new File("ficheros" + File.separator + "ropa.dat");
		String ruta_fichero = "";
		try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(fichero))) {
			ruta_fichero = fichero.getAbsolutePath();
			escritor.writeObject(listado_ropa);			
			return ruta_fichero;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ruta_fichero;
	}

	public static void main(String[] args) {
		LeerFicheroNavavinted();
		System.out.print("*********DATOS_RECUPERADOS_DEL_FICHERO*************");
		for (Ropa r : listado_ropa) 
		{
			System.out.println("========Listado_De_Ropas=======");
			System.out.println("id: " + r.getId());
			System.out.println("Nombre: "  + r.getNombre());
			System.out.println("Talla: " + r.getTalla());
			System.out.println("Color: " + r.getColor());
			System.out.println("Stock: " + r.getStock());
			System.out.println("Precio: " + r.getPrecio());
			System.out.println("Coste: " + r.getCoste());
			System.out.println("Estado: " + r.getEstado());
			System.out.println("Descuento: " + r.getDescuento());
			System.out.println("=================================");

			
		}

		System.out.println("**************REGISTRO_ROPAS_DAT***************");
		System.out.println("Archivo creado correctamente en la ruta:");
		String ruta = PasarFicheroBinario();
		System.out.println("Ruta: " + ruta);
	}

}
