package ficheros.ejercicios.Ej29;

import java.io.DataInputStream;
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
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static boolean eliminado = false;

	// Método que muestra las opciones del menú
	public static void Menu() {
		char opcion = 0;
		System.out.print("************** Gestion_Ficheros **************");
		do {
			System.out.println("\n[1] Añadir alumno: " + "\n[2] Mostrar alumnos: " + "\n[3] Poner nota: "
					+ "\n[4] Mostrar Estadísticas:" + "\n[5] Borrar alumno: " + "\n[6] Salir: ");

			System.out.print("Digite la opción: ");
			opcion = scanner.nextLine().charAt(0);

			GestionOpciones(opcion);

		} while (opcion < '6' && opcion >= '1');
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

	        List<Alumno> listadoAlumnos = new ArrayList<>();
	        File fichero = new File("ficheros\\alumnos.dat");

	        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {
	            Alumno alumno;
	            while (true) {
	                try {
	                    alumno = (Alumno) lector.readObject();
	                    if (alumno.getExpediente() == expediente) {
	                        System.out.print("Digite la nueva nota del alumno: ");
	                        nuevaNota = Integer.parseInt(scanner.nextLine());
	                        alumno.setNota(nuevaNota);
	                    }
	                    listadoAlumnos.add(alumno);
	                } catch (EOFException e) {
	                    break;
	                } catch (ClassNotFoundException e) {
	                    e.printStackTrace();
	                }
	            }
	        } catch (FileNotFoundException e) {
	            System.out.println("El fichero no existe.");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        // Reescribir el fichero 
	        
	        try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(fichero))) {
	            for (Alumno al : listadoAlumnos) {
	                escritor.writeObject(al);
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	}

	private static void MostrarEstadisticas() {
		int contadorAprobados = 0;
        int contadorSuspensos = 0;
        int sumaNotas = 0;
        List<Integer> listadoNotas = new ArrayList<>();

        File fichero = new File("ficheros\\alumnos.dat");
        try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {
            Alumno alumno;
            while (true) {
                try {
                    alumno = (Alumno) lector.readObject();
                    listadoNotas.add(alumno.getNota());
                    sumaNotas += alumno.getNota();
                    if (alumno.getNota() >= 5) {
                        contadorAprobados++;
                    } else {
                        contadorSuspensos++;
                    }
                } catch (EOFException e) {
                    break;
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("______ Estadísticas Alumnos _____");
            System.out.println("Número de aprobados: " + contadorAprobados);
            System.out.println("Número de suspensos: " + contadorSuspensos);
            System.out.println("Nota media de los alumnos: " + (sumaNotas / (double) listadoNotas.size()));

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
		EscribirFichero(alumno);

	}

	// Método que escribe el fichero

	private static void EscribirFichero(Alumno alumno) {
		File fichero = new File("ficheros\\alumnos.dat");
		try {
			ObjectOutputStream escritor;

			if (fichero.exists()) {
				escritor = new MiObjectOutputStream(new FileOutputStream(fichero, true));
			} else {
				escritor = new ObjectOutputStream(new FileOutputStream(fichero, true));
			}
			escritor.writeObject(alumno);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método que elimina un usuario del fichero

	private static void BorrarAlumno() {

		List<Alumno> listado_alumnos = new ArrayList<>();
		int expediente = 0;

		System.out.print("Digite el expediente: ");
		expediente = Integer.parseInt(scanner.nextLine());

		File fichero = new File("ficheros\\alumnos.dat");

		// Leer el fichero y cargar todos los empleados en la lista menos el que
		// queremos eliminar

		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {
			Alumno alumno;
			while (true) {
				try {

					alumno = (Alumno) lector.readObject();
					if (!(alumno.getExpediente() == expediente)) {
						listado_alumnos.add(alumno);
						break;
					}

				} catch (EOFException e) {
					break;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Escribir el nuevo contenido en el fichero
		// Y lo sobreescribimos con los empleados que no queremos eliminar

		try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(fichero))) {
			for (Alumno alumno : listado_alumnos) {
				escritor.writeObject(alumno);
			}
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Método que muestra la información del fichero

	private static void MostrarAlumnos() {

		File fichero = new File("ficheros\\alumnos.dat");

		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {
			Alumno alumno = null;
			while (true) {

				alumno = (Alumno) lector.readObject();
				System.out.println(alumno);
			}

		} catch (EOFException e) {

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Menu();
	}

}
