package ar.edu.unju.fi.Ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.Ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	private LocalDate fechaPago;
	private double montoPagado;
	
	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PagoEfectivo(LocalDate fechaPago, double montoPagado) {
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}


	@Override
	public void realizarPago(double monto) {
		montoPagado -= monto * 0.10;
	}
	
	@Override
	public void imprimirRecibo() {
		System.out.println("Pago en Efectivo: ");
		System.out.println("Fecha de pago: "+fechaPago.now());
		System.out.println("Monto pagado: "+montoPagado);
	}
	
}
