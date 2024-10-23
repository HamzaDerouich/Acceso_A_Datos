package ficheros.ejercicios.ej26;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class AgregarContenido 
{
	
	private static void AgregarEmpleados()
	{
		String ruta_fichero = "empleados_dos.dat" ;
		File fichero = new File(ruta_fichero);
		Empleado empleado = new Empleado("12345678F", "Hamza", 1500.00);
		
		try 
		{
			ObjectOutputStream escritor;
			
			if( fichero.exists() )
			{
				escritor = new MiObjectOutputStream(new FileOutputStream(fichero,true));
			}
			else
			{
				escritor = new ObjectOutputStream(new FileOutputStream(fichero , true));
			}
			
			escritor.writeObject(empleado);
			escritor.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void LeerContenido()
	{
		String ruta_fichero = "empleados_dos.dat" ;
		File fichero = new File(ruta_fichero);
		
		try {

			ObjectInputStream lector = new ObjectInputStream(new FileInputStream(fichero));
			while(true)
			{
				try {
					
					Empleado empleado = (Empleado) lector.readObject();
					
					System.out.println(":::::Datos_Empleado:::::");
					System.out.println(empleado);
					
				}catch(EOFException e )
				{
					System.out.println("Fin del fichero!!");
					break;
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args)
	{
		AgregarEmpleados();
		LeerContenido();
	}

}
