package ar.edu.unsam.getec.proyecto_accesibilidadweb.controlador;

import java.util.List;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionPrincipio;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Contexto;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.ContextoClaves;

public class GestorContadorAccesibilidad {
	
	@SuppressWarnings("unchecked")
	public static Integer getCantidad(TipoResultadoEvaluacion tipoResultadoEvaluacion) {
		Integer cantidad = 0;
		List<ResultadoEvaluacionPrincipio> resultadoValidacionGeneral = (List<ResultadoEvaluacionPrincipio>) Contexto.get(ContextoClaves.RESULTADOS);
		for (ResultadoEvaluacionPrincipio resultadoEvaluacionPrincipio : resultadoValidacionGeneral)
			switch(tipoResultadoEvaluacion.getRepresentacionNumerica()) {
			case 1: cantidad += resultadoEvaluacionPrincipio.getCantidadOKPorPrincipio(); break;
			case 2: cantidad += resultadoEvaluacionPrincipio.getCantidadErrorPorPrincipio(); break;
			case 3: cantidad += resultadoEvaluacionPrincipio.getCantidadManualPorPrincipio(); break;
			case 4: cantidad += resultadoEvaluacionPrincipio.getCantidadImposiblePorPrincipio(); break;
			}
		return cantidad;
	}

}