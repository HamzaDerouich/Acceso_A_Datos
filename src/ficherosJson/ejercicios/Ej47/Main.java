package ficherosJson.ejercicios.Ej47;

import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);

	public static void Menu()
	{
		int opcion = 0 ;
		do 
		{
			System.out.println(
					"\n[1].Añadir Receta: "+
					 "\n[1].Eliminar Receta: "+
					 "\n[1].MostrarRecetas: "
			
					);
			
		}while( opcion < 4 && opcion >= 1);
	}

	public static void main(String[] args) {

	}

}
