package conflictoentrereinas;

public class Reina {
	
	int index, x, y;

	public Reina(int index, int x, int y) {
		this.index = index;
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
        return  "Index: " + index + " x: " + x + " y: " + y;
    }

}
