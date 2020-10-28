package ar.edu.uno.poo1.proyecto_excepciones_banco;

public abstract class Cuenta {
	
	private double saldo;
	private long dni;
	
	public Cuenta(double saldo, long dni) {
		this.setSaldo(saldo);
		this.setDni(dni);
	}

	public double getSaldo() {
		return this.saldo;
	}

	private void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public long getDni() {
		return this.dni;
	}

	private void setDni(long dni) {
		this.dni = dni;
	}
	
	public void ingresarDinero(double dinero) {
		this.setSaldo(this.getSaldo() + dinero);
	}
	
	public void retirarDinero(double dinero) throws SaldoNegativo {
		this.setSaldo(this.getSaldo() - dinero);
	}
	
	public String toString() {
		return this.getDni() + " -->>  $ " + this.getSaldo();
	}

}