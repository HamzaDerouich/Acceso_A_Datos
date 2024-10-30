package EjercicioFinal.Ejercicio5;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import EjercicioFinal.Ejercicio2.Apetito;

public class Ejercicio5 {

	static List<Apetito> listado_apetido = new ArrayList<Apetito>();

	/**
	 * Método carga la lista de informacin del fichero
	 * 
	 */

	public static void CargarInformacionFichero() {

		String nombre;
		int edad;
		double peso;

		File fichero = new File("ficheros/Apetito.dat");
		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {
			while (true) {
				try {

					Apetito p = (Apetito) lector.readObject();

					nombre = p.getNombre();
					edad = p.getEdad();
					peso = p.getPeso();

					Apetito a = new Apetito(nombre, edad, peso);

					listado_apetido.add(a);

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

	public static void GenerarFicheroJson() {

		File fichero = new File("FicherosJSON/Perros.json");
		ObjectMapper escritor = new ObjectMapper();
		escritor.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			escritor.writeValue(fichero, listado_apetido);
			System.out.println("Perros registrados!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.out.println("*****Informacion_Registrada_Fichero_JSON____");
		System.out.println("*******Informacion_Fichero********");
		CargarInformacionFichero();
		GenerarFicheroJson();
	}
}
