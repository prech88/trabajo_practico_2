package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago{
	
	private LocalDate fechaDePago;
	private Double montoPagado;
	
	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}

	public PagoEfectivo(LocalDate fechaDePago, Double montoPagado) {
		this.fechaDePago = fechaDePago;
		this.montoPagado = montoPagado;
	}

	@Override
	public void realizarPago(double monto) {
		// TODO Auto-generated method stub
		this.montoPagado = monto - (monto * 0.10);
	}

	@Override
	public void imprimirRecibo() {
		// TODO Auto-generated method stub
		System.out.println("Fecha de pago: " + fechaDePago +"\n" +
							"Monto pagado: " + montoPagado);
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
