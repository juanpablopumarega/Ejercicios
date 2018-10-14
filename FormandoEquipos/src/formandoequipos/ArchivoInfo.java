package formandoequipos;

import java.util.ArrayList;

public class ArchivoInfo {
	
	int cantidad_preguntas;
	int cantidad_personas;
	ArrayList<String> respuestas;
	
	public ArchivoInfo(int cantidad_preguntas, int cantidad_personas, ArrayList<String> respuestas) {
		super();
		this.cantidad_preguntas = cantidad_preguntas;
		this.cantidad_personas = cantidad_personas;
		this.respuestas = respuestas;
	}

	public String toString() {
		return "ArchivoInfo [cantidad_preguntas=" + cantidad_preguntas + ", cantidad_personas=" + cantidad_personas
				+ ", respuestas=" + respuestas + "]";
	}
	
}
