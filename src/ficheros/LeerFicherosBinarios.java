package ficheros;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class LeerFicherosBinarios {

	public static void LeerFichero()
	{
		File fichero = new File("ficheros/ej21.bin");
		try( DataInputStream lector = new DataInputStream(new FileInputStream(fichero)))
		{
			int a;
			while( (a = lector.read()) != -1 )
			{
				System.out.println("Byte leido: " + a);
			}
			System.out.println();	
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		LeerFichero();
	}

}
