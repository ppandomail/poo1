package ar.edu.uno.poo1.proyecto_annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Bug {
	
	int numero();
	String descripcion();
	String desarrollo();
	
}