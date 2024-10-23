package ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFicheroTexto {
	
	public static void LeerFicheroTexto()
	{
		String fichero = "ficheros/texto.txt";
		try( BufferedReader lector = new BufferedReader(new FileReader(new File(fichero))))
		{
			String linea;
			while( ( linea = lector.readLine() ) != null )
			{
				System.out.println(linea);
			}
		}catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args)
	{
		LeerFicheroTexto();
	}

}
