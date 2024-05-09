package ar.edu.unju.fi.Ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.Ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago{
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}
	
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = montoPagado;
	}

	@Override
	public void realizarPago(double monto) {
		montoPagado+= monto*0.15;
		
	}

	@Override
	public void imprimirRecibo() {
		 System.out.println("Pago con tarjeta:");
	     System.out.println("Número de tarjeta: " + numeroTarjeta);
	     System.out.println("Fecha de pago: " + LocalDate.now());
	     System.out.println("Monto pagado: " + montoPagado);
		
	}
}
