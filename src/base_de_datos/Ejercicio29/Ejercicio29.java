package base_de_datos.Ejercicio29;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Ejercicio29 {
	
	static Conexion conexion = new Conexion();
	
	public static void LeerFicheroJSON() {
	    ObjectMapper mapper = new ObjectMapper();

	    String ruta_json = "FicherosJSON/ampliarOrigen.json";

	    try {
	    	
	        Origenes origenes = mapper.readValue(new File(ruta_json), Origenes.class);

	        for (Origen origen : origenes.getOrigenes())
	        {
	        	conexion.Insert(origen);
	        }

	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	

	public static void main(String[] args) 
	{
		LeerFicheroJSON();
	}
}
