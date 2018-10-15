package depositossubterraneos;

import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		
		ArchivoInfo informacion = Archivo.leer("archivos/depositos.in");
		Archivo.escribir(Tanque.resolver(informacion), "archivos/depositos.out");

	}

}
