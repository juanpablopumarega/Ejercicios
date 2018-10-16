package llenandoestanques;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
	
	public static Estanque leer(String miPath) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(miPath));
		ArrayList<Tanque> tanques = new ArrayList<Tanque>();
		
		int longitud = sc.nextInt();
		
		for(int i = 0; i < longitud; i ++) {
			if(i != longitud - 1) {
				tanques.add(new Tanque(sc.nextInt(), sc.nextInt(), sc.nextInt()));
			}
			else {
				tanques.add(new Tanque(sc.nextInt(), sc.nextInt(), 0));
			}
		}
		
		int volumen = sc.nextInt();
		
		sc.close();
		return new Estanque(tanques, volumen);
	}
	
	

}
