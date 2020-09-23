package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.pautas;

import java.util.LinkedList;
import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio1_2_1_SoloAudioYSoloVideoPregrabado;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio1_2_2_SubtitulosPregrabados;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.criterios.Criterio1_2_3_AudiodescripcionOAlternativaMultimediaPregrabada;

public class Pauta1_2_ContenidoMultimediaDependienteDelTiempo extends Pauta {

	public Pauta1_2_ContenidoMultimediaDependienteDelTiempo() {
		super(
				"1.2", 
				"Contenido multimedia dependiente del tiempo.", 
				"Proporcione alternativas sincronizadas para contenidos multimedia sincronizados dependientes del tiempo.");
	} 

	public List<Criterio> getCriteriosAAgregar() {
		List<Criterio> listaCriterios = new LinkedList<Criterio>();
		listaCriterios.add(new Criterio1_2_1_SoloAudioYSoloVideoPregrabado());
		listaCriterios.add(new Criterio1_2_2_SubtitulosPregrabados()); 
		listaCriterios.add(new Criterio1_2_3_AudiodescripcionOAlternativaMultimediaPregrabada());
		return listaCriterios;
	}

}