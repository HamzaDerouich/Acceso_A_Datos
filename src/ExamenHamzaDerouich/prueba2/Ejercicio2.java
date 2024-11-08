package ExamenHamzaDerouich.prueba2;

import java.awt.Robot;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import ExamenHamzaDerouich.prueba1.Ropa;

public class Ejercicio2 {

	public static List<Precio> listado_de_precios = new ArrayList<Precio>();

	/**
	 * Método que trata la informacion ropa he instancia los objetos de precio
	 */

	public static void TratarFicheroRopa() {

		List<Ropa> listado_ropas = new ArrayList<Ropa>();
		File fichero = new File("ficheros/ropa.dat");
		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {
			while (true) {
				try {

					listado_ropas = (List<Ropa>) lector.readObject();

				} catch (EOFException e) {
					break;
				}

				for (Ropa ropa : listado_ropas) {
					// Instanciamos el objeto ropa

					Precio precio = new Precio(ropa.getId(), ropa.getPrecio(), ropa.getCoste(), ropa.getDescuento());

					// Lo añadimos a lista de precios

					listado_de_precios.add(precio);

					// Y mostramos el objeto

					System.out.println("=======LISTADO_PRECIOS_ROPA======");
					System.out.println("Id: " + ropa.getId());
					System.out.println("Precio: " + ropa.getPrecio());
					System.out.println("Coste: " + ropa.getCoste());
					System.out.println("Descuento: " + ropa.getDescuento());
					System.out.println("=======LISTADO_PRECIOS_ROPA======");

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Error: Clase no encontrada.");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @return
	 */

	public static String EscribirPrecioDeManeraAleatoria() {
		File fichero = new File("ficheros" + File.separator + "precio.dat");
		String ruta_fichero = "";
		 try(RandomAccessFile file = new RandomAccessFile(fichero,"rw"))
	        {
			 
			 for (Precio precio : listado_de_precios) 
			 {
				file.writeInt(precio.getId());
				file.writeDouble(precio.getPrecio());
				file.writeDouble(precio.getCoste());
				file.writeInt(precio.getDescuento());
				
				System.out.println("Precio registrado, en el fichero precio.dat!!");
			 }
			 
	        }catch (FileNotFoundException e)
	        {
	            throw new RuntimeException(e);
	        }
	        catch (IOException e) {
	            throw new RuntimeException(e);
	        }
		return ruta_fichero;
	}

	public static void main(String[] args) {

		System.out.println("********PRECIOS_ROPA********");
		TratarFicheroRopa();
		EscribirPrecioDeManeraAleatoria();
	}
}
