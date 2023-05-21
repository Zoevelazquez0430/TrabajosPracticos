package marsRover2;

public class South extends Heading{
	public Coordinates2 moveForward() {
		return new Coordinates2 (0,-1);
	}
	
	public Coordinates2 moveBackwards() {
		return new Coordinates2(0,1);
	}
	
	public Heading rotateLeft() {
		return new East();
	}
	
	public Heading rotateRight() {
		return new West();
	}
}