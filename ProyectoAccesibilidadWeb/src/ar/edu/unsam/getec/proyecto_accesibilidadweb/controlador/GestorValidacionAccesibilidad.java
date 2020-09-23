package ar.edu.unsam.getec.proyecto_accesibilidadweb.controlador;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionPrincipio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.guia.WCAG20;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.principios.Principio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Contexto;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.ContextoClaves;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class GestorValidacionAccesibilidad implements Runnable {

	private TipoValidacion tipoValidacion;
	private String texto;
	private String principios;

	public GestorValidacionAccesibilidad(TipoValidacion tipoValidacion, String texto, String principios) { 
		this.setTipoValidacion(tipoValidacion);
		this.setTexto(texto);
		this.setPrincipios(principios);
	}

	private void validarAccesibilidad() {
		Parseador parseador = null;
		switch(this.getTipoValidacion().getRepresentacionNumerica()) {
		case 1:	try {
			URL url = new URL(this.getTexto());
			parseador = new Parseador(url);
		} catch (MalformedURLException e) {	System.out.println(e);} 
		catch (Exception e) { System.out.println(e); } 
		break;
		case 2: try {
			parseador = new Parseador(new File(this.getTexto()));
		} catch (IOException e) {} 
		break;
		case 3: parseador = new Parseador(this.getTexto()); break;
		default: System.out.println("Error tipo de validacion!");
		}
		List<ResultadoEvaluacionPrincipio> resultadoValidacionGeneral = new LinkedList<ResultadoEvaluacionPrincipio>();
		for (Principio principio : new WCAG20().getPrincipios())
			if (this.getPrincipios().indexOf(principio.getNumero()) != -1)
				resultadoValidacionGeneral.add(principio.validarAccesibilidadPorPrincipio(parseador));
		Contexto.set(ContextoClaves.RESULTADOS, resultadoValidacionGeneral);
		Contexto.set(ContextoClaves.PARSEADOR, parseador);
	}

	public void run() {
		Contexto.set(ContextoClaves.RESULTADOS, null);
		this.validarAccesibilidad();
	}

	public TipoValidacion getTipoValidacion() {
		return this.tipoValidacion;
	}

	public void setTipoValidacion(TipoValidacion tipoValidacion) {
		this.tipoValidacion = tipoValidacion;
	}

	public String getTexto() {
		return this.texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getPrincipios() {
		return this.principios;
	}

	public void setPrincipios(String principios) {
		this.principios = principios;
	}

}
