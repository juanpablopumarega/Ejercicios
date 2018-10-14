package descubriendonombresrepetidos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) throws IOException {
		
		String miPathIn = "archivos/nombres.in";
		String miPathOut = "archivos/nombres.out";
		Scanner sc = new Scanner(new File(miPathIn));
		PrintWriter salida = new PrintWriter(new FileWriter(miPathOut));
		
		int longitud = sc.nextInt();
		int maximo = sc.nextInt();
		
		ArrayList<String> nombres_del_file = new ArrayList<String>();

		sc.nextLine();
		
		for(int i = 0; i < longitud; i++) {
			nombres_del_file.add(sc.nextLine());
		}
		
		Collections.sort(nombres_del_file);

		ArrayList<NombreRepetitivo> nombres_con_repeticiones = new ArrayList<NombreRepetitivo>();
		
		String nombre_aux = nombres_del_file.get(0);
		int repeticiones = 0;
		
		for(int i = 0; i < longitud; i++) {
			
			if(nombre_aux.equals(nombres_del_file.get(i))) {
				repeticiones++;
			}
			else {
				nombres_con_repeticiones.add(new NombreRepetitivo(nombre_aux,repeticiones));
				  repeticiones = 1;
				  nombre_aux = nombres_del_file.get(i);
			}
			
		}
		
		nombres_con_repeticiones.add(new NombreRepetitivo(nombre_aux,repeticiones));
		
		System.out.println("CHEQUEANDO FRECUENCY");
		System.out.println(Collections.frequency(nombres_del_file, "Juan"));
		
		Collections.sort(nombres_con_repeticiones);
		
		System.out.println("Mostrando lista de nombres AGRUPADAS Y ORDENADOS: ");
		System.out.println(nombres_con_repeticiones);
		
		System.out.println("Salida del programa: ");
		
		System.out.println("CHEQUEANDO ");
		
		Iterator<NombreRepetitivo> it = nombres_con_repeticiones.iterator();
		
		while(it.hasNext() && maximo-- > 0) {
			System.out.println(it.next());
		}

		sc.close();
		salida.close();

	}

}
