package marsRover2;

public abstract class Heading {

	public abstract Coordinates2 moveForward();
	
	public abstract Coordinates2 moveBackwards();
	
	public abstract Heading rotateLeft();
	
	public abstract Heading rotateRight();
	
}