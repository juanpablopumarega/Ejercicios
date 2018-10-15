package depositossubterraneos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {

	public static ArchivoInfo leer(String miPath) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(miPath));
		Tanque[] tanques = new Tanque[sc.nextInt()];
		
		for(int i = 0; i < tanques.length; i++) {
			tanques[i] = new Tanque(sc.nextInt(),sc.nextInt());
		}
		
		int litros = sc.nextInt();
		sc.close();

		return new ArchivoInfo(tanques,litros);

	}
	
	public static void escribir(ArrayList<Integer> out, String miPath) throws IOException {
		
		PrintWriter salida = new PrintWriter(new FileWriter(miPath));
		
		if(out.size() == 1) {
			salida.println("Rebalsan: " + out.get(0));
		}
		else {
			salida.println(out.get(0));
			salida.println(out.get(1));
		}
		
		salida.close();
		
	}
	
	
}
