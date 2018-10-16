package formandoequipos;

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
		
		int cantidad_preguntas = sc.nextInt();
		int cantidad_personas = sc.nextInt();

		ArrayList<String> respuestas = new ArrayList<String>();
		
		sc.nextLine();
		
		for(int i = 0; i < cantidad_personas; i++) {
			respuestas.add(sc.nextLine());
		}
		
		respuestas.sort(null);
		
		sc.close();
		return new ArchivoInfo(cantidad_preguntas,cantidad_personas,respuestas);		
	}
	
	public static void escribir(String miPath, ArrayList<Afinidad> afinidades) throws IOException {
		
		PrintWriter salida = new PrintWriter(new FileWriter(miPath));
		
		if(afinidades.size() != 0) {
			salida.println(afinidades.get(0).afinidad);
			salida.println(afinidades.get(0).respuesta);
		}			
		
		salida.close();
	}
	
	
	

}
