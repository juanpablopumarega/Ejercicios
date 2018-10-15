package mesadasdegranito;

import java.io.IOException;
import java.util.ArrayList;

public class App {
	public static void main(String[] args) throws IOException {
		ArrayList<Mesada> mesadas = Archivo.leer("archivos/mesadas.in");
		Archivo.escribir(Resolver.cantidadPilas(mesadas), "archivos/mesadas.out");
	}
}