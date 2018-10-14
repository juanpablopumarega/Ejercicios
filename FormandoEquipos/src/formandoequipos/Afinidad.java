package formandoequipos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Afinidad implements Comparable<Afinidad>{
	
	String respuesta;
	int afinidad;
	
	public Afinidad(String respuesta, int afinidad) {
		this.respuesta = respuesta;
		this.afinidad = afinidad;
	}

	public int compareTo(Afinidad o) {
		return o.afinidad - this.afinidad;
	}

	public String toString() {
		return respuesta + " " + afinidad;
	}
	
	
	public static ArrayList<Afinidad> formandoEquipos(ArchivoInfo info) {
		
		ArrayList<Afinidad> afinidades = new ArrayList<Afinidad>();
		ArrayList<String> respuestas = info.respuestas;
		
		for(int i = 0; i < info.cantidad_preguntas; i++) {
			
			ArrayList<String> respuestas_parciales = new ArrayList<String>();
			Iterator<String> it = respuestas.iterator();
			
			while(it.hasNext()) {
				respuestas_parciales.add(it.next().substring(0, i+1));
			}	
			
			afinidades.addAll(calculoAfinidades(respuestas_parciales,i+1));
			
		}
		
		Collections.sort(afinidades);
		return afinidades;
	}
	
	
	public static ArrayList<Afinidad> calculoAfinidades(ArrayList<String> tmp, int i) {
		ArrayList<Afinidad> afinidades = new ArrayList<Afinidad>();
		
		int longitud = tmp.size();
		int contador_misma_respuesta = 0;
		String respuesta_tmp = tmp.get(0);
		
		for(int x = 0; x < longitud; x++) {
			
			if(tmp.get(x).equals(respuesta_tmp)) {
				contador_misma_respuesta++;
			}
			else {
				if(contador_misma_respuesta > 1)					
					afinidades.add(new Afinidad(respuesta_tmp, (int) (contador_misma_respuesta * Math.pow(i, 2))));
				contador_misma_respuesta = 1;
			}
			
			respuesta_tmp = tmp.get(x);
			
		}
		
		if(contador_misma_respuesta > 1)
			afinidades.add(new Afinidad(respuesta_tmp, (int) (contador_misma_respuesta * Math.pow(i, 2))));
		
		return afinidades;
	}
	
}
