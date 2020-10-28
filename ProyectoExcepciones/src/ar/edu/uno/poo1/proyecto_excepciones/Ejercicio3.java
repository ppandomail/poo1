package ar.edu.uno.poo1.proyecto_excepciones;

public class Ejercicio3 {

	public static void main(String[] args) {
		try {
			String [] vector = new String[] {"aes", "bes", "ces", "des"};
			String str = vector[6];
			System.out.println(str);
		} catch(ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Paso por aquí");
		}
	}

}