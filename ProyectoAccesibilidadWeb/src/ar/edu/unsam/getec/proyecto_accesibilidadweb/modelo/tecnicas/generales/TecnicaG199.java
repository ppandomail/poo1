package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaG199 extends TecnicaGeneral {

	public TecnicaG199(CategoriaTecnica categoriaTecnica) {
		super(
				"G199", 
				"Proporcionar retroalimentaci�n de �xito cuando los datos se presentaron con �xito.", 
				"El objetivo de esta t�cnica es reducir el esfuerzo necesario para que los usuarios confirmar que una acci�n, tales como la presentaci�n de un formulario web, se complet� con �xito. Esto se puede lograr proporcionando retroalimentaci�n presentado consistentemente que indica expl�citamente �xito de una acci�n, en lugar de requerir a un usuario navegar a trav�s del contenido de descubrir si la acci�n se ha realizado correctamente. El esfuerzo significativo puede ser empleado por los usuarios que no se pueden escanear f�cilmente a trav�s de la informaci�n para confirmar su acci�n (por ejemplo, que los datos presentados se ha escrito correctamente en una base de datos, enviado a una persona, o a�adido al contenido que se est� editando).",
				categoriaTecnica);
	}

	/**
	 * 1. Rellenar los campos del formulario sin errores.
	 * 2. Enviar el formulario.
	 * 3. Verificar que un mensaje de retroalimentaci�n en la pantalla confirma que la petici�n se ha realizado correctamente.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionMensajeExitoTrasEnvioFormulario = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Mensaje de �xito tras una petici�n.", 
				TipoResultadoEvaluacion.MANUAL,
				"Verificar que un mensaje de retroalimentaci�n en la pantalla confirma que la petici�n se ha realizado correctamente.",
				"Tanto si el formulario ha sido enviado con �xito como si no, h�zselo saber al usuario.");
		for (Element elementoFORM : this.getParseador().getElementos(HTMLElementName.FORM))
			for (Element elementoINPUT : elementoFORM.getAllElements(HTMLElementName.INPUT)) {
				String atributoType = elementoINPUT.getAttributeValue("type");
				if ((atributoType != null) && (atributoType.equals("submit")))
					comprobacionMensajeExitoTrasEnvioFormulario.procesar(elementoINPUT);
			}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionMensajeExitoTrasEnvioFormulario);
		return resultadoEvaluacionTecnica;
	}

}