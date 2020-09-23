package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.principios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta2_1_AccesibleATravesDelTeclado;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta2_2_TiempoSuficiente;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta2_3_Ataques;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta2_4_Navegable;

public class Principio2_Operabilidad extends Principio {
	
	public Principio2_Operabilidad() {
		super(
				"2", 
				"Operabilidad.", 
				"Los componentes de la interfaz de usuario y la navegación deben ser operables.");
	}

	public List<Pauta> getPautasAAgregar() {
		List<Pauta> listaPautas = new LinkedList<Pauta>();
		listaPautas.add(new Pauta2_1_AccesibleATravesDelTeclado());
		listaPautas.add(new Pauta2_2_TiempoSuficiente()); 
		listaPautas.add(new Pauta2_3_Ataques()); 
		listaPautas.add(new Pauta2_4_Navegable());
		return listaPautas;
	}

}