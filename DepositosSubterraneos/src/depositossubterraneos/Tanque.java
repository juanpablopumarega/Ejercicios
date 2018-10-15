package depositossubterraneos;

import java.util.ArrayList;

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
	
	
	public static ArrayList<Integer> resolver(ArchivoInfo info) {
		
		ArrayList<Integer> salida = new ArrayList<Integer>();
		
		int capacidad_total_tanques = 0;
		
		for(int i = 0; i < info.tanques.length; i++) {
			capacidad_total_tanques += info.tanques[i].superficie * info.tanques[i].profundidad;
		}
		
		if(info.litros > capacidad_total_tanques) {
			salida.add(info.litros - capacidad_total_tanques);
			return salida;
		}
		
		
		 int profundidad_maxima = info.tanques[0].profundidad;
		    
         while(info.litros > 0 && profundidad_maxima > 0) {
             
             ArrayList<Tanque> tanques_usables = new ArrayList<Tanque>();
             
             for(int i = 0; i < info.tanques.length; i++) {
                 if(profundidad_maxima == info.tanques[i].profundidad)
                         tanques_usables.add(info.tanques[i]);
             }
             
             for(int i = 0; i < tanques_usables.size(); i++) {
            	 info.litros -= tanques_usables.get(i).superficie;
                 tanques_usables.get(i).profundidad--;
             }
             
             profundidad_maxima--; 
         }
         
         
         int contador_tanques_utilizados = 0;
         
         for(int i = 0; i <info.tanques.length; i++) {
             if(info.tanques[i].prof_total != info.tanques[i].profundidad)
                 contador_tanques_utilizados++;
         }
		
		 salida.add(contador_tanques_utilizados);
		 salida.add(info.tanques[0].profundidad);
		
		 return salida;
		
	}
}
