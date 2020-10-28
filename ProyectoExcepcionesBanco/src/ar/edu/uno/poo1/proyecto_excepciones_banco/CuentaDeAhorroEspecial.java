package ar.edu.uno.poo1.proyecto_excepciones_banco;

public class CuentaDeAhorroEspecial extends CuentaDeAhorro {
	
	private int penalizacion;
	
	public CuentaDeAhorroEspecial(double saldo, long dni, int penalizacion) {
		super(saldo, dni);
		this.setPenalizacion(penalizacion);
	}

	public int getPenalizacion() {
		return this.penalizacion;
	}

	public void setPenalizacion(int penalizacion) {
		this.penalizacion = penalizacion;
	}
	
	public void retirarDinero(double dinero) throws SaldoNegativo {
		double monto = this.getSaldo() * (100 - penalizacion / 100);
		if (this.getSaldo() < dinero) 
			throw new SaldoNegativo();
		super.retirarDinero(dinero + monto);
	}
	
}