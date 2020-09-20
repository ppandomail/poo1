package ar.edu.uno.poo1.proyecto_genetico;

public class CromosomaTP {
	
	private String representacionGenesHexadecimal;
	private String representacionGenesBinaria;
	private Integer fitness;
	
	public CromosomaTP(String representacionGenesHexadecimal) {
		this.setRepresentacionGenesHexadecimal(representacionGenesHexadecimal);
		this.setRepresentacionGenesBinaria(this.getConvertirHexadecimalABinario());
		this.setFitness(this.calcularFitness());
	}
	
	public CromosomaTP(String representacionGenesHexadecimal, Integer fitness) {
		this.setRepresentacionGenesHexadecimal(representacionGenesHexadecimal);
		this.setRepresentacionGenesBinaria(this.getConvertirHexadecimalABinario());
		this.setFitness(fitness);
	}
	
	private String getConvertirHexadecimalABinario() {
		return Long.toBinaryString(Long.parseLong(this.getRepresentacionGenesHexadecimal(), 16));
	}
	
	private String getConvertirBinarioAHexadecimal() {
		return Long.toHexString(Long.parseLong(this.getRepresentacionGenesBinaria(), 2)).toUpperCase();
	}
	
	private Integer calcularFitness() {
		return (this.getCantidadHexadecimalCoincidentes() + 1) * (int) (Math.pow(this.getCantidadBinariosCoincidentes(), 2));
	}
	
	private Integer getCantidadHexadecimalCoincidentes() {
		Integer h = 0;
		for (Integer i = 0; i<this.getRepresentacionGenesHexadecimal().length(); i++)
			if (this.getRepresentacionGenesHexadecimal().charAt(i) == Clave.getClave().getCromosomaTP().getRepresentacionGenesHexadecimal().charAt(i))
				h++;
		return h;
	}
	
	private Integer getCantidadBinariosCoincidentes() {
		Integer b = 0;
		for (Integer i = 0; i<this.getRepresentacionGenesBinaria().length(); i++)
			if (this.getRepresentacionGenesBinaria().charAt(i) == Clave.getClave().getCromosomaTP().getRepresentacionGenesBinaria().charAt(i))
				b++;
		return b;
	}

	public String getRepresentacionGenesHexadecimal() {
		return representacionGenesHexadecimal;
	}

	public void setRepresentacionGenesHexadecimal(
			String representacionGenesHexadecimal) {
		this.representacionGenesHexadecimal = representacionGenesHexadecimal;
	}

	public String getRepresentacionGenesBinaria() {
		return representacionGenesBinaria;
	}

	public void setRepresentacionGenesBinaria(String representacionGenesBinaria) {
		this.representacionGenesBinaria = representacionGenesBinaria;
	}

	public Integer getFitness() {
		return fitness;
	}

	public void setFitness(Integer fitness) {
		this.fitness = fitness;
	}
	
	public String toString() {
		return this.getRepresentacionGenesHexadecimal().concat(" ").concat(this.getRepresentacionGenesBinaria()).concat(" ").concat(" ").concat(String.valueOf(this.getFitness()));
	}
	
	public void mutar() {
		char [] genes = this.getRepresentacionGenesBinaria().toCharArray();
		for (Integer i=1; i<=4; i++) {
			Integer aleatorio = (int) ((Math.random() * 10) % this.getRepresentacionGenesBinaria().length());
			System.out.println(aleatorio);
			genes[aleatorio] = (genes[aleatorio] == '1')?'0':'1';
		}
		this.setRepresentacionGenesBinaria(new String(genes));
		this.setRepresentacionGenesHexadecimal(this.getConvertirBinarioAHexadecimal());
		this.setFitness(this.calcularFitness());
	}
	
	public static CromosomaTP[] reproducir(CromosomaTP cromosomaTP1, CromosomaTP cromosomaTP2) {
		return new CromosomaTP[]{null, null};
	}
	
}