package marsRover2;

public class Left extends Command{
	public Left() {
		super('l');
	}
	
	public boolean canHandle(char comando) {
		return key==comando;
	}
	
	public void executeCommand(MarsRover2 rover) {
		rover.updateRoverHeading(rover.heading.rotateLeft());
	}

}