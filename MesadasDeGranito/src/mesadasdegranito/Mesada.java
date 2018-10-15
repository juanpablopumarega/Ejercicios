package mesadasdegranito;

public class Mesada implements Comparable<Mesada> {
	
	int largo;
	int ancho;

	public Mesada(int largo, int ancho) {
		this.largo = largo;
		this.ancho = ancho;
	}

	//Metodo compareTo para ordenar en forma descendente por ancho
	public int compareTo(Mesada otro) {
		
		if(this.largo == otro.largo && this.ancho == otro.ancho)
			return 0;
		
		if(this.largo > otro.largo)
			return -1;
		
		if(this.largo == otro.largo) {
			if(this.ancho > otro.ancho)
				return -1;
			else 
				return 1;
		}
		else 
			return 1;
	
	}

	public String toString() {
		return largo + " " + ancho;
	}
	
	//Metodo para rotar mesada (intercambiar ancho con largo si cumplen condicion)
	public void rotarMesada() {
		if(this.largo < this.ancho) {
			int aux = this.largo;
			this.largo = this.ancho;
			this.ancho = aux;
		}
	}
	
	//Metodo que me devuelve True si la mesada se puede apilar con la que viene por parametro.
	public boolean esAplilable(Mesada otro) {
		if(this.largo >= otro.largo && this.ancho >= otro.ancho)
			return true;
		else
			return false;
	}
	


}
