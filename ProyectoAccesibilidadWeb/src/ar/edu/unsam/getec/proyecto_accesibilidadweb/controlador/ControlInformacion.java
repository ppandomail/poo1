package ar.edu.unsam.getec.proyecto_accesibilidadweb.controlador;

public class ControlInformacion {
	
	public final static Integer OK = 0;
	public final static Integer SESION = 1;
	public final static Integer PARAMETRO = 2;
	public final static Integer METODO = 3;
	public final static Integer ERROR = 4;
	public final static Integer SISTEMA = 5;
	private Integer codigo;
	private String mensaje;
	private String descripcion;
	private Throwable throwable;

	public ControlInformacion() {
		this(ControlInformacion.OK, "Accion ejecutada con exito", "", null);
	}

	public ControlInformacion(Integer codigo, String mensaje, String descripcion, Throwable throwable) {
		this.setCodigo(codigo);
		this.setMensaje(mensaje);
		this.setDescripcion(descripcion);
		this.setThrowable(throwable);
	}

	public boolean isOk() {
		return this.getCodigo() == ControlInformacion.OK;
	}

	public String getMensajeCompleto() {
		StackTraceElement[] stackTraceElement;
		String mensajeThrowable;
		if (this.getThrowable() != null) {
			mensajeThrowable = "\n\t" + this.getThrowable().toString() + "  at  \n";
			stackTraceElement = this.getThrowable().getStackTrace();
			for (Integer i = 0; i < stackTraceElement.length; i++) {
				mensajeThrowable += "\t" + stackTraceElement[i].getClassName() + "::" + stackTraceElement[i].getMethodName();
				if (!stackTraceElement[i].isNativeMethod())
					mensajeThrowable += "  " + stackTraceElement[i].getFileName() + ":" + stackTraceElement[i].getLineNumber() + "\n";
			}
		} else
			mensajeThrowable = "";
		return (this.getMensaje() + ": " + this.getDescripcion() + " [" + mensajeThrowable + "]");
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Throwable getThrowable() {
		return this.throwable;
	}

	public void setThrowable(Throwable throwable) {
		this.throwable = throwable;
	}	


}