package descubriendonombresrepetidos;

public class NombreRepetitivo implements Comparable<NombreRepetitivo>{
	
	String nombre;
	int repeticiones;
	
	public NombreRepetitivo(String nombre, int repeticiones) {
		this.nombre = nombre;
		this.repeticiones = repeticiones;
	}

	public String toString() {
		return nombre + " " + repeticiones;
	}

	public int compareTo(NombreRepetitivo nom) {
		return  nom.repeticiones - this.repeticiones;
	}
	
}
