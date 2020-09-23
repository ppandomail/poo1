package ar.edu.unsam.getec.proyecto_accesibilidadweb.util;

import java.util.Properties;

public class Constantes {
	
	public static Integer DBTYPE;
	public static String DATA_SOURCE_NAME;
	public static String URL_DATA_BASE;
	public static String VERSION;
	public static String TITULO_PRINCIPAL;
	public static String TITULO_PAGINA_WEB;
	public static String TITULO_HTML;
	public static String TITULO_PDF_ANEXO;
	public static String TITULO_PDF_DETALLADO;
	public static String TITULO_XLS_DETALLADO;
	public static String PATH_IMAGE_LOGO16;
	public static String PATH_IMAGE_LOGO32;
	public static String PATH_IMAGE_LOGO48;
	public static String PATH_IMAGE_LOGO_PDF;
	public static String PATH_IMAGE_LOGO_XLS;
	public static String PATH_IMAGE_LOGO_HTML;
	public static String URL_JERICHO;
	public static String URL_TECNICAS_WCAG20;
	public static String PATH_IMAGE_HELP;
	public static String PATH_IMAGE_OK;
	public static String PATH_IMAGE_ERROR;
	public static String PATH_IMAGE_MANUAL;
	public static String PATH_IMAGE_IMPOSIBLE;
	public static String PATH_IMAGE_VERIFICACION;
	public static String PATH_IMAGE_RECOMENDACION;
	public static Integer PUNTAJE_CRITERIO_OK;
	public static Integer PUNTAJE_CRITERIO_ERROR;
	public static Integer PUNTAJE_UMBRAL;
	public static String MENSAJE_ACCESIBLE;
	public static String MENSAJE_NO_ACCESIBLE;
	public static Color COLOR_PRINCIPIO;
	public static Color COLOR_PAUTA;
	public static Color COLOR_CRITERIO;
	public static Color COLOR_TECNICA;
	public static Color COLOR_TECNICA_ITEM;

	private Constantes() {

	}

	private static String getVariableString(Properties properties, String variable, String defaultValor) {
		String valor;
		if ((valor = properties.getProperty(variable)) == null) {
			System.err.println("Variable <" + variable + ">, usando defaultValor ("	+ defaultValor + ")");
			valor = defaultValor;
		}
		return valor;
	}

	public static Integer getVariableInteger(Properties properties, String variable, String defaultValor) {
		return (int) Long.decode(Constantes.getVariableString(properties, variable, defaultValor)).longValue();
	}

	public static Long getVariableLong(Properties properties, String variable, String defaultValor) {
		return (Long) Long.decode(Constantes.getVariableString(properties, variable, defaultValor)).longValue();
	}

	public static Color getVariableColor(Properties properties, String variable, String defaultValor) {
		return new Color(Constantes.getVariableString(properties, variable, defaultValor));
	}

	public static void cargarVariables(Properties properties) {
		VERSION = Constantes.getVariableString(properties, "VERSION", "v20160101");
		TITULO_PRINCIPAL = Constantes.getVariableString(properties, "TITULO_PRINCIPAL", "XXX");
		TITULO_PAGINA_WEB = Constantes.getVariableString(properties, "TITULO_PAGINA_WEB", "XXX");
		TITULO_HTML = Constantes.getVariableString(properties, "TITULO_HTML", "XXX");
		TITULO_PDF_ANEXO = Constantes.getVariableString(properties, "TITULO_PDF_ANEXO", "XXX");
		TITULO_PDF_DETALLADO = Constantes.getVariableString(properties, "TITULO_PDF_DETALLADO", "XXX");
		TITULO_XLS_DETALLADO = Constantes.getVariableString(properties, "TITULO_XLS_DETALLADO", "XXX");
		PATH_IMAGE_LOGO16 = Constantes.getVariableString(properties, "PATH_IMAGE_LOGO16", ".");
		PATH_IMAGE_LOGO32 = Constantes.getVariableString(properties, "PATH_IMAGE_LOGO32", ".");
		PATH_IMAGE_LOGO48 = Constantes.getVariableString(properties, "PATH_IMAGE_LOGO48", ".");
		PATH_IMAGE_LOGO_PDF = Constantes.getVariableString(properties, "PATH_IMAGE_LOGO_PDF", ".");
		PATH_IMAGE_LOGO_XLS = Constantes.getVariableString(properties, "PATH_IMAGE_LOGO_XLS", ".");
		PATH_IMAGE_LOGO_HTML = Constantes.getVariableString(properties, "PATH_IMAGE_LOGO_HTML", ".");
		URL_JERICHO = Constantes.getVariableString(properties, "URL_JERICHO", "");
		URL_TECNICAS_WCAG20 = Constantes.getVariableString(properties, "URL_TECNICAS_WCAG20", "");
		PATH_IMAGE_HELP = Constantes.getVariableString(properties, "PATH_IMAGE_HELP", ".");
		PATH_IMAGE_OK = Constantes.getVariableString(properties, "PATH_IMAGE_OK", ".");
		PATH_IMAGE_ERROR = Constantes.getVariableString(properties, "PATH_IMAGE_ERROR", ".");
		PATH_IMAGE_MANUAL = Constantes.getVariableString(properties, "PATH_IMAGE_MANUAL", ".");
		PATH_IMAGE_IMPOSIBLE = Constantes.getVariableString(properties, "PATH_IMAGE_IMPOSIBLE", ".");
		PATH_IMAGE_VERIFICACION = Constantes.getVariableString(properties, "PATH_IMAGE_VERIFICACION", ".");
		PATH_IMAGE_RECOMENDACION = Constantes.getVariableString(properties, "PATH_IMAGE_RECOMENDACION", ".");
		PUNTAJE_CRITERIO_OK = Constantes.getVariableInteger(properties, "PUNTAJE_CRITERIO_OK", "4");
		PUNTAJE_CRITERIO_ERROR = Constantes.getVariableInteger(properties, "PUNTAJE_CRITERIO_ERROR", "0");
		PUNTAJE_UMBRAL = Constantes.getVariableInteger(properties, "PUNTAJE_UMBRAL", "50");
		MENSAJE_ACCESIBLE = Constantes.getVariableString(properties, "MENSAJE_ACCESIBLE", "ACCESIBLE");
		MENSAJE_NO_ACCESIBLE = Constantes.getVariableString(properties, "MENSAJE_NO_ACCESIBLE", "NO ACCESIBLE");
		COLOR_PRINCIPIO = Constantes.getVariableColor(properties, "COLOR_PRINCIPIO", "217,217,255");
		COLOR_PAUTA = Constantes.getVariableColor(properties, "COLOR_PAUTA", "255,255,255");
		COLOR_CRITERIO = Constantes.getVariableColor(properties, "COLOR_CRITERIO", "255,255,255");
		COLOR_TECNICA = Constantes.getVariableColor(properties, "COLOR_TECNICA", "255,255,255");
		COLOR_TECNICA_ITEM = Constantes.getVariableColor(properties, "COLOR_TECNICA_ITEM", "255,255,255");
	}

}