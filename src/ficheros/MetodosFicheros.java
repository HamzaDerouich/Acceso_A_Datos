package ficheros;

import java.io.File;

public class MetodosFicheros {

	public static void main( String [] args ) {
		
		File fichero = new File("ficheros//fichero.txt");	
		System.out.println(
				"1.¿Existe el fichero?: " + fichero.exists() +
				"\n2.2.¿Se puede leer?: " + fichero.canRead()+
				"\n2.3.¿Se puede escribir?: " + fichero.canWrite()+
				"\n2.4.¿Se puede ejecutar?: " + fichero.canExecute()+
				"\n2.4.¿Es un fichero?: " + fichero.isFile() +
				"\n2.4.¿Última vez modificado?: " + fichero.lastModified()
				);
		
		//Metodos para listar ficheos de un directorio
		
		System.out.println("\n*************Listado_Ficheros******************");
		File directorio = new File("ficheros");
		String[] listaFichero = directorio.list();
		for (String string : listaFichero) {
			System.out.println(string);
		}
		
		// Metodo que lista los ficheros y nos muestra sus datos
		// Tambien podemos filtar los archivos con la clase FilnameFilter
		
		File[] listadoFicherosDos = directorio.listFiles( new FilnameFilter(".png") );
		for (File file : listadoFicherosDos) {
			System.out.println("*****************");
			System.out.println("1.Nombre: "+ file.getName());
			System.out.println("2.Ruta: "+file.getAbsolutePath());
		}
	}
}
