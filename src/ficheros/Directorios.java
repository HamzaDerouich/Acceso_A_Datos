package ficheros;

import java.io.File;

public class Directorios {

	public static void main( String [] args ) {
		
		// Comprobar si existe 
		
		File directorio = new File("C:\\Users\\Usuario\\eclipse-workspace\\Acceso_A_Datos\\directorios");
		System.out.println("Existe el directorio: "+ directorio.exists());
		
		// Crear Directorio 
		
		if( !directorio.exists() ) {
			if(directorio.mkdir()) {
				System.out.println("Directorio creado correctamente!!");
				System.out.println("En la ruta: "+directorio.getAbsolutePath());
			} else {
				System.out.println("No se ha podido crear el directorio!");
			}
		} else
		{
			System.out.println("El directorio ya existe!!");
		}
		
		//Creacion de subdirectorios
		
		File subidirectorios = new File("C:\\Users\\Usuario\\eclipse-workspace\\Acceso_A_Datos\\directorios\\ejercicio1\\ejercicio2");
		System.out.println("Existe el directorio: "+ directorio.exists());
		
		// Crear Directorio 
		
		if( !subidirectorios.exists() ) {
			if(subidirectorios.mkdirs()) {
				System.out.println("Directorios creados correctamente!!");
				System.out.println("En la ruta: "+directorio.getAbsolutePath());
			} else {
				System.out.println("No se han podido crear los directorios!");
			}
		} else
		{
			System.out.println("El directorio ya existe!!");
		}
	}
	
}
