package ExamenHamzaDerouich.prueba5;

public class PrecioJson {
	private int id;
	private double precio;

	public PrecioJson(int id, double precio) {
		super();
		this.id = id;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "PrecioJson [id=" + id + ", precio=" + precio + "]";
	}

}
