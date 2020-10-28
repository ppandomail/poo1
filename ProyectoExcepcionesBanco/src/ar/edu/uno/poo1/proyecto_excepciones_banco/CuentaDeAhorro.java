package ar.edu.uno.poo1.proyecto_excepciones_banco;

public class CuentaDeAhorro extends Cuenta {
	
	public CuentaDeAhorro(double saldo, long dni) {
		super(saldo, dni);
	}
	
	public void retirarDinero(double dinero) throws SaldoNegativo {
		if (this.getSaldo() < dinero) 
			throw new SaldoNegativo();
		super.retirarDinero(dinero);
	}

}