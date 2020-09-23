package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.guia;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.base.Estructura;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.principios.Principio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.principios.Principio1_Perceptibilidad;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.principios.Principio2_Operabilidad;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.principios.Principio3_Comprensibilidad;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.principios.Principio4_Robustez;

public class WCAG20 extends Estructura {
	
	private List<Principio> principios;

	public WCAG20() {
		super("WCAG 2.0", "Pautas de Accesibilidad para el Contenido Web.", "Establecer criterios claros que permitan tanto el desarrollo de contenidos accesibles como la evaluación de la accesibilidad de contenidos ya existentes.");
		this.setPrincipios(new LinkedList<Principio>());
		this.agregarPrincipio(new Principio1_Perceptibilidad());
		this.agregarPrincipio(new Principio2_Operabilidad());
		this.agregarPrincipio(new Principio3_Comprensibilidad());
		this.agregarPrincipio(new Principio4_Robustez());
	}

	private void agregarPrincipio(Principio principio) {
		this.getPrincipios().add(principio);
	}

	public List<Principio> getPrincipios() {
		return this.principios;
	}

	public void setPrincipios(List<Principio> principios) {
		this.principios = principios;
	}	

	public String toStringBase() {
		return super.toString();
	}

	public String toString() {
		String principios = "";
		for (Principio principio : this.getPrincipios())
			principios += principio + "\n";
		return this.toStringBase() + principios;  
	}

}