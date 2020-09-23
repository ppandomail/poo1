package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaG162 extends TecnicaGeneral {

	public TecnicaG162(CategoriaTecnica categoriaTecnica) {
		super(
				"G162", 
				"Posicionar las etiquetas para optimizar las previsibilidad de las relaciones.", 
				"Cuando las etiquetas de los campos de formulario se colocan donde el usuario espera de ellos que visualmente, es m�s f�cil de entender y de formas complejas para localizar campos espec�ficos . Etiquetas para la mayor�a de los campos est�n situados inmediatamente antes del campo , es decir, para los idiomas de izquierda a derecha , ya sea a la izquierda del campo o por encima de ella , as� como los idiomas de derecha a izquierda , a la derecha del campo o por encima eso. Las etiquetas de los botones de opci�n y casillas de verificaci�n est�n colocados despu�s del campo. Estas posiciones se definen porque esa es la posici�n habitual ( y por lo tanto m�s predecible ) para el sello de campos, botones de radio y casillas de verificaci�n. Las etiquetas se colocan antes de los campos de entrada desde los campos a veces var�an en longitud . Posicion�ndolos antes permite que las etiquetas se alineen . Tambi�n hace m�s f�cil de localizar etiquetas con una lupa de la pantalla , ya que son inmediatamente antes del campo y tambi�n se pueden encontrar en una columna vertical ( cuando el inicio de los campos alineados de forma vertical ) . Por �ltimo , si el campo tiene datos en �l , es m�s f�cil de entender o verificar los datos si uno lee la etiqueta y luego el contenido en lugar de al rev�s. Casillas de verificaci�n y botones de radio tienen una anchura uniforme, mientras que sus etiquetas a menudo no lo hacen. Tener el bot�n de opci�n o casilla de verificaci�n primera , por tanto, permite que tanto los botones y las etiquetas que se alinean verticalmente.",
				categoriaTecnica);
	}

	/**
	 * Para cada campo de formulario en la p�gina web:
	 * 1. Verificar que el campo de formulario tiene una etiqueta visible.
	 * 2. Si el campo de formulario es un bot�n de casilla o radio, verificar que la etiqueta es inmediatamente despu�s del campo.
	 * 3. Si el campo de formulario no es un bot�n de casilla o radio, verificar que la etiqueta est� inmediatamente antes del campo.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionCampoFormularioEtiquetaVisible = new ResultadoEvaluacionTecnicaItem(
				Tipologia.FORMULARIOS, 
				"Campo de formulario tiene etiqueta visible.",
				"Para cada campo de formulario en la p�gina web: Verificar que el campo de formulario tiene una etiqueta visible.",
				"Ofrece etiquetas \"label\" descriptivas para asociar etiquetas de texto con controles de formulario y ub�calas para maximizar la predictibilidad de la relaci�n.");
		for (Element elementoFORM: this.getParseador().getElementos(HTMLElementName.FORM))
			for (Element elementoINPUT : elementoFORM.getAllElements(HTMLElementName.INPUT)) {
				String atributoType = elementoINPUT.getAttributeValue("type");
				if ((atributoType != null) && (atributoType.equals("hidden")))
					comprobacionCampoFormularioEtiquetaVisible.procesar(elementoINPUT);
			}
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionCampoFormularioEtiquetaVisible);
		return resultadoEvaluacionTecnica;
	}

}