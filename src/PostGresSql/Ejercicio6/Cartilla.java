package PostGresSql.Ejercicio6;

import java.sql.Date;

public class Cartilla {

	private String nombreVacuna;
	private long numeroColegiado;
	private Date fechaAplicacion;

	public Cartilla(String nombreVacuna, long numeroColegiado, Date fechaAplicacion) {
		super();
		this.nombreVacuna = nombreVacuna;
		this.numeroColegiado = numeroColegiado;
		this.fechaAplicacion = fechaAplicacion;
	}

	public String getNombreVacuna() {
		return nombreVacuna;
	}

	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}

	public long getNumeroColegiado() {
		return numeroColegiado;
	}

	public void setNumeroColegiado(long numeroColegiado) {
		this.numeroColegiado = numeroColegiado;
	}

	public Date getFechaAplicacion() {
		return fechaAplicacion;
	}

	public void setFechaAplicacion(Date fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	@Override
	public String toString() {
		return "Cartilla [nombreVacuna=" + nombreVacuna + ", numeroColegiado=" + numeroColegiado + ", fechaAplicacion="
				+ fechaAplicacion + "]";
	}

}
