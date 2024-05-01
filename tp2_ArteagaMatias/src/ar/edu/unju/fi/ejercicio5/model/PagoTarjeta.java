package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago{
	
	private String numeroDeTarjeta;
	private LocalDate fechaDePago;
	private Double montoPagado;
	
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}

	public PagoTarjeta(String numeroDeTarjeta, LocalDate fechaDePago, Double montoPagado) {
		this.numeroDeTarjeta = numeroDeTarjeta;
		this.fechaDePago = fechaDePago;
		this.montoPagado = montoPagado;
	}

	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		this.montoPagado = monto + (monto * 0.15);
	}
	
	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		System.out.println("Número de tarjeta: " + numeroDeTarjeta + "\n" +
							"Fecha de pago: " + fechaDePago +"\n" +
							"Monto pagado: " + montoPagado);
	}

	public String getNumeroDeTarjeta() {
		return numeroDeTarjeta;
	}

	public void setNumeroDeTarjeta(String numeroDeTarjeta) {
		this.numeroDeTarjeta = numeroDeTarjeta;
	}

	public LocalDate getFechaDePago() {
		return fechaDePago;
	}

	public void setFechaDePago(LocalDate fechaDePago) {
		this.fechaDePago = fechaDePago;
	}

	public Double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(Double montoPagado) {
		this.montoPagado = montoPagado;
	}

}
