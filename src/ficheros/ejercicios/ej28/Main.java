package ficheros.ejercicios.ej28;

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
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

	static Scanner scanner = new Scanner(System.in);
	static boolean eliminado = false;
	static HashSet<Empleado> listado_empleados = new LinkedHashSet<Empleado>();

	// Método que muestra las opciones del menu

	public static void Menu() {
		CargarInformacion();
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

	private static void ConsultarEmpleadoPorDni() {
		System.out.print("Digite el Dni: ");
		String dni = scanner.nextLine();
		boolean existe = false;
			
		for (Empleado empleado : listado_empleados) 
		{
			if( empleado.getDni().equals(dni))
			{
				System.out.println(empleado);
				existe = true ;
			}
		
			if(!existe)
			{
				System.out.println("El usuario no existe");
			}
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
		if ((listado_empleados.contains(empleado) == true )) 
		{
			System.out.println("El empleado ya existe!");
		} else 
		{
			listado_empleados.add(empleado);
			System.out.println("Empleado registrado con nombre: " + empleado.getNombre());
			EscribirFichero();
		}
	}

	// Método que escribe el fichero

	private static void EscribirFichero() {
		File fichero = new File("ficheros\\empleados_dos.dat");
		try {

			ObjectOutputStream escritor;

			if (fichero.exists()) {
				escritor = new MiObjectOutputStream(new FileOutputStream(fichero));
			} else {
				escritor = new ObjectOutputStream(new FileOutputStream(fichero, true));
			}

			for (Empleado empleado2 : listado_empleados) {
				escritor.writeObject(empleado2);
			}

			escritor.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Método que elimina un usuario del fichero

	private static void EliminarUsuario() {
		boolean existe = false;
		String dni = "";
		Empleado emp = new Empleado();

		System.out.print("Digite el Dni: ");
		dni = scanner.nextLine();

		for (Empleado e : listado_empleados) {
			if (e.getDni().equals(dni)) {
				existe = true;
				emp = e;
			}
		}
		
		if (existe == true) {
			System.out.print("El empleado con: " + emp.getNombre() + " ha sido eliminado");
			listado_empleados.remove(emp);
			EscribirFichero();
		} else {
			System.out.println("El usuario no exisite!!");
		}
	}

	// Método que muestra la información del fichero

	private static void MostrarFichero()
	{
		for (Empleado empleado : listado_empleados)
		{
			System.out.println(empleado);
		}
	}
	
	public static void CargarInformacion()
	{
		File fichero = new File("ficheros/empleados_dos.dat");
		
		if( fichero.length() > 0 )
		{
			try {

				ObjectInputStream lector = new ObjectInputStream(
						new FileInputStream(new File("ficheros/empleados_dos.dat")));

				while (true) {
					try {
						Empleado empleado = (Empleado) lector.readObject();
						if( empleado != null )
						{
							listado_empleados.add(empleado);

						}
					} catch (EOFException | ClassNotFoundException e) {
						break;
					}
				}
				
				lector.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		Menu();
	}

}
