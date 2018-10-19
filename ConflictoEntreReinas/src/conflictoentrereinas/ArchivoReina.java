package conflictoentrereinas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class ArchivoReina {
	
	public static Tablero leer(String miPath) throws IOException {
		
		Scanner sc = new Scanner(new File(miPath));
		
		int tablero = sc.nextInt();
		int longitud = sc.nextInt();
		Reina[] vec_reinas = new Reina[longitud];

		for (int i = 0; i < longitud; i++) {
			vec_reinas[i] = new Reina(i+1, sc.nextInt(), sc.nextInt());
		}
		
		sc.close();
		
		return new Tablero(tablero, vec_reinas);
	}
	
	
	public static void escribir(ArrayList<TreeSet<Integer>> out, String miPath) throws IOException {
		
		PrintWriter salida = new PrintWriter(new FileWriter(miPath));
		
		/*Recibo un ARrayList de un TreeSet de integer, donde cada posición del arraylist corresponde
		 * a los conflictos que tiene cada reina en particular
		 */
    	for(Iterator<TreeSet<Integer>> it = out.iterator(); it.hasNext();) {
    		
    		ArrayList<Integer> conflictos = new ArrayList<Integer>();
    		
    		if(!out.isEmpty()) {
    			for(Iterator<Integer> a = it.next().iterator(); a.hasNext();) {
    				conflictos.add((Integer)a.next());
    			}
    		}
    		
    		
    		/*Grabo en el archivo de salida los conflictos que traje del TreeSet, 
    		 * para poder imprimirlos de forma correcta en el archivo
    		 */
    		if(conflictos.size() > 0) {
    			salida.print(conflictos.size() + " ");
    			for(int h = 0; h < conflictos.size(); h++) {
    				salida.print(conflictos.get(h) + " ");
    			}
    			salida.println();
    		}
    		else
    			salida.println("0");
    		
        }	
     	
		salida.close();

	}
	

}
