package marsRover2;

public class West extends Heading{
	
	public Coordinates2 moveForward() {
		return new Coordinates2 (-1,0);
	}
	
	public Coordinates2 moveBackwards() {
		return new Coordinates2(1,0);
	}
	
	public Heading rotateLeft() {
		return new South();
	}
	
	public Heading rotateRight() {
		return new North();
	}
}