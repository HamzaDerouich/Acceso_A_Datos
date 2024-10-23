package ficheros.ejercicios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.Box.Filler;

public class Ejercicio25 
{
	public static void CambiarTextoMayusculas()
	{
		File fichero = new File("ficheros/texto4.dat");
		File fichero_temp = new File("ficheros/texto_temp.dat");
		try
		{
			DataInputStream lector = new DataInputStream(new FileInputStream(fichero));
			DataOutputStream escritor = new DataOutputStream(new FileOutputStream(fichero_temp));			
			int c = 0 ;
			while( c != -1 )
			{
				c = lector.read();
				char caracter = (char) c ;
				
				if(EsVocal(caracter) == true)
				{
					escritor.write(Character.toUpperCase(caracter));
				}
				else
				{
					escritor.write(caracter);
				}
			}
			
			escritor.close();
			lector.close();
			
			if(!fichero.delete())
			{
				System.out.println("El fichero no se ha borrado");
			}
			
			if(!fichero_temp.renameTo(fichero))
			{
				System.out.println("El fichero no se ha podido renombrar");
			}
			
		}catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static boolean EsVocal(char caracter)
	{
		char[] vocales = {'a','e','i','o','u'};
		for (int i = 0; i < vocales.length; i++) 
		{
			if( vocales[i] == caracter )
			{
				return true;
			}
		}
		return false;
	}

	public static void main(String [] args)
	{
		CambiarTextoMayusculas();
	}
}
