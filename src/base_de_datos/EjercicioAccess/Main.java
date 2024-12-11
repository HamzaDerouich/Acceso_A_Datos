package base_de_datos.EjercicioAccess;

import java.util.Scanner;

public class Main {
	
	static Conexion conexion = new Conexion();

	public static void Menu() {
		
		Scanner scanner = new Scanner(System.in);
		int opcion = 0;
		do {
			System.out.println("\n--- Gestión Biblioteca ---");
			System.out.println("1. Mostrar todos los libros de 'Fantasía'");
			System.out.println("2. Añadir un nuevo tema 'comic'");
			System.out.println("3. Añadir un nuevo autor 'Antonio Luis Sánchez Adalid'");
			System.out.println("4. Añadir un nuevo campo 'operativa' a la tabla editorial");
			System.out.println("5. Cambiar la editorial de un libro");
			System.out.println("6. Cambiar el valor operativa a false para la editorial Meridian");
			System.out.println("7. Salir");
			System.out.print("Seleccione una opción: ");
			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				conexion.mostrarLibrosFantasia();
				break;
			case 2:
				conexion.añadirTemaComic();
				break;
			case 3:
				conexion.añadirAutor();
				break;
			case 4:
				conexion.añadirCampoEditorial();
				break;
			case 5:
				System.out.print("Introduzca el ID del libro: ");
				int libroId = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Introduzca la nueva editorial: ");
				String nuevaEditorial = scanner.nextLine();
				conexion.cambiarEditorial(libroId, nuevaEditorial);
				break;
			case 6:
				conexion.cambiarOperativaFalse();
				break;
			case 7:
				System.out.println("Saliendo...");
				break;
			default:
				System.out.println("Opción no válida.");
			}
		} while (opcion != 7);
		scanner.close();
	}

	public static void main(String[] args) {
		Menu();
	}

}
