package ficheros.ejercicios;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio21 {

	/*
	 * 21. Crea un programa que genere un fichero binario que almacene un número
	 * entero entre el 32 y el 126. Se pedirá al usuario la ruta del fichero y el
	 * número que desea almacenar. Si el fichero existe se sobrescribirá. Visualiza
	 * el fichero creado. Compara el resultado con la tabla ASCII.
	 * 
	 */
	
	public static void SobreEscribirFicheros()
	{
		Scanner sc = new Scanner(System.in);
		String ruta = "" ;
		int numero = 0 ;
		
		System.out.println("Digite el nombre del fichero: ");
		ruta = sc.nextLine();
		
		System.out.println("Digite el número: ");
		numero = Integer.parseInt(sc.nextLine());
		
		if( numero >= 32 && numero <= 126 )
		{
			File fichero = new File(ruta);
			if(fichero.exists())
			{
				try {
					
					DataOutputStream escritor = new DataOutputStream(new FileOutputStream(fichero,true));
					escritor.writeInt(numero);
					escritor.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			else
			{
				System.out.println("El fichero no existe!!");
			}
		}
		else
		{
			System.out.println("Datos no validos!!");
		}
	}

	public static void main(String[] args) 
	{
		SobreEscribirFicheros();
	}

}
