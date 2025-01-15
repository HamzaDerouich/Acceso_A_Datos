package MapeoOR.Ejercicios.Ejercicio29;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		MenuOpciones();
	}

	private static void MenuOpciones() {
		int opcion = 0;
		try {

			do {

				System.out.println("___Gestion_Alumnos___");
				System.out.println("1.Mostrar nota alumno.: ");
				System.out.println("2.Modificar el nombre de un alumno: ");
				System.out.println("3.Borrar la dirección de un alumno: ");
				System.out.println("4.Borrar un alumno");
				System.out.println("5.Mostrar la nota media de un alumno");
				System.out.println("6.Salir");

				System.out.println("Digite el número de la opción: ");
				opcion = sc.nextInt();

				if (opcion >= 6) {
					pantallaError();
				}

				opcionesMenu(opcion);

			} while (opcion > 0 && opcion <= 5);

		} catch (Exception e) {
			System.out.println("Error: Vuelva a inciar el programa!!");
			e.printStackTrace();
		}

	}

	private static void opcionesMenu(int opcion) {
		switch (opcion) {
		case 1:
			
			break;
		case 2:

			break;
		case 3:

			break;
		case 4:

			break;
		case 5:

			break;
		case 6:

			break;
		default:
			pantallaError();
			break;
		}

	}

	public static int pantallaError() {

		int opcion = 0;

		System.out.println("Error: Datos no validos");
		System.out.println("1. Volver.");
		System.out.println("2. Salir");

		System.out.println("Digite el número de la opción: ");
		opcion = sc.nextInt();

		if (opcion == 1) {
			MenuOpciones();
		} else {
			System.out.println("Adios. Gracias..!");
		}

		return opcion;
	}

}
