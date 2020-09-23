package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.generales;

import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.ResultadoEvaluacionTecnicaItem;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.TipoResultadoEvaluacion;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion.Tipologia;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.tecnicas.CategoriaTecnica;
import ar.edu.unsam.getec.proyecto_accesibilidadweb.util.Parseador;

public class TecnicaG202 extends TecnicaGeneral {

	public TecnicaG202(CategoriaTecnica categoriaTecnica) {
		super(
				"G202", 
				"Asegurar el control de teclado para todas las funciones.", 
				"El objetivo de esta t�cnica es proveer operaciones de teclado para todas las funcionalidades de la p�gina. Cuando toda la funcionalidad de contenido puede ser operado a trav�s de una interfaz de teclado o un teclado,  puede ser operado por los que no tienen visi�n, as� como por los que deben utilizar teclados alternativos o dispositivos de entrada que act�an como emuladores de teclado como el software de entrada de voz o teclado en pantalla. Una interfaz de teclado permite proveer a los usuarios ingreso de pulsaciones de teclas a los programas, incluso si el dispositivo inform�tico que est� utilizando no contiene un teclado de hardware. Por ejemplo, muchos dispositivos m�viles tienen interfaces de teclado dentro de su sistema operativo, a su vez la opci�n de conectar teclados inal�mbricos externos. Las aplicaciones pueden utilizar la interfaz para obtener la entrada del teclado, ya sea desde un teclado externo o desde otros servicios que proporcionan salida de teclado simulado, tales como dispositivos de conmutaci�n, int�rpretes de escritura a mano o aplicaciones de voz a texto. Para poner en pr�ctica esta t�cnica, determinar en primer lugar que funcionalidad est� disponible para los usuarios en la p�gina. En este paso, es importante tener en cuenta funciones realizadas usando el rat�n y el teclado juntos. Ejemplos de funcionalidad incluyen el uso de controles f�sicos, tales como enlaces, men�s, botones, casillas de verificaci�n, botones de radio y campos de formulario, as� como el uso de caracter�sticas como arrastrar y soltar, selecci�n de texto, cambiar el tama�o de las regiones o traer los men�s de contexto. Otros ejemplos de funcionalidad pueden estar basados en tareas tales como la adici�n o eliminaci�n de un elemento de un carrito de compras o el inicio de una sesi�n de chat con un representante de ventas. Una vez se ha determinado la funcionalidad del contenido, el autor verifica que cada una de las funciones identificadas se puede realizar utilizando s�lo el teclado.", 
				categoriaTecnica);
	}

	/**
	 * 1. Identificar todas las funcionalidad del contenido.
	 * 2. Verificar que todas las funcionalidades puedan ser accedidas utilizando s�lo el teclado o interfaz de teclado.
	 */
	public ResultadoEvaluacionTecnica validarAccesibilidadPorTecnica(Parseador parseador) {
		this.setParseador(parseador);
		ResultadoEvaluacionTecnica resultadoEvaluacionTecnica = new ResultadoEvaluacionTecnica(this);
		ResultadoEvaluacionTecnicaItem comprobacionFuncionalidadesAccedidasUtilizandoSoloTeclado = new ResultadoEvaluacionTecnicaItem(
				Tipologia.PAGINA_WEB, 
				"Funcionalidades accedidas utilizando s�lo el teclado.", 
				TipoResultadoEvaluacion.IMPOSIBLE,
				"Verificar que todas las funcionalidades puedan ser accedidas utilizando s�lo el teclado o interfaz de teclado.",
				"Ofrece manejadores de eventos de teclado usando una de las siguientes opciones: 1) incluyendo funciones espec�ficas de teclado y de otro dispositivo. 2) haciendo que el evento \"on click\" en enlaces y botones sea accesible por teclado. 3) haciendo redundantes los eventos de mouse y teclado.");
		comprobacionFuncionalidadesAccedidasUtilizandoSoloTeclado.procesar();
		resultadoEvaluacionTecnica.agregarResultadoEvaluacionTecnicaItem(comprobacionFuncionalidadesAccedidasUtilizandoSoloTeclado);
		return resultadoEvaluacionTecnica;
	}

}