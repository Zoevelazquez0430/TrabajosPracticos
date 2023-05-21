package marsRover2;

public class Backwards extends Command{
	public Backwards() {
		super('b');
	}
	
	public boolean canHandle(char comando) {
		return key==comando;
	}
	
	public void executeCommand(MarsRover2 rover) {
		rover.position.updateCoordinates(rover.heading.moveBackwards());
	}
}
