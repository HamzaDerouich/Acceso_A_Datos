package ficheros;

import java.io.File;
import java.io.FilenameFilter;

public class FilnameFilter implements FilenameFilter {

	String extenesion;
	
	public FilnameFilter( String extension ) {
		this.extenesion = extension;
	}
	
	@Override
	public boolean accept(File dir, String name) {
		return name.endsWith(extenesion);
	}
	

	public static void main( String [] args ) {
		
		// Obtenemos el listado de los archivos de ese directorio 
		
		File fichero = new File("ficheros");
		String[] listadoFicheros = fichero.list();
		
		// Listamos por los de extension .txt
		
		listadoFicheros = fichero.list( new FilnameFilter(".png") );
		for (String extension : listadoFicheros) {
			System.out.println(extension);
		}
		
	}

}
