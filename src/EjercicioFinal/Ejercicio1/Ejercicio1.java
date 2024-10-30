package EjercicioFinal.Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import ficheros.serializable.Empleado;
import ficheros.serializable.MiObjectOutputStream;

public class Ejercicio1 {

	static List<Perro> listado_perros = new ArrayList<>();
	
	
	/**
	 * Método que lee el fichero Perros.tx
	 */
	public static void LeerFicheroPerro()
	{
		File fichero = new File("ficheros/Perros.txt");
		try( BufferedReader bf = new BufferedReader(new FileReader(fichero)))
		{
			
			String linea = "" ;
			String[] datos;
			while( ( linea = bf.readLine() ) != null )
			{
				datos = linea.split(",");
				TratamientoLinea(datos); 
			}
			
			
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/** Metodo que trata la linea recibida por el fichero 
	 *  se lo pasa como argumento un array, el split se hace en el bucle 
	 *  
	 * @param datos
	 */
	
	private static void TratamientoLinea(String[] datos) 
	{
		
	 String nombre = datos[0];
	 String raza = datos[1];
	 Integer edad = Integer.parseInt(datos[2].trim()); 
	 double peso = Double.parseDouble(datos[3]);
	 boolean estado_salud ;
	 String descripcion = datos[5];
	 
	 if( datos[4].equals("Verdadero"))
	 {
		  estado_salud = true ;
	 }
	 else 
	 {
		estado_salud = false;
	 }
		
	 // Instanciamos el objeto perro 
	 
	 Perro perro = new Perro(nombre, raza, edad, peso, estado_salud, descripcion);
	 
	 // Lo añadimos a la lista de perros 
	 
	 listado_perros.add(perro);
	 
	 
	}

	public static String PasarFicheroBinario()
	{
		File fichero = new File("ficheros" + File.separator + "Perros.dat");
		String ruta_fichero = "";
		try ( ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(fichero)) ){
			
			for (Perro p : listado_perros) {
				
				escritor.writeObject(p);
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
		LeerFicheroPerro();
		System.out.print("*********Leer_Fichero_Perros*************");
		for (Perro p : listado_perros) 
		{
			System.out.print("\n"+p);
		}
		System.out.println("**************Registrar_Perros_Fichero_Dat***************");
		System.out.println("Archivo creado correctamente en la ruta:");
		String ruta = PasarFicheroBinario(); 
		System.out.println("Ruta: " + ruta );
	}

}
