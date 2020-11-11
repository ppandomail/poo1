package ar.edu.uno.poo1.proyecto_personas;

import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ColaPersonas {
	
	private ConcurrentLinkedQueue<Persona> personas;
	
	public ColaPersonas() {
		this.setPersonas(new ConcurrentLinkedQueue<Persona>());
	}

	public ConcurrentLinkedQueue<Persona> getPersonas() {
		return this.personas;
	}

	public void setPersonas(ConcurrentLinkedQueue<Persona> personas) {
		this.personas = personas;
	}
	
	public void agregarPersona(Persona persona) {
		this.getPersonas().offer(persona);
	}
	
	public HashMap<TipoCola, ConcurrentLinkedQueue<Persona>> getMapaEdad() {
		ConcurrentLinkedQueue<Persona> colaAux = new ConcurrentLinkedQueue<Persona>();
		HashMap<TipoCola, ConcurrentLinkedQueue<Persona>> mapa = new HashMap<TipoCola, ConcurrentLinkedQueue<Persona>>();
		ConcurrentLinkedQueue<Persona> cola20 = new ConcurrentLinkedQueue<Persona>();
		ConcurrentLinkedQueue<Persona> cola30 = new ConcurrentLinkedQueue<Persona>();
		ConcurrentLinkedQueue<Persona> cola40 = new ConcurrentLinkedQueue<Persona>();
		while(!this.getPersonas().isEmpty()) {
			Persona persona = this.getPersonas().poll();
			if (persona.getEdad() >= 20 && persona.getEdad() < 30)
				cola20.offer(persona);
			if (persona.getEdad() >= 30 && persona.getEdad() < 40)
				cola30.offer(persona);
			if (persona.getEdad() >= 40 && persona.getEdad() < 50)
				cola40.offer(persona);
			colaAux.offer(persona);
		}
		while(!colaAux.isEmpty()) {
			this.getPersonas().offer(colaAux.poll());
		}
		mapa.put(TipoCola.Cola20, cola20);
		mapa.put(TipoCola.Cola30, cola30);
		mapa.put(TipoCola.Cola40, cola40);
		return mapa;
	}
	
	public String toString() {
		String representacion = " | ";
		ConcurrentLinkedQueue<Persona> colaAux = new ConcurrentLinkedQueue<Persona>();
		while(!this.getPersonas().isEmpty()) {
			Persona persona = this.getPersonas().poll();
			representacion += persona + " | ";
			colaAux.offer(persona);
		}
		while(!colaAux.isEmpty()) {
			this.getPersonas().offer(colaAux.poll());
		}
		return representacion;
	}
	
}