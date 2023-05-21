package marsRover2;

public class Right extends Command{
	public Right() {
		super('r');
	}
	
	public boolean canHandle(char comando) {
		return key==comando;
	}
	
	public void executeCommand(MarsRover2 rover) {
		rover.updateRoverHeading(rover.heading.rotateRight());
	}
}