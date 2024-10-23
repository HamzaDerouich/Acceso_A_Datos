package ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscribirFicheroDeTexto {

	public static void EscribirFichero()
	{
		String fichero = "ficheros/texto.txt";
		String contenido = "Chanquito feliz";
		try( BufferedWriter escritor = new BufferedWriter(new FileWriter(new File(fichero))))
		{
			escritor.write(contenido);
			escritor.newLine();
		}catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		EscribirFichero();
	}

}
