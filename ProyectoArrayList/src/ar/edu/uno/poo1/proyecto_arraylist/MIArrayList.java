package ar.edu.uno.poo1.proyecto_arraylist;

import java.util.ArrayList;

public class MIArrayList<E> extends ArrayList<E> {

	private static final long serialVersionUID = 1L;
	
	public MIArrayList() {
		super();
	}
	
	public MIArrayList(int cap) {
		super(cap);
	}
	
	public String toString() {
		String representacion = "[";
		for (Object p : this.toArray())
			representacion += p.toString() + "\n";
		return representacion + "]";
	}
	
}