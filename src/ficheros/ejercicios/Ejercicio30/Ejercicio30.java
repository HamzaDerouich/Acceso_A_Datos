package ficheros.ejercicios.Ejercicio30;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

public class Ejercicio30 {

	static Scanner scanner = new Scanner(System.in);
	static boolean eliminado = false;
	static HashMap<Integer, Alumno> alumnos = new HashMap<Integer, Alumno>();

	// Método que muestra las opciones del menú
	public static void Menu() {
		char opcion = 0;
		System.out.print("************** Gestion_Ficheros **************");
		do {
			CargargarInformacionFichero();
			try {
				System.out.println("\n[1] Añadir alumno: " + "\n[2] Mostrar alumnos: " + "\n[3] Poner nota: "
						+ "\n[4] Mostrar Estadísticas:" + "\n[5] Borrar alumno: " + "\n[6] Salir: ");

				System.out.print("Digite la opción: ");
				opcion = scanner.nextLine().charAt(0);

				GestionOpciones(opcion);

			} catch (InputMismatchException e) {
				System.out.println("Datos no validos!!");
				scanner.nextLine();
			}

		} while (opcion < '6' && opcion >= '1');

		scanner.close();
	}

	private static void CargargarInformacionFichero() {
		File fichero = new File("ficheros/alumnos_dos.dat");
		if (!fichero.exists() || fichero.length() == 0) 
		{
			return;
		} else {
			try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {

				while (true) {
					try {
						Alumno alumno = (Alumno) lector.readObject();
						if (!(alumnos.containsKey(alumno))) {
							alumnos.put(alumno.getExpediente(), alumno);
						}

					} catch (EOFException | ClassNotFoundException e) {
						System.out.println("Fin del archivo!!");
						break;
					}
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// Método que gestiona las opciones del menú
	private static void GestionOpciones(char opcion) {
		switch (opcion) {
		case '1':
			AñadirAlumnos();
			break;
		case '2':
			MostrarAlumnos();
			break;
		case '3':
			PonerNotaAlumno();
			break;
		case '4':
			MostrarEstadisticas();
			break;
		case '5':
			BorrarAlumno();
			break;
		case '6':
			System.out.println("Saliendo...");
			break;
		default:
			System.out.println("Opción no válida.");
		}
	}

	// Método para poner una nota a un alumno

	private static void PonerNotaAlumno() {
		
		int expediente = 0;
		int nuevaNota = 0;
		
		System.out.print("Digite el número de expediente del alumno: ");
		expediente = Integer.parseInt(scanner.nextLine());
		
		System.out.print("Digite la nueva nota: ");
		nuevaNota = Integer.parseInt(scanner.nextLine());
		
		File fichero = new File("ficheros\\alumnos_dos.dat");
		
		
		if (alumnos.containsKey(expediente)) {

			 Alumno alumno = alumnos.get(expediente); 
			 alumno.setNota(nuevaNota); 
			 System.out.println("Nota actualizada exitosamente.");
			
			// Escribir el nuevo contenido en el fichero
			// Y lo sobreescribimos con los empleados que no queremos eliminar

			try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(fichero))) {
				for (Entry<Integer, Alumno> entry : alumnos.entrySet()) {
					Alumno al = entry.getValue();
					escritor.writeObject(al);
				}
				escritor.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("El alumno no existe!!");
		}


	}

	private static void MostrarEstadisticas() {
		int contadorAprobados = 0;
		int contadorSuspensos = 0;
		int sumaNotas = 0;

		File fichero = new File("ficheros\\alumnos_dos.dat");
		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {
			
			for (Entry<Integer, Alumno> entry : alumnos.entrySet()) 
			{
				
				Alumno alumno = entry.getValue();
				sumaNotas += alumno.getNota();
				
				if( alumno.getNota() >= 5 )
				{
					contadorAprobados++;
				}
				else
				{
					contadorSuspensos++;
				}
				
			}
			
			System.out.println("______ Estadísticas Alumnos _____");
			System.out.println("Número de aprobados: " + contadorAprobados);
			System.out.println("Número de suspensos: " + contadorSuspensos);
			System.out.println("Nota media de los alumnos: " + (sumaNotas / (double) alumnos.size()));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Método que instancia objeto empleado

	private static void AñadirAlumnos() {
		
		String nombre = "";
		int nota = 0, expediente = 0;

		System.out.print("Nombre: ");
		nombre = scanner.nextLine();
		System.out.print("Expediente: ");
		expediente = Integer.parseInt(scanner.nextLine());
		System.out.print("Nota: ");
		nota = Integer.parseInt(scanner.nextLine());

		Alumno alumno = new Alumno(expediente, nombre, nota);

		if (alumnos.containsKey(alumno.getExpediente())) {
			System.out.println("El alumno ya existe!!");
		} else {

			alumnos.put(alumno.getExpediente(), alumno);
		}

	}

	// Método que escribe el fichero

	private static void EscribirAlumnosAFichero() {
	    File fichero = new File("ficheros\\alumnos_dos.dat");
	    try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(fichero))) {
	        for (Entry<Integer, Alumno> entry : alumnos.entrySet()) {
	            escritor.writeObject(entry.getValue());
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	// Método que elimina un usuario del fichero

	private static void BorrarAlumno() {
		
		int expediente = 0;

		System.out.print("Digite el expediente: ");
		expediente = Integer.parseInt(scanner.nextLine());

		File fichero = new File("ficheros\\alumnos_dos.dat");

		if (alumnos.containsKey(expediente)) 
		{
			alumnos.remove(expediente);
			System.out.println("Alumno eliminado");
			EscribirAlumnosAFichero();

		} else {
			System.out.println("El alumno no existe!!");
		}

	}

	// Método que muestra la información del fichero

	private static void MostrarAlumnos() {
		for (Entry<Integer, Alumno> entry : alumnos.entrySet()) {
			Integer key = entry.getKey();
			Alumno val = entry.getValue();
			System.out.println("______Datos_Alumnos____");
			System.out.println("Expediente: " + key);
			System.out.println("\tNombre : " + val.getNombre());
			System.out.println("\tNota : " + val.getNota());
			System.out.println("------------------------------------");
		}
	}

	public static void main(String[] args) {
		Menu();
	}

}
