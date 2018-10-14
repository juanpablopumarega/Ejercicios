package conflictoentrereinas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class ReinaTest {

	public static void main(String[] args) throws IOException {

		
		String miPathIn = "archivos/conflictos.in";
		String miPathOut = "archivos/conflictos.out";
		Scanner sc = new Scanner(new File(miPathIn));
		PrintWriter salida = new PrintWriter(new FileWriter(miPathOut));
		
		int tablero = sc.nextInt();
		int longitud = sc.nextInt();
		Reina[] vec_reinas = new Reina[longitud];

		for (int i = 0; i < longitud; i++) {
			vec_reinas[i] = new Reina(i+1, sc.nextInt(), sc.nextInt());
		}
		
		sc.close();
		
        //vec_reinas[0] = new Reina(1,0,1);
        //vec_reinas[1] = new Reina(2,1,1);
        //vec_reinas[2] = new Reina(3,1,3);
        //vec_reinas[3] = new Reina(4,4,4);
        //vec_reinas[4] = new Reina(5,1,4);
        //vec_reinas[5] = new Reina(6,3,3);
        
        for(int i = 0; i < longitud; i++) {
		
        	TreeSet<Integer> moduloLinea = new TreeSet<Integer>();
        	
        	ReinaModulo c_down = new ReinaModulo(0,tablero);
        	ReinaModulo c_up = new ReinaModulo(0,-tablero);
        	ReinaModulo f_left = new ReinaModulo(0,+tablero);
        	ReinaModulo f_right = new ReinaModulo(0,-tablero);
        	
        	ReinaModulo d_arr_izq = new ReinaModulo(0,-tablero);
        	ReinaModulo d_arr_der = new ReinaModulo(0,+tablero);
        	ReinaModulo d_ab_izq = new ReinaModulo(0,-tablero);
        	ReinaModulo d_ab_der = new ReinaModulo(0,+tablero);
        	
        	
        	for(int h = 0; h < longitud; h++) {
				
        		if(vec_reinas[h].index != vec_reinas[i].index) {

        			//verifico misma fila/columna
        			if(vec_reinas[h].x == vec_reinas[i].x) {
        				int diff = vec_reinas[i].y - vec_reinas[h].y;
        				if(diff<0) {
        					if(diff > c_up.distancia) //verifico si la diferencia es mas pequeña que la anterior comparada
        						c_up = new ReinaModulo(vec_reinas[h].index,diff);
        				}
        				else {
        					if(diff < c_down.distancia) //verifico si la diferencia es mas pequeña que la anterior comparada
        						c_down = new ReinaModulo(vec_reinas[h].index,diff);
        				}
        			}
        			else {
        				if(vec_reinas[h].y == vec_reinas[i].y) {
        					int diff = vec_reinas[i].x - vec_reinas[h].x;
        					if(diff<0) {
        						if(diff > f_right.distancia) //verifico si la diferencia es mas pequeña que la anterior comparada
        							f_right = new ReinaModulo(vec_reinas[h].index,diff);
        					}
        					else {
        						if(diff < f_left.distancia) //verifico si la diferencia es mas pequeña que la anterior comparada
        							f_left = new ReinaModulo(vec_reinas[h].index,diff);
        					}
        				}
	
        			}
        			
        			//verifico misma Diagonal
        			if(mismaDiagonal(vec_reinas, i, h)) {
        				int diff_x = vec_reinas[h].x - vec_reinas[i].x;
        				int diff_y = vec_reinas[h].y - vec_reinas[i].y;
        					if(diff_x < 0) {
        						if(diff_y < 0) {
        							if(diff_y > d_ab_izq.distancia)
        								d_ab_izq = new ReinaModulo(vec_reinas[h].index,diff_y);
        							//d_ab_izq = diff_y > d_ab_izq.distancia ? new ReinaModulo(vec_reinas[h].index,diff_y) : d_ab_izq;
        						}
        						else {
        							if(diff_y < d_arr_izq.distancia)
        								d_arr_izq = new ReinaModulo(vec_reinas[h].index,diff_y);
        						}
        					}
        					else {
        						if(diff_y < 0) {
        							if(diff_y > d_ab_der.distancia)
        								d_ab_der = new ReinaModulo(vec_reinas[h].index,diff_y);
        						}
        						else {
        							if(diff_y < d_arr_der.distancia)
        								d_arr_der = new ReinaModulo(vec_reinas[h].index,diff_y);
        						}
        					}
        			}
        		}
        	}
        	
        	if(c_up.index != 0)
        		moduloLinea.add(c_up.index);
        	
        	if(c_down.index != 0)
        		moduloLinea.add(c_down.index);
        	
        	if(f_left.index != 0)
        		moduloLinea.add(f_left.index);
        	
        	if(f_right.index != 0)
        		moduloLinea.add(f_right.index);
        	
        	if(d_arr_izq.index != 0)
        		moduloLinea.add(d_arr_izq.index);
        	
        	if(d_arr_der.index != 0)
        		moduloLinea.add(d_arr_der.index);
        	
        	if(d_ab_izq.index != 0)
        		moduloLinea.add(d_ab_izq.index);
        	
        	if(d_ab_der.index != 0)
        		moduloLinea.add(d_ab_der.index);

        	System.out.println("Reina " + vec_reinas[i].index + " coincidencias: " + moduloLinea.size() + " con estas reinas: " + moduloLinea);
        	
        	salida.print(moduloLinea.size());
        	
        	for(Iterator<Integer> it = moduloLinea.iterator(); it.hasNext();) {
        		salida.print(" " + (Integer)it.next());
        	}
        	
        	salida.println();
        } 
        
     salida.close();
	
	}


	private static boolean mismaDiagonal(Reina[] vec_reinas, int i, int h) {
		return Math.abs(vec_reinas[h].x - vec_reinas[i].x) == Math.abs(vec_reinas[h].y - vec_reinas[i].y);
	}
	
}

