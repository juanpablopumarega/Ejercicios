package descubriendonombresrepetidos;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		
		Juego nombres = ArchivoNombres.leer("archivos/nombres.in");
		ArchivoNombres.escribir("archivos/nombres.out", nombres.calcularRepeticiones());

	}

}
