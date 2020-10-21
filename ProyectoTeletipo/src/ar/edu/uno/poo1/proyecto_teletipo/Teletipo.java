package ar.edu.uno.poo1.proyecto_teletipo;

import java.util.Stack;

public class Teletipo {

	private String linea;
	private Stack<Character> pila;

	public Teletipo(String linea) {
		this.setLinea(linea);
		this.setPila(new Stack<Character>());
		for (int i = linea.length() - 2; i >= 0 ; i--)
			this.getPila().add(linea.charAt(i));
	}

	public String getLinea() {
		return this.linea;
	}

	private void setLinea(String linea) {
		this.linea = linea;
	}

	private Stack<Character> getPila() {
		return this.pila;
	}

	private void setPila(Stack<Character> pila) {
		this.pila = pila;
	}

	public String ejecutar() {
		Stack<Character> pilaResultado = new Stack<Character>();
		Stack<Character> pilaAuxiliar = new Stack<Character>();
		String cadenaResultado = "";
		while (!this.getPila().empty()) {
			Character character = this.getPila().pop();
			switch (character) {
			case '/': if (!pilaResultado.empty()) pilaResultado.pop(); break;
			case '&': while (!pilaResultado.empty()) pilaResultado.pop(); break;
			default: pilaResultado.push(character);
			}
			pilaAuxiliar.push(character);
		}
		while (!pilaAuxiliar.empty())
			this.getPila().push(pilaAuxiliar.pop());
		pilaResultado = Teletipo.invertirPila(pilaResultado);
		while (!pilaResultado.empty()) 
			cadenaResultado += pilaResultado.pop();	
		return cadenaResultado;
	}

	private static Stack<Character> invertirPila(Stack<Character> pila) {
		Stack<Character> pilaInvertida = new Stack<Character>();
		while (!pila.empty())
			pilaInvertida.push(pila.pop());
		return pilaInvertida;
	}

	public String toString() {
		return "Linea: " + this.getLinea() + " Pila: " + this.getPila();
	}

}