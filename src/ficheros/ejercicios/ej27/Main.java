package ficheros.ejercicios.ej27;

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

	// Método que muestra las opciones del menu 
	
	public static void Menu() {
		char opcion = 0;
		System.out.print("**************Gestion_Ficheros**************");
		do {
			System.out.println("\n[1]Dar de alta empleado: " + "\n[2]Eliminar empleado: " + "\n[3]Consultar empleados: "
					+ "\n[4]Consultar empleado por dni:" + "\n[5]Salir: ");

			System.out.print("Digite la opción: ");
			opcion = scanner.nextLine().charAt(0);

			GestionOpciones(opcion);

		} while (opcion < '5' && opcion >= '1');

	}

	// Método que gestiona las opciones del menu 
	
	private static void GestionOpciones(char opcion) {
		switch (opcion) {
		case '1':
			AltaUsuarios();
			break;
		case '2':
			EliminarUsuario();
			break;
		case '3':
			MostrarFichero();
			break;
		case '4':
			ConsultarEmpleadoPorDni();
			break;
		case '5':
			System.out.print("Saliendoooo....");
			break;
		}

	}
	
	// Método que muestra la informacion del empleado por dni

	private static void ConsultarEmpleadoPorDni()
	{
		System.out.print("Digite el Dni: ");
		String dni = scanner.nextLine();

		File fichero = new File("ficheros\\empleados.dat");
		try( ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero)))
		{
			
			Empleado empleado ;
			while(true)
			{
				try {
					
					empleado = (Empleado) lector.readObject();
					if( empleado.getDni().equals(dni) ) {
						System.out.println(empleado);
					}
					
				} catch (EOFException e) {
					break;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	// Método que instancia objeto empleado 
	
	private static void AltaUsuarios() {
		String dni = "", nombre = "";
		double sueldo = 0;

		System.out.print("DNI: ");
		dni = scanner.nextLine();
		System.out.print("Nombre: ");
		nombre = scanner.nextLine();
		System.out.print("Sueldo: ");
		sueldo = scanner.nextDouble();
		scanner.nextLine();

		Empleado empleado = new Empleado(dni, nombre, sueldo);
		EscribirFichero(empleado);

	}

	// Método que escribe el fichero
	
	private static void EscribirFichero(Empleado empleado) {
		File fichero = new File("ficheros\\empleados.dat");
		try {
			ObjectOutputStream escritor;

			if (fichero.exists()) {
				escritor = new MiObjectOutputStream(new FileOutputStream(fichero,true));
			} else {
				escritor = new ObjectOutputStream(new FileOutputStream(fichero,true));
			}
			escritor.writeObject(empleado);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método que elimina un usuario del fichero 
	
	private static void EliminarUsuario() {

		List<Empleado> listadoEmpleados = new ArrayList<>();
		String dni = "";

		System.out.print("Digite el Dni: ");
		dni = scanner.nextLine();

		File fichero = new File("ficheros\\empleados.dat");

		// Leer el fichero y cargar todos los empleados en la lista menos el que queremos eliminar

		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {
			Empleado empleado;
			while (true) {
				try {
					
					empleado = (Empleado) lector.readObject();
					if( !(empleado.getDni().equals(dni)))
					{
						listadoEmpleados.add(empleado);
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
			for (Empleado empleado : listadoEmpleados) 
			{
				escritor.writeObject(empleado);
			}
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Método que muestra la información del fichero 
	
	private static void MostrarFichero() {

		File fichero = new File("ficheros\\empleados.dat");

		try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero))) {
			Empleado empleado = null;
			while (true) {

				empleado = (Empleado) lector.readObject();
				System.out.println(empleado);
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
