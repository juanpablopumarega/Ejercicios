package llenandoestanques;

import java.util.ArrayList;

public class Estanque {
	
	ArrayList<Tanque> tanques;
	int volumen;
	
	public Estanque(ArrayList<Tanque> tanques, int volumen) {
		this.tanques = tanques;
		this.volumen = volumen;
	}

	public String toString() {
		return "Estanque [tanques=" + tanques + ", volumen=" + volumen + "]";
	}
	
	public void resolver() {
		
		int capacidad_maxima_tanques = 0;
		
		for(int i = 0; i < this.tanques.size(); i++) {
			capacidad_maxima_tanques += this.tanques.get(i).superficie * this.tanques.get(i).profundidad;
		}
		
		if(volumen > capacidad_maxima_tanques) {
			System.out.println("Hay desborde: " + (volumen - capacidad_maxima_tanques));
		}
		
			
		}
		

	
	
}
