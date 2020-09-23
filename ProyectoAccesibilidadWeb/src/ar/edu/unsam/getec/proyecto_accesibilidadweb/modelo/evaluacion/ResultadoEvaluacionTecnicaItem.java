package ar.edu.unsam.getec.proyecto_accesibilidadweb.modelo.evaluacion;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import net.htmlparser.jericho.Attribute;
import net.htmlparser.jericho.Element;

public class ResultadoEvaluacionTecnicaItem {
	
	private Tipologia tipologia;
	private String nombre;
	private TipoResultadoEvaluacion tipoResultadoEvaluacion;
	private String descripcion;
	private String recomendacion;
	private Integer incidencias;
	private String numeroLineas;
	private List<String> lineas;
	private static Hashtable<Integer, List<TipoResultadoEvaluacion>> registroLinea = new Hashtable<>();

	public ResultadoEvaluacionTecnicaItem(Tipologia tipologia, String nombre, String descripcion, String recomendacion) {
		this(tipologia, nombre, TipoResultadoEvaluacion.OK, descripcion, recomendacion);
	}

	public ResultadoEvaluacionTecnicaItem(Tipologia tipologia, String nombre, TipoResultadoEvaluacion tipoResultadoEvaluacion, String descripcion, String recomendacion) {
		this.setTipologia(tipologia);
		this.setNombre(nombre);
		this.setTipoResultadoEvaluacion(tipoResultadoEvaluacion);
		this.setDescripcion(descripcion);
		this.setRecomendacion(recomendacion);
		this.setIncidencias(0);
		this.setNumeroLineas("");
		this.setLineas(new LinkedList<String>());
	}

	public void procesar(Element element) {
		this.incrementar();
		Integer numeroLinea = element.getRowColumnVector().getRow();
		this.agregarNumeroLinea(numeroLinea);
		this.agregarLinea(numeroLinea + ". \t" + element.toString());
	}

	public void procesar(Attribute attribute) {
		this.incrementar();
		Integer numeroLinea = attribute.getRowColumnVector().getRow();
		this.agregarNumeroLinea(numeroLinea);
		this.agregarLinea(numeroLinea + ". \t" + attribute.toString());
	}

	public void procesarSinIncrementar() {
		this.agregarNumeroLinea(0);
	}

	public void procesar() {
		this.incrementar();
		this.agregarNumeroLinea(0);
	}

	private void incrementar() {
		if (this.getTipoResultadoEvaluacion() == TipoResultadoEvaluacion.OK)
			this.setTipoResultadoEvaluacion(TipoResultadoEvaluacion.ERROR);
		this.setIncidencias(this.getIncidencias() + 1);
	}

	private void agregarNumeroLinea(Integer numeroLinea) {
		this.registrarNumeroLinea(numeroLinea);
		if (this.getNumeroLineas().isEmpty())
			this.setNumeroLineas(numeroLinea.toString());
		else
			this.setNumeroLineas(this.getNumeroLineas() + ", " + numeroLinea.toString());
	}

	private void agregarLinea(String linea) {
		this.getLineas().add(linea);
	}

	public void registrarNumeroLinea(Integer numeroLinea) {
		if (numeroLinea != 0) {
			List<TipoResultadoEvaluacion> listaTipoResultadoEvaluacion;
			if (ResultadoEvaluacionTecnicaItem.registroLinea.containsKey(numeroLinea)) 
				listaTipoResultadoEvaluacion = ResultadoEvaluacionTecnicaItem.registroLinea.get(numeroLinea);
			else 
				listaTipoResultadoEvaluacion = new LinkedList<>();
			listaTipoResultadoEvaluacion.add(this.getTipoResultadoEvaluacion());
			ResultadoEvaluacionTecnicaItem.registroLinea.put(numeroLinea, listaTipoResultadoEvaluacion);
		}	
	}

	public Boolean isOKTipoResultadoEvaluacion() {
		return this.getTipoResultadoEvaluacion().equals(TipoResultadoEvaluacion.OK);
	}

	public Boolean isErrorTipoResultadoEvaluacion() {
		return this.getTipoResultadoEvaluacion().equals(TipoResultadoEvaluacion.ERROR);
	}

	public Boolean isManualTipoResultadoEvaluacion() {
		return this.getTipoResultadoEvaluacion().equals(TipoResultadoEvaluacion.MANUAL);
	}

	public Boolean isImposibleTipoResultadoEvaluacion() {
		return this.getTipoResultadoEvaluacion().equals(TipoResultadoEvaluacion.IMPOSIBLE);
	}	

	public Tipologia getTipologia() {
		return this.tipologia;
	}

	public void setTipologia(Tipologia tipologia) {
		this.tipologia = tipologia;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoResultadoEvaluacion getTipoResultadoEvaluacion() {
		return this.tipoResultadoEvaluacion;
	}

	public void setTipoResultadoEvaluacion(TipoResultadoEvaluacion tipoResultadoEvaluacion) {
		this.tipoResultadoEvaluacion = tipoResultadoEvaluacion;
	}

	public String getRecomendacion() {
		return this.recomendacion;
	}

	public void setRecomendacion(String recomendacion) {
		this.recomendacion = recomendacion;
	}

	public Integer getIncidencias() {
		return this.incidencias;
	}

	public void setIncidencias(Integer incidencias) {
		this.incidencias = incidencias;
	}

	public String getNumeroLineas() {
		return this.numeroLineas;
	}

	public void setNumeroLineas(String numeroLineas) {
		this.numeroLineas = numeroLineas;
	}

	public List<String> getLineas() {
		return this.lineas;
	}

	public void setLineas(List<String> lineas) {
		this.lineas = lineas;
	}

	public static Hashtable<Integer, List<TipoResultadoEvaluacion>> getRegistroLinea() {
		return ResultadoEvaluacionTecnicaItem.registroLinea;
	}
	
	public static void limpiarRegistroLinea() {
		ResultadoEvaluacionTecnicaItem.registroLinea.clear();
	}

	public String toString() {
		return this.getNumeroLineas().equals("0")? "" : this.getNumeroLineas();
	}

}