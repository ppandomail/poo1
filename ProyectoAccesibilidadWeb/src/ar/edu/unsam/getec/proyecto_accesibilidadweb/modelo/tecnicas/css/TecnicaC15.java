package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.css;


import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;
import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;

public class TecnicaC15 extends TecnicaCSS {

	public TecnicaC15(CategoriaTecnica categoriaTecnica) {
		super(
				"C15",
				"Usar CSS para cambiar la presentaci�n de un componente de interfaz de usuario cuando recibe el foco.",
				"El objetivo de esta t�cnica es demostrar c�mo las apariencias visuales pueden mejorarse mediante hojas de estilo para proporcionar feedback visual cuando un elemento interactivo tenga el foco o cuando un usuario se desplaza sobre ella mediante un dispositivo se�alador. Resaltando los elemento que tiene el foco o son se�alados puede proporcionar informaci�n tal como el hecho de que el elemento es interactivo o el alcance del elemento interactivo.Proporcionar feedback visual puede ser posible a trav�s de m�s de un modo. Por lo general, se logra mediante el uso del mouse para colocar el cursor sobre el elemento o por teclado mediante el uso del Tab.", 
				categoriaTecnica);
	}

	/**
	 * Para cada elemento capaz de alcanzar el foco:
	 * 1. Usando el mouse, coloque el cursor sobre el elemento.
	 * 2. Verifique que el fondo o borde cambia de color.
	 * 3. Mover el rat�n fuera del objeto antes de intentar el foco con el teclado.
	 * 4. Usando el teclado, Tab al elemento.
	 * 5. Verifique que el fondo o borde cambia de color.
	 * 6. Verifique que los cambios del fondo o de la frontera en el color se eliminan cuando el elemento pierde el foco.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		for (Element elementoLINK : this.getParseador().getElementos(HTMLElementName.LINK)) {
			String atributoType = elementoLINK.getAttributeValue("type");
			if ((atributoType != null) && (atributoType.equals("text/css"))) {
				String atributoHref = elementoLINK.getAttributeValue("href");
				ResultadoEvaluacionTecnicaItem comprobacion = new ResultadoEvaluacionTecnicaItem(
						Tipologia.PRESENTACION, 
						"Validaci�n de las hojas de estilo: " + atributoHref, 
						TipoResultadoEvaluacion.MANUAL,
						"Verificar que el fondo o borde cambia de color cuando una componente gana o pierde el foco.",
						"Cambia la presentaci�n de los componentes de la interfaz usuario cuando recibe el foco mediante CSS.");
				resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacion);
			}
		}
		return resultadoEvaluacionTecnica;
	}

}