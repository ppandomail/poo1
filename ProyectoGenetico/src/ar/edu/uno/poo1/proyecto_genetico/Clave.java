package ar.edu.uno.poo1.proyecto_genetico;

public class Clave {
	
	private static Clave clave; 
	private CromosomaTP cromosomaTP;
	
	private Clave(String representacionHexadecimal) {
		this.setCromosomaTP(new CromosomaTP(representacionHexadecimal, 0));
	}
	
	public static Clave getClave() {
		return clave;
	}

	public static void setClave(String representacionHexadecimal) {
		Clave.clave = new Clave(representacionHexadecimal);;
	}

	public CromosomaTP getCromosomaTP() {
		return cromosomaTP;
	}

	public void setCromosomaTP(CromosomaTP cromosomaTP) {
		this.cromosomaTP = cromosomaTP;
	}

}