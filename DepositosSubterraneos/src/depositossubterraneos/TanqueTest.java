package depositossubterraneos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TanqueTest {

	public static void main(String[] args) throws IOException {

		String miPathIn = "archivos/depositos.in";
		String miPathOut = "archivos/depositos.out";
		Scanner sc = new Scanner(new File(miPathIn));
		PrintWriter salida = new PrintWriter(new FileWriter(miPathOut));

		Tanque[] tanques = new Tanque[sc.nextInt()];
		int capacidad_total_tanques = 0;
		
		
		for(int i = 0; i < tanques.length; i++) {
			tanques[i] = new Tanque(sc.nextInt(),sc.nextInt());
			capacidad_total_tanques += tanques[i].superficie * tanques[i].profundidad;
		}
		
		int volumen = sc.nextInt();
		
		if(volumen > capacidad_total_tanques) {
			System.out.println("Rebalsan: " + (volumen-capacidad_total_tanques));
		}
		else {
		
			//System.out.println("TANQUES INCIALES: ");
			
			//for(int i = 0; i < tanques.length; i++) {
			//	System.out.println(tanques[i]);
			//}
			
			int profundidad_maxima = tanques[0].profundidad;
	
			while(volumen > 0 && profundidad_maxima > 0) {
				
				ArrayList<Tanque> tanques_usables = new ArrayList<Tanque>();
				
				for(int i = 0; i < tanques.length; i++) {
					if(profundidad_maxima == tanques[i].profundidad)
							tanques_usables.add(tanques[i]);
				}
				
				for(int i = 0; i < tanques_usables.size(); i++) {
					volumen -= tanques_usables.get(i).superficie;
					tanques_usables.get(i).profundidad--;
				}
				
				profundidad_maxima--; //= tanques[0].profundidad;
			}
			
			
			//System.out.println("TANQUES DESPUES DE LA REVISADA:");
			
			//for(int i = 0; i < tanques.length; i++) {
			//	System.out.println(tanques[i]);
			//}
			
			
			//System.out.println("SALIDA DEL PROGRAMA: ");
			
			int contador_tanques_utilizados = 0;
			
			for(int i = 0; i <tanques.length; i++) {
				if(tanques[i].prof_total != tanques[i].profundidad)
					contador_tanques_utilizados++;
			}
			
			System.out.println(contador_tanques_utilizados);
			System.out.println(tanques[0].profundidad);
		}
		
		sc.close();
		salida.close();
		
	}

}
