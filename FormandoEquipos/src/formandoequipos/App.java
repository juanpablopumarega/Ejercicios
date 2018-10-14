package formandoequipos;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		
		ArchivoInfo informacion = Archivo.leer("archivos/equipos.in");
		Archivo.escribir("archivos/equipos.out", Afinidad.formandoEquipos(informacion));

	}

}
