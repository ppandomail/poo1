package ar.edu.uno.poo1.proyecto_complejo;

import java.util.Arrays;

public class DemoComplejos {

	public static void main(String[] args) {
		Complejo z1 = new Complejo();
		Complejo z2 = new Complejo(2,2);
		Complejo z3 = new Complejo(1.1,1.1);
		System.out.println(z1); 
		System.out.println(z2);
		System.out.println(z3);
		z3 = z1.suma(z2);
		System.out.println(z3); 
		z3 = Complejo.suma(z3,z2);
		System.out.println(z3); 

		Complejo [] vComplejo=new Complejo[10];

		for (int i=0; i<10;i++)
			vComplejo[i]= new Complejo(Math.sin(i+10),Math.cos(i+20));

		for (int i=0; i<10;i++)
			System.out.println(vComplejo[i]);

		Arrays.sort(vComplejo);

		for (int i=0; i<10;i++)
			System.out.println(vComplejo[i].modulo());
	}

}	