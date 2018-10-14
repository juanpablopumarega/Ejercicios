package conflictoentrereinas;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		
		Tablero tablero = ArchivoReina.leer("archivos/conflictos.in");
		ArchivoReina.escribir(tablero.resolverConflictos(), "archivos/conflictos.out");
		System.out.println("Hola Mundo");

	}

}
