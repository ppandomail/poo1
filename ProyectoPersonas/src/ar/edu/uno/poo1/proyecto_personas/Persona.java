package ar.edu.uno.poo1.proyecto_personas;

public class Persona {
	
	private String nombre;
	private String apellido;
	private int edad;
	private long dni;
	
	public Persona(String nombre, String apellido, int edad, long dni) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setEdad(edad);
		this.setDni(dni);
	}
	
	public Persona(String [] datos) {
		this(datos[0], datos[1], Integer.parseInt(datos[2]), Long.parseLong(datos[3]));
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return this.apellido;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getEdad() {
		return this.edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public long getDni() {
		return this.dni;
	}
	
	public void setDni(long dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return this.getNombre() + ", " + this.getApellido() + ", " + this.getEdad() + ", " + this.getDni();
	}
		
}