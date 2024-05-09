package ar.edu.unju.fi.Ejercicio5.model;

public class Producto {
	private String nombre;
	private double PrecioUnitario;
	private boolean disponible;
	
	
	public Producto(String nombre, double precioUnitario, boolean disponible) {
		this.nombre = nombre;
		PrecioUnitario = precioUnitario;
		this.disponible = disponible;
	}


	public String getNombre() {
		return nombre;
	}
	
	public double getPrecioUnitario() {
		return PrecioUnitario;
	}

	public boolean isDisponible() {
		return disponible;
	}


	@Override
	public String toString() {
		return "Producto [nombre=" + nombre + ", PrecioUnitario=" + PrecioUnitario + "- disponible=" + (disponible ? "Disponible" : "No Disponible");
	}
	
	
	
}
