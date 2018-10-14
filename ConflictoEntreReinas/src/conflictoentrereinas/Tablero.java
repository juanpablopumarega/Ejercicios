package conflictoentrereinas;

import java.util.ArrayList;
import java.util.TreeSet;

public class Tablero {

	int tablero;
	Reina[] reinas;
	
	public Tablero(int tablero, Reina[] reinas) {
		this.tablero = tablero;
		this.reinas = reinas;
	}
	
	public ArrayList<TreeSet<Integer>> resolverConflictos() {
		
		int longitud = this.reinas.length;
		
		ArrayList<TreeSet<Integer>> m = new ArrayList<TreeSet<Integer>>();
		
		
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
				
        		if(reinas[h].index != reinas[i].index) {

        			//verifico misma fila/columna
        			if(reinas[h].x == reinas[i].x) {
        				int diff = reinas[i].y - reinas[h].y;
        				if(diff<0) {
        					if(diff > c_up.distancia) //verifico si la diferencia es mas pequeña que la anterior comparada
        						c_up = new ReinaModulo(reinas[h].index,diff);
        				}
        				else {
        					if(diff < c_down.distancia) //verifico si la diferencia es mas pequeña que la anterior comparada
        						c_down = new ReinaModulo(reinas[h].index,diff);
        				}
        			}
        			else {
        				if(reinas[h].y == reinas[i].y) {
        					int diff = reinas[i].x - reinas[h].x;
        					if(diff<0) {
        						if(diff > f_right.distancia) //verifico si la diferencia es mas pequeña que la anterior comparada
        							f_right = new ReinaModulo(reinas[h].index,diff);
        					}
        					else {
        						if(diff < f_left.distancia) //verifico si la diferencia es mas pequeña que la anterior comparada
        							f_left = new ReinaModulo(reinas[h].index,diff);
        					}
        				}
	
        			}
        			
        			//verifico misma Diagonal
        			if(mismaDiagonal(reinas, i, h)) {
        				int diff_x = reinas[h].x - reinas[i].x;
        				int diff_y = reinas[h].y - reinas[i].y;
        					if(diff_x < 0) {
        						if(diff_y < 0) {
        							if(diff_y > d_ab_izq.distancia)
        								d_ab_izq = new ReinaModulo(reinas[h].index,diff_y);
        							//d_ab_izq = diff_y > d_ab_izq.distancia ? new ReinaModulo(reinas[h].index,diff_y) : d_ab_izq;
        						}
        						else {
        							if(diff_y < d_arr_izq.distancia)
        								d_arr_izq = new ReinaModulo(reinas[h].index,diff_y);
        						}
        					}
        					else {
        						if(diff_y < 0) {
        							if(diff_y > d_ab_der.distancia)
        								d_ab_der = new ReinaModulo(reinas[h].index,diff_y);
        						}
        						else {
        							if(diff_y < d_arr_der.distancia)
        								d_arr_der = new ReinaModulo(reinas[h].index,diff_y);
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
        	   
        	
        	m.add(moduloLinea);

        }
  
		return m;
	
	}
	
	
	private static boolean mismaDiagonal(Reina[] reinas, int i, int h) {
		return Math.abs(reinas[h].x - reinas[i].x) == Math.abs(reinas[h].y - reinas[i].y);
	}
	
}
