package descubriendonombresrepetidos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Juego {
	
	ArrayList<String> nombres;
	int maximo;
	
	public Juego(ArrayList<String> nombres, int maximo) {
		this.nombres = nombres;
		this.maximo = maximo;
	}


	public ArrayList<NombreRepetitivo> calcularRepeticiones() {
		
		ArrayList<String> lista_de_nombres = this.nombres;
		Collections.sort(lista_de_nombres);
		ArrayList<NombreRepetitivo> nombres_con_repeticiones = new ArrayList<NombreRepetitivo>();
		String nombre_aux = lista_de_nombres.get(0);
		int repeticiones = 0;
		
		for(int i = 0; i < lista_de_nombres.size(); i++) {
			
			if(nombre_aux.equals(lista_de_nombres.get(i))) {
				repeticiones++;
			}
			else {
				nombres_con_repeticiones.add(new NombreRepetitivo(nombre_aux,repeticiones));
				  repeticiones = 1;
				  nombre_aux = lista_de_nombres.get(i);
			}
			
		}
		
		nombres_con_repeticiones.add(new NombreRepetitivo(nombre_aux,repeticiones));
		Collections.sort(nombres_con_repeticiones);
		
		Iterator<NombreRepetitivo> it = nombres_con_repeticiones.iterator();
		ArrayList<NombreRepetitivo> salida = new ArrayList<NombreRepetitivo>(this.maximo);
		
		while(it.hasNext() && this.maximo-- > 0) {
			salida.add(it.next());
		}
		
		return salida;
	}
}
