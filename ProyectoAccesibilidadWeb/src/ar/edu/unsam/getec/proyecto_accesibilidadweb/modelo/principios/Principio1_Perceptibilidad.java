package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.principios;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta1_1_AlternativasTextuales;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta1_2_ContenidoMultimediaDependienteDelTiempo;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta1_3_Adaptabilidad;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas.Pauta1_4_Distinguible;

public class Principio1_Perceptibilidad extends Principio {

	public Principio1_Perceptibilidad() {
		super(
				"1", 
				"Perceptibilidad.", 
				"La información y los componentes de la interfaz de usuario deben presentarse a los usuarios de la manera en que puedan percibirlos.");
	}

	public List<Pauta> getPautasAAgregar() {
		List<Pauta> listaPautas = new LinkedList<Pauta>();
		listaPautas.add(new Pauta1_1_AlternativasTextuales());
		listaPautas.add(new Pauta1_2_ContenidoMultimediaDependienteDelTiempo());
		listaPautas.add(new Pauta1_3_Adaptabilidad()); 
		listaPautas.add(new Pauta1_4_Distinguible());
		return listaPautas;
	}

}