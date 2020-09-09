package ar.edu.uno.poo1.proyecto_cifradocesar;

public class CifradoCesar {

	public static void main(String[] args) {
		System.out.println(CifradoCesar.cifrar("HOLA", 2));
		System.out.println(CifradoCesar.cifrar("HOLA", 3));
		System.out.println(CifradoCesar.cifrar("HOLA", 4));
		System.out.println(CifradoCesar.cifrar("Programación con Objetos 1", 2));
	}

	public static String cifrar(String texto, int codigo) {
		StringBuilder cifrado = new StringBuilder();
		codigo = codigo % 26;
		for (int i = 0; i < texto.length(); i++) 
			if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') 
				if ((texto.charAt(i) + codigo) > 'z') 
					cifrado.append((char) (texto.charAt(i) + codigo - 26));
				else 
					cifrado.append((char) (texto.charAt(i) + codigo));

			else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') 
				if ((texto.charAt(i) + codigo) > 'Z') 
					cifrado.append((char) (texto.charAt(i) + codigo - 26));
				else 
					cifrado.append((char) (texto.charAt(i) + codigo));
		return cifrado.toString();
	}

}