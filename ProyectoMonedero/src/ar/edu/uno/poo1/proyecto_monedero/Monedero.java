package ar.edu.uno.poo1.proyecto_monedero;

public class Monedero {

	private double saldo;

	public Monedero(double importeInicial) {
		this.setSaldo(importeInicial);
	}

	private double getSaldo() {
		return this.saldo;
	}

	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public void meterDinero(double importeAMeter) {
		this.setSaldo(this.getSaldo() + importeAMeter);
	}

	public boolean sacarDinero(double importeASacar) {
		if (this.getSaldo() < importeASacar)
			return false;
		this.setSaldo(this.getSaldo() - importeASacar);
		return true;
	}

	public double consultarSaldoFormatoNumerico() {
		return this.getSaldo();
	}

	public String consultarSaldoFormatoString() {
		return "$ " + String.valueOf(this.getSaldo());
	}

}