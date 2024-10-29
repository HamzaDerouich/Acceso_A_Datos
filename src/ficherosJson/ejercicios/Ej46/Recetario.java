package ficherosJson.ejercicios.Ej46;

import java.util.List;

public class Recetario {
    
	private List<Receta> recetas;

    public Recetario() {}

    public Recetario(List<Receta> recetas) {
        this.recetas = recetas;
    }

    public List<Receta> getRecetas() {
        return recetas;
    }

    public void setRecetas(List<Receta> recetas) {
        this.recetas = recetas;
    }

	@Override
	public String toString() {
		return "Recetario [recetas=" + recetas + "]";
	}

    
	
    
}
