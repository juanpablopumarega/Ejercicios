package llenandoestanques;

public class Tanque {
	
	int superficie, profundidad, ca�eria, profundidad_total;
	boolean utilizado;

	public Tanque(int superficie, int profundidad, int ca�eria) {
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.ca�eria = ca�eria;
		this.profundidad_total = 0;
		this.utilizado = false;
	}

	public String toString() {
		return "Tanque sup:" + superficie + ", prof:" + profundidad + ", ca�:" + ca�eria
				+ ", prof_total:" + profundidad_total + " utilizado?: " + utilizado;
	}
	
	
	
}
