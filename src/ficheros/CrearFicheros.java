package ficheros;

import java.io.File;
import java.io.IOException;

public class CrearFicheros {
	
	// Metodo que crea un fichero 
	
	public static void CrearFichero() {
		
		File fichero = new File("ficheros//fichero.txt");
		if( !fichero.exists() ) {
			try {
				
				if(fichero.createNewFile())
				{
					System.out.println("El fichero fue creado correctamente!!");
					System.out.println("Con nombre: "+fichero.getName());
					System.out.println("Ruta del fichero: "+ fichero.getAbsolutePath());
				} 
				else
				{
					System.out.println("El fichero no ha podido ser creado!!");
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else
		{
			System.out.println("El fichero existe!!");
		}
		
	}
	
	public static void MostrarDatosFichero(File fichero_directorio) {
		
		File[] list = fichero_directorio.listFiles();
		for (File file : list) {
			System.out.println(
					" Nombre: " + file.getName()+
					"\n Ruta: "+ file.getAbsolutePath()
					+"\n Length : "+ file.length()
					);
		}
		
		
	}
	
	public static void main( String [] args ) {
		
		File ficheros = new File("ficheros");
		CrearFichero();
		System.out.println("-------------------------------");
		MostrarDatosFichero(ficheros);
	}

}
