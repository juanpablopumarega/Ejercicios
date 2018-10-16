package llenandoestanques;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		
		Estanque estanque = Archivo.leer("archivos/estanques.in");
		System.out.println(estanque);
		
		estanque.resolver();

	}

}
