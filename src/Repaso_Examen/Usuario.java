package Repaso_Examen;

import java.util.List;

public class Usuario 
{
	private String usuario;
	private String contraseña;
	private int puntos_acumulados;
	private double total_de_litros_repostados;
	
	public Usuario(String usuario, String contraseña, int puntos_acumulados, double total_de_litros_repostados) {
		super();
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.puntos_acumulados = puntos_acumulados;
		this.total_de_litros_repostados = total_de_litros_repostados;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getPuntos_acumulados() {
		return puntos_acumulados;
	}

	public void setPuntos_acumulados(int puntos_acumulados) {
		this.puntos_acumulados = puntos_acumulados;
	}

	public double getTotal_de_litros_repostados() {
		return total_de_litros_repostados;
	}

	public void setTotal_de_litros_repostados(double total_de_litros_repostados) {
		this.total_de_litros_repostados = total_de_litros_repostados;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", contraseña=" + contraseña + ", puntos_acumulados=" + puntos_acumulados
				+ ", total_de_litros_repostados=" + total_de_litros_repostados + "]";
	}
	
}
