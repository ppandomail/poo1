package ar.edu.uno.poo1.proyecto_genetico;

public class MainTP {

	public static void main(String[] args) {
		Clave.setClave("FA");
		
		CromosomaTP cromosoma1 = new CromosomaTP("A1");
		CromosomaTP cromosoma2 = new CromosomaTP("FA");
		System.out.println(cromosoma1);
		System.out.println(cromosoma2);
		cromosoma1.mutar();
		System.out.println(cromosoma1);
		cromosoma2.mutar();
		System.out.println(cromosoma2);
	}

}