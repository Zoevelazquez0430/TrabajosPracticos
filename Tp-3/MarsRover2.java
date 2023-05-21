package marsRover2;
import java.util.ArrayList;
import java.util.List;

public class MarsRover2 {
	public Coordinates2 position;
	public Heading heading;
	public List <Command> comandos= new ArrayList<>(List.of(new Forward(), new Backwards(), new Left(), new Right()));
	
	public MarsRover2(int x, int y, Heading heading) {
	        this.heading = heading;
	        position = new Coordinates2(x,y);
	}
	
	public boolean coordinatesChecker(Coordinates2 coordinate1, Coordinates2 coordinate2) {
		return Coordinates2.areEqual(coordinate1, coordinate2);
	}
	
	public void moveRover(String comando) {
		for (int i=0;i<comando.length();i++) {
			char commandChar=comando.charAt(i);
			Command.findForCommand(commandChar, this);
		}	
	}
	
	public Heading updateRoverHeading(Heading newHeading) {
		return heading= newHeading;
	}
}