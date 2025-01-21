package Repaso_Examen;

import java.time.LocalDate;

public class Ticket
{	
	
	private LocalDate fecha_hora ;
	private Tipo tipo_combustible;
	private double importe;
	private double litros_suministrados;
	private double litros_restantes_deposito;
	
	public Ticket(LocalDate fecha_hora, Tipo tipo_combustible, double importe, double litros_suministrados,
			double litros_restantes_deposito) {
		super();
		this.fecha_hora = fecha_hora;
		this.tipo_combustible = tipo_combustible;
		this.importe = importe;
		this.litros_suministrados = litros_suministrados;
		this.litros_restantes_deposito = litros_restantes_deposito;
	}
	
	public Ticket()
	{
		
	}

	public LocalDate getFecha_hora() {
		return fecha_hora;
	}

	public void setFecha_hora(LocalDate fecha_hora) {
		this.fecha_hora = fecha_hora;
	}

	public Tipo getTipo_combustible() {
		return tipo_combustible;
	}

	public void setTipo_combustible(Tipo tipo_combustible) {
		this.tipo_combustible = tipo_combustible;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public double getLitros_suministrados() {
		return litros_suministrados;
	}

	public void setLitros_suministrados(double litros_suministrados) {
		this.litros_suministrados = litros_suministrados;
	}

	public double getLitros_restantes_deposito() {
		return litros_restantes_deposito;
	}

	public void setLitros_restantes_deposito(double litros_restantes_deposito) {
		this.litros_restantes_deposito = litros_restantes_deposito;
	}

	@Override
	public String toString() {
		return "Ticket [fecha_hora=" + fecha_hora + ", tipo_combustible=" + tipo_combustible + ", importe=" + importe
				+ ", litros_suministrados=" + litros_suministrados + ", litros_restantes_deposito="
				+ litros_restantes_deposito + "]";
	}
}
