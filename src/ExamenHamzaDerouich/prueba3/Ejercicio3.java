package ExamenHamzaDerouich.prueba3;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Ejercicio3 {

	static Scanner scanner = new Scanner(System.in);

	private static void MostrarPrecio() {

		int codigo = 0;
		int codigo_buscado = 0;
		double precio = 0;
		double coste = 0;
		int descuento = 0;

		System.out.println("Digite el id del producto: ");
		codigo_buscado = Integer.parseInt(scanner.nextLine());

		try (RandomAccessFile file = new RandomAccessFile("ficheros/precio.dat", "rw")) {
			while (file.getFilePointer() < file.length()) {
				//file.seek(file.getFilePointer());
				codigo = file.readInt();
				if (codigo == codigo_buscado) {
					precio = file.readDouble();
					coste = file.readDouble();
					descuento = file.readInt();

					double total = precio - (precio * descuento / 100) - coste;

					System.out.println("EL benefecio del artículo equivale a : " + total);

				}file.skipBytes(20);
				System.out.println(file.getFilePointer());
			}

		} catch (EOFException e) {
			System.out.println("Fin del fichero!!");
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) 
	{
		MostrarPrecio();
	}
}
