package depositossubterraneos;

public class Tanque {
	
	int superficie, profundidad, prof_total;

	public Tanque(int superficie, int profundidad) {
		super();
		this.superficie = superficie;
		this.profundidad = profundidad;
		this.prof_total = profundidad;
	}

	@Override
	public String toString() {
		return "Tanque [superficie=" + superficie + ", profundidad=" + profundidad + ", prof_total="
				+ prof_total + "]";
	}
}
