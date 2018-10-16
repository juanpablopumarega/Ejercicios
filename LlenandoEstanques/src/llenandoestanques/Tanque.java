package llenandoestanques;

public class Tanque {
	
	int superficie, profundidad, cañeria, profundidad_total;
	boolean utilizado;

	public Tanque(int superficie, int profundidad, int cañeria) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.cañeria = cañeria;
		this.profundidad_total = 0;
		this.utilizado = false;
	}

	public String toString() {
		return "Tanque sup:" + superficie + ", prof:" + profundidad + ", cañ:" + cañeria
				+ ", prof_total:" + profundidad_total + " utilizado?: " + utilizado;
	}
	
	
	
}
