package marsRover2;

public class North extends Heading{
	public Coordinates2 moveForward() {
		return new Coordinates2 (0,1);
	}
	public Coordinates2 moveBackwards() {
		return new Coordinates2(0,-1);
	}
	
	public Heading rotateLeft() {
		return new West();
	}
	
	public Heading rotateRight() {
		return new East();
	}
}