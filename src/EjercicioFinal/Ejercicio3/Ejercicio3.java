package EjercicioFinal.Ejercicio3;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import EjercicioFinal.Ejercicio1.Perro;
import EjercicioFinal.Ejercicio2.Apetito;

public class Ejercicio3 
{
	
	
	public static List<Apetito> listado_apetido = new ArrayList<Apetito>();
	
	/** Método carga la lista de informacin del fichero 
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
	
	
	
	public static void main( String [] args )
	{
		String nombre = "";
		boolean noExiste = false;
		Scanner sc = new Scanner(System.in);
		
		double total_comida =  0;
		
		CargarInformacionFichero();
		System.out.println("********Info_Dieta*********");
		System.out.println("Digite el nombre del perro: ");
		nombre = sc.nextLine();
		
		for (Apetito a : listado_apetido) 
		{
			if(a.getNombre().equals(nombre))
			{
				total_comida = a.getEdad() * a.getPeso();
				noExiste = true;
			}
		}
		
		
		if( noExiste == true )
		{
			System.out.println("La cantidad de alimento que necesita: " + total_comida); 
		}
		else
		{
			System.out.println("El perro no existe!!!");
		}
		
	}
}
