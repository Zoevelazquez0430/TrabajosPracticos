package marsRover2;

import java.util.function.Predicate;
import java.util.stream.Stream;

public abstract class Command {
	private static final String InvalidCommand = "comando inválido";
	public char key;
	
	public Command(char command) {
        this.key = command;
    }
	
	public abstract boolean canHandle(char comando);
	
	public abstract void executeCommand(MarsRover2 rover);
	
	
	public static void findForCommand(char comando, MarsRover2 rover) {
		rover.comandos.stream()
			.filter(command-> command.canHandle(comando))
			.findFirst()
			.orElseThrow(()-> new RuntimeException (InvalidCommand))
			.executeCommand(rover);
	}
	
	private static Stream<Command> filter(MarsRover2 rover, Predicate<? super Command> predicate) {
		return rover.comandos.stream().filter(predicate);
	}	
}