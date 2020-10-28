package ar.edu.uno.poo1.proyecto_excepciones_banco;

public class DemoBanco {

	//TODO
	public static void main(String[] args) {
		Banco banco = new Banco();
		Cuenta cc = new CuentaCorriente(5000, 12345678);
		try {
			cc.retirarDinero(1200);
		} catch (SaldoNegativo e) {
			e.printStackTrace();
		}
		
		

	}

}