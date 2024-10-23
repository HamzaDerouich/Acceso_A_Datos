package ficheros.ejercicios.ej20;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.ls.LSInput;

public class Main {

	/*
	 * Realiza un programa que, utilizando ficheros, permita gestionar una lista de
	 * teléfonos sin duplicados.
	 * 
	 *  En esta lista se almacenará el número de teléfono y
	 * el nombre de la persona. Se deberá crear la clase Teléfonos y un programa que
	 * permita utilizarla. 
	 * 
	 * El fichero se almacenará en la carpeta del proyecto con
	 * el nombre Telefonos.dat. -> Fichero binario
	 * 
	 * El programa permitirá: 
	 * Añadir un teléfono, no puede haber repeticiones  -> 
	 * Mostrar la lista de teléfonos  
	 * Modificar un teléfono por número de teléfono, solamente se modifica el nombre  
	 * Borrar un teléfono por número de teléfono
	 */

	 public static HashSet<Telefono> listado_telefonos = new LinkedHashSet<Telefono>();
	 public static Scanner sc = new Scanner(System.in);
	
	
	public static void Menu()
	{
	
		int opcion = 0 ;
		System.out.print("_____Gestión_Teléfonos____");
		while( opcion < 5 && opcion >= 0 )
		{
			try
			{
				System.out.println(
						"\n[1].Añadir Teléfono" + 
						"\n[2].Mostrar listado teléfonos" + 
						"\n[3].Modificar teléfono" + 
						"\n[4].Borrar un teléfono" +
						"\n[5].Salir"
						);
				
				System.out.print("Digite la opción: ");
				opcion = Integer.parseInt(sc.nextLine());
				
				if(  opcion < 0 && opcion > 5  )
				{
					System.out.println("Datos no validos!!");
				}
				else 
				{
					OpcionesMenu(opcion);
				}
				
			}catch( InputMismatchException e )
			{
				System.out.println("Datos no validos!!");
			}
		
		}
	}
	
	
	private static void OpcionesMenu(int opcion) 
	{
		switch (opcion) {
		case 1:
			AñadirTelefono();
			break;
		case 2:
			MostrarListadoTelefonos();
			break;
		case 3:
			ModificarTelefono();
			break;
		case 4:
			BorrarTelefono();
			break;
		case 5:
			System.out.print("Saliendo....");
		default:
			break;
		}
		
	}

	private static void BorrarTelefono()
	{
		String numero_buscado = "";
		boolean existe = false ;
		Telefono telefono = new Telefono();
		
		System.out.print("Ingrese el número del telefono : ");
		numero_buscado = sc.nextLine();
		
		for (Telefono tl : listado_telefonos) 
		{
			if(tl.getTelefono().equals(numero_buscado))
			{
				telefono = tl ;
				existe = true;
			}
		}
		
		if(!(existe == false))
		{
			listado_telefonos.remove(telefono);
			System.out.println("Telefono borrado, con nombre: " + telefono.getNombre());

		}
		else
		{
			System.out.println("No se encuentra el número de teléfono");
		}
	}

	private static void ModificarTelefono() 
	{
		String numero_buscado = "" , nombre_modificado = "";
		boolean existe = false ;
		Telefono telefono = new Telefono();
		
		System.out.print("Ingrese el número de telefono buscado: ");
		numero_buscado = sc.nextLine();
		
		System.out.print("Digite el nuevo nombre: ");
		nombre_modificado = sc.nextLine();
		
		for (Telefono tl : listado_telefonos) 
		{
			if(tl.getTelefono().equals(numero_buscado))
			{
				telefono = tl ;
				existe = true;
			}
		}
		
		if(!(existe == false))
		{
			System.out.println("Nombre modificado correctamente");
			telefono.setNombre(nombre_modificado);
		}
		else
		{
			System.out.println("No se encuentra el número de teléfono");
		}
		
		
	}


	private static void MostrarListadoTelefonos()
	{
		for (Telefono telefono : listado_telefonos) {
			System.out.println(telefono);
		}
	}


	private static void AñadirTelefono()
	{
		String nombre,  telefono ;
		System.out.println("Digite el nombre: ");
		nombre = sc.nextLine();
		System.out.println("Digite el teléfono: ");
		telefono = sc.nextLine();
		Telefono telefono_objeto = new Telefono(nombre, telefono);
		
		if( listado_telefonos.contains(telefono_objeto) )
		{
			System.out.println("No se ha podido añadir, ya que existe!");
		}
		else
		{
			System.out.println("Teléfono añadido correctamente!!");
			listado_telefonos.add(telefono_objeto);
			
		}
		
	}


	public static void main(String[] args) 
	{
		Menu();
	}

}
