package marsRover2;

public class Coordinates2 {
	public int x,y;

	public Coordinates2(int x, int y) {
		this.x = x;
        this.y = y;
	}
	
	 public boolean equals(Coordinates2 coordinate) {
		 if (this == coordinate) {
			 return true;
		 }
		 if (coordinate == null || getClass()!= coordinate.getClass()) {
			 return false;
		 }
		 Coordinates2 other = (Coordinates2) coordinate;
		 return x == other.x && y == other.y;
	 }
	 
	 public static boolean areEqual(Coordinates2 cord1, Coordinates2 cord2) {
		 if (cord1==cord2) {
			 return true;
		 }
		 if (cord1==null || cord2==null) {
			 return false;
		 }
		 return cord1.equals(cord2);
	 }
	 
	 public void updateCoordinates(Coordinates2 cord) {
		 x= x+ cord.x;
		 y= y+ cord.y; 
	 } 
}