package ar.edu.uno.poo1.proyecto_excepciones_banco;

public class CuentaCorriente extends Cuenta {
	
	private CuentaDeAhorro cuentaAhorro;
	
	public CuentaCorriente(double saldo, long dni, CuentaDeAhorro cuentaAhorro) {
		super(saldo, dni);
		this.setCuentaAhorro(cuentaAhorro);
	}
	
	public CuentaCorriente(double saldo, long dni) {
		this(saldo, dni, null);
	}

	public CuentaDeAhorro getCuentaAhorro() {
		return this.cuentaAhorro;
	}

	public void setCuentaAhorro(CuentaDeAhorro cuentaAhorro) {
		this.cuentaAhorro = cuentaAhorro;
	}

	public void retirarDinero(double dinero) throws SaldoNegativo {
		if (this.getSaldo() < dinero) {
			double monto = dinero - this.getSaldo();
			this.getCuentaAhorro().retirarDinero(monto);
			dinero = this.getSaldo();
		}
		super.retirarDinero(dinero);
	}
	
}