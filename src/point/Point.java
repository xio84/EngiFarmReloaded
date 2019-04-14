package point;

public class Point {
	private int x;
	private int y;
	public Point() {
		x = 0;
		y = 0;
	}
	public Point(int _x, int _y) {
		x = _x;
		y = _y;
	}
	public int getX() {return x;}
	public int getY() {return y;}
	public void setX(int _x) {x = _x;}
	public void setY(int _y) {y = _y;}
	public String toString() {
		return "[" + x + ", " + y + "]";
	}
	public static void main(String args[]){
		Point multidimensional_array_of_point[][] = new Point[5][6]; 
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				multidimensional_array_of_point[i][j] = new Point();
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.println("multidimensional_array_of_point["+(i+1)+"]["+(j+1)+"]");
				System.out.println(multidimensional_array_of_point[i][j]);
			}
		}
	}
}
