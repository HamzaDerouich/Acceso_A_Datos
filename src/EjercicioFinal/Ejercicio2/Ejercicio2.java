package EjercicioFinal.Ejercicio2;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import EjercicioFinal.Ejercicio1.Perro;


public class Ejercicio2 {

	public static List<Apetito> listado_apetido = new ArrayList<Apetito>();
	
	
	/**
	 *  Método que muestra la informacion del archivo Perros.dat
	 */
	
	public static void MostrarInformacionFichero() {

		File fichero = new File("ficheros/Perros.dat");
		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {
	        while (true) {
	            try {
	                Perro p = (Perro) lector.readObject();
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
	
	/**
	 * Método que trata el fichero Perros.dat 
	 * -> Leel ficheoro Perros.dat y apartir de eso instancia el objeto apetito 
	 */
	
	public static void TratarFicheroDat() {

		String nombre;
		int edad;
		double peso;
		
		File fichero = new File("ficheros/Perros.dat");
		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {
	        while (true) {
	            try {
	            	
	                Perro p = (Perro) lector.readObject();
	                
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
	
	/** Método que escribe los objetos apetido al fichero Apetito.dat
	 *  que devuele la ruta del fichero
	 * @return
	 */
	
	public static String PasarFicheroBinario()
	{
		File fichero = new File("ficheros" + File.separator + "Apetito.dat");
		String ruta_fichero = "";
		try ( ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(fichero)) ){
			
			for (Apetito a : listado_apetido) {
				
				escritor.writeObject(a);
			}

			
			ruta_fichero = fichero.getAbsolutePath();
			
			return ruta_fichero;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ruta_fichero;
	}
	
	

	public static void main(String[] args) 
	{
		
		System.out.println("********Datos_Fichero_Perros.dat********");
		MostrarInformacionFichero();
		System.out.println("********Datos_Apetito********");
		TratarFicheroDat();
		for (Apetito a : listado_apetido)
		{
			System.out.println(a);
		}
		String ruta_apetito = PasarFicheroBinario();
		System.out.println("Fichero apetito creado correctamente: " + ruta_apetito );
	}
}
