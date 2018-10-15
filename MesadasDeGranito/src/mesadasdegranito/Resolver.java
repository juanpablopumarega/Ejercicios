package mesadasdegranito;

import java.util.ArrayList;

public class Resolver {
	
	public static Integer cantidadPilas(ArrayList<Mesada> mesadas) {

		int cantidad_pilas = 0;
		
		//Itero por todas las mesadas disponibles
		while(!mesadas.isEmpty()) {
			
			//Tomo la primera como la primer pila y a saco del array  asi no vuelvo a compararla
			Mesada maxima = mesadas.get(0);
			mesadas.remove(0);
			
			//Itero por las mesadas restantes, si se pueden acumular las elimino del array ya que entraron en una pila correspondiente
			for(int i = 0; i < mesadas.size(); i++) {
				if(maxima.esAplilable(mesadas.get(i))) {
					maxima = mesadas.get(i);
					mesadas.remove(i);
					i--;
				}
			}

			cantidad_pilas++;
		}
		
		return cantidad_pilas;
	}
	
}
