package base_de_datos.Ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {
        Menu();
    }

	private static void Menu() {
		Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("==== Menú de Gestión de Alumnos ====");
            System.out.println("1. Ver alumnos y asignaturas");
            System.out.println("2. Ver asignaturas y notas de un alumno");
            System.out.println("3. Insertar un nuevo alumno");
            System.out.println("4. Agregar columna 'telefono' a la tabla");
            System.out.println("5. Registrar teléfono de un alumno");
            System.out.println("6. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Conexion.SelectAlumno();
                    break;

                case 2:
                    System.out.print("Introduce el ID del alumno: ");
                    int id = scanner.nextInt();
                    Conexion.SelectAsignaturaNota(id);
                    break;

                case 3:
                    System.out.print("Introduce el nombre del alumno: ");
                    scanner.nextLine(); 
                    String nombre = scanner.nextLine();
                    System.out.print("Introduce el curso del alumno: ");
                    String curso = scanner.nextLine();
                    Alumno alumno = new Alumno(nombre, curso);
                    Conexion.InsertarAlumno(alumno);
                    break;

                case 4:
                    Conexion.InsertarColumnaTelefono();
                    break;

                case 5:
                    System.out.print("Introduce el ID del alumno: ");
                    int alumnoId = scanner.nextInt();
                    System.out.print("Introduce el teléfono del alumno: ");
                    scanner.nextLine();
                    String telefono = scanner.nextLine();
                    Conexion.InsertarTelefono(telefono, alumnoId);
                    break;

                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida, intenta nuevamente.");
                    break;
            }
        } while (opcion != 6);

        scanner.close();
	}
}
