package ar.edu.uno.poo1.proyecto_excepciones_banco;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Banco {
	
	private List<Cuenta> cuentas;
	
	public Banco() {
		this.setCuentas(new LinkedList<Cuenta>());
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	//TODO
	public Map<String, Double> totalSaldoMaxPenalizacion() {
		Map<String, Double> mapa = new HashMap<String, Double>();
		
		
		mapa.put("Saldo Total de Cuentas Corrientes", 0.0);
		mapa.put("Maxima Penalizacion entre Cuentas de Ahorros Esp", 0.0);
		return mapa;
	}
	
	

}
