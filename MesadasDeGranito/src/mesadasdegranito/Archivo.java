package mesadasdegranito;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Archivo {
	
	public static ArrayList<Mesada> leer(String miPath) throws IOException {
		Scanner sc = new Scanner(new File(miPath));
		int longitud = sc.nextInt();
		ArrayList<Mesada> mesadas = new ArrayList<Mesada>();
		
		//Cargo todas las mesadas proveenientes del archivo
		for(int i = 0; i < longitud; i++) {
			mesadas.add(new Mesada(sc.nextInt(), sc.nextInt()));
		}
		
		//Las roto si el ancho es mayor al largo, osea, el ancho pasa a tener el valor del ancho y el ancho el del largo.
		for(int i = 0; i < longitud; i++) {
			mesadas.get(i).rotarMesada();
		}

		//Las ordeno de en forma descendente por largo.
		mesadas.sort(null);

		sc.close();
		return mesadas;
	}
	
	public static void escribir(int cant_mesadas, String miPath) throws IOException {
		PrintWriter salida = new PrintWriter(new FileWriter(miPath));
		salida.println(cant_mesadas);
		salida.close();
	}
	
}
