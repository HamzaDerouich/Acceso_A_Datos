package ExamenHamzaDerouich.prueba2;

public class Precio {
	private int id;
	private double precio;
	private double coste;
	private int descuento;

	public Precio(int id, double precio, double coste, int descuento) {
		super();
		this.id = id;
		this.precio = precio;
		this.coste = coste;
		this.descuento = descuento;
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

	public double getCoste() {
		return coste;
	}

	public void setCoste(double coste) {
		this.coste = coste;
	}

	public int getDescuento() {
		return descuento;
	}

	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}

	@Override
	public String toString() {
		return "Precio [id=" + id + ", precio=" + precio + ", coste=" + coste + ", descuento=" + descuento + "]";
	}

}
