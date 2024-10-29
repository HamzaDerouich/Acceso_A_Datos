package ficherosJson.ejercicios.Ej46;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Ejercicio46 
{
	public static void LeerFicheroRecetas()
	{
		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            
        	Recetario recetario = objectMapper.readValue(new File("FicherosJSON/Recetas.json"), Recetario.class);
            
//        	System.out.println(recetario.toString());
        	
        	
        	for (Receta receta : recetario.getRecetas()) 
        	{
        		System.out.println("\n==================== Receta ====================");
        		System.out.println("Nombre receta: " + receta.getNombre());
        		System.out.println("Tipo: " + receta.getTipo());
        		System.out.println("Origen: " + receta.getOrigen().getPais() + ", " + receta.getOrigen().getRegion());
        		System.out.println("Ingredientes:");
        		for (Ingrediente ingrediente : receta.getIngredientes()) {
        		    System.out.println(" - " + ingrediente.getNombre() + ": " + ingrediente.getCantidad());
        		}
        		System.out.println("=================================================");

			}
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        
	}
	
	public static void main(String [] args)
	{
		LeerFicheroRecetas();
	}
}
