package ficheros;

import java.io.File;

public class RenombrarArchivo {
	
	public static void main( String [] args ) {
		
		File ficheroAntiguo = new File("ficheros//fichero.png");
		if( ficheroAntiguo.renameTo(new File("ficheros//ficheroPng.png"))) {
			System.out.println("Archivo renombrado....");
			System.out.println("Nombre fichero"+ficheroAntiguo.getName());
		}else {
			System.out.println("La oparacion no se pudo realizar");
		}
		
	}

}
