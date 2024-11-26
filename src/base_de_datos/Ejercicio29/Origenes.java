package base_de_datos.Ejercicio29;

import java.io.Serializable;
import java.util.ArrayList;

public class Origenes implements Serializable {
	private ArrayList<Origen> origenes;

	public Origenes() {

	}

	public ArrayList<Origen> getOrigenes() {
		return origenes;
	}

	public void setOrigenes(ArrayList<Origen> origenes) {
		this.origenes = origenes;
	}

}
