package ar.edu.uno.poo1.proyecto_patitaspollo;

public class PatitasPollo {

	public static void main(String[] args) {
		System.out.println(PatitasPollo.esPosibleComprar(20));
		System.out.println(PatitasPollo.esPosibleComprar(9));
		System.out.println(PatitasPollo.esPosibleComprar(6));
		System.out.println(PatitasPollo.esPosibleComprar(3));
		System.out.println(PatitasPollo.esPosibleComprar(14));
		System.out.println(PatitasPollo.esPosibleComprar(12));
		System.out.println(PatitasPollo.esPosibleComprar(67));
	}
	
	private static boolean esPosibleComprar(int cantidadAComprar) {
		int [] paquetes = new int[] {20, 9, 6};
		int aux = cantidadAComprar;
		if (cantidadAComprar < paquetes[2])
			return false;
		for (int i = 0; i < paquetes.length; i++) {
			if (cantidadAComprar % paquetes[i] == 0)
				return true;
			if (aux >= paquetes[i])
				aux -= paquetes[i];
			for (int j = 0; j < paquetes.length; j++)
				if (aux % paquetes[j] == 0 || aux == 0)
					return true;
		}	
		return aux == 0;
	}

}