package ficheros.ejercicios;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio22 {
	/*
	 * Realiza un programa que muestre el número del fichero generado en el
	 * ejercicio anterior.
	 * 
	 */

	public static void LeerFicheroBinario() {		
		Scanner sc = new Scanner(System.in);
		String ruta = "";
		System.out.println("Introduce la ruta del fichero que contiene un número: ");
		ruta = sc.nextLine();
		File file = new File(ruta);

		if (file.exists()) {
			try {

				DataInputStream lector = new DataInputStream(new FileInputStream(file));
				int c;
				while (( c = lector.read() ) != -1) {
					try {
						c = lector.read();
						System.out.println(c);

					} catch (EOFException e) {
						System.out.println("Fin del fichero");
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("El fichero no existe!!");
		}
	}

	public static void main(String[] args) {
		LeerFicheroBinario();
	}

}
