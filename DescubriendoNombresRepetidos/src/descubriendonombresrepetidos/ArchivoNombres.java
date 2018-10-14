package descubriendonombresrepetidos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArchivoNombres {
	
	public static Juego leer(String miPath) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new File(miPath));
		
		int longitud = sc.nextInt();
		int maximo = sc.nextInt();
		
		ArrayList<String> nombres_del_file = new ArrayList<String>();

		sc.nextLine();
		
		for(int i = 0; i < longitud; i++) {
			nombres_del_file.add(sc.nextLine());
		}
		
		sc.close();
		return new Juego(nombres_del_file, maximo);
	}
	
	
	public static void escribir(String miPath, ArrayList<NombreRepetitivo> out) throws IOException {
		
		PrintWriter salida = new PrintWriter(new FileWriter(miPath));
		
		Iterator<NombreRepetitivo> it = out.iterator();
		
		while(it.hasNext()) {
			salida.println(it.next());
		}

		salida.close();
	}
	
	

}
