package ar.edu.uno.poo1.proyecto_compilador;

public class DemoCompilador {

	public static void main(String[] args) {
		Compilador compilador = new Compilador();
		System.out.println(compilador.compilar());
		
		compilador.setProgramaFuente("F");
		System.out.println(compilador.compilar());
		
		compilador.setProgramaFuente("C");
		System.out.println(compilador.compilar());
		
		compilador.setProgramaFuente("NN");
		System.out.println(compilador.compilar());
		
		
		compilador.setProgramaFuente("CPF");
		System.out.println(compilador.compilar());
		
		compilador.setProgramaFuente("CNNF");
		System.out.println(compilador.compilar());
		System.out.println(compilador.ejecutar());
		
		compilador.setProgramaFuente("CSSSNNEEF");
		System.out.println(compilador.compilar());
		System.out.println(compilador.ejecutar());
	}

}