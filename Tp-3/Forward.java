package marsRover2;

public class Forward extends Command{
	public Forward() {
		super('f');
	}
	
	public boolean canHandle(char comando) {
		return key==comando;
	}
	
	public void executeCommand(MarsRover2 rover) {
		rover.position.updateCoordinates(rover.heading.moveForward());
	}
}