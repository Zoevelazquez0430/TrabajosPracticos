package ternilapili;
import java.util.Set;
import java.util.HashSet;

public class Ternilapili {
	public static String AlreadyHave3Pieces = "You already have 3 pieces!";
	public static String CoordinateOutOfLimits = "Coordinate out of the limits";
	public static String SpaceOccupied = "That space is already occupied";
	public static String IncorrectTurn = "Not your turn";
	public static String CanNotMove = "Can't move";
	public static String NoPieceAtTheGivenCoordinate = "There is no piece at the initial coordinate";
	public static String InvalidMove = "Invalid move";
	
	public Set<Coordinate> Xs;
	public Set<Coordinate> Os;
	
	public GameInstance gameInstance;
	public Player turn= new PlayerX();
	

	public Ternilapili() {
		Xs= new HashSet<>();
		Os= new HashSet<>();
		gameInstance = new Beginning();
	}
	
	public Set<Coordinate> getXs() {
		return Xs;
	}

	public Set<Coordinate> getOs() {
		return Os;
	}

	
	public GameInstance instanceChecker() {
	    if ((Os.size() == 3 && Xs.size() == 3)&&(!(isWinnerX() || isWinnerO()))) {
	        return gameInstance = new Moving();
	    }
	    if ((isWinnerX() || isWinnerO())) {
	        return gameInstance = new Over();
	    }
	    return gameInstance;
	}

	
    public void putXat(Coordinate coordinate) {
        gameInstance.putXat(coordinate, Xs, Os, turn);
        turn= turn.playsO();
        gameInstance= instanceChecker();
    }

    public void putOat(Coordinate coordinate) {
        gameInstance.putOat(coordinate, Xs, Os, turn);
        turn= turn.playsX();
        gameInstance= instanceChecker();
    }

    public void moveX(Coordinate initialCoord, Coordinate finalCoord) {
        gameInstance.moveX(initialCoord, finalCoord, Xs, Os, turn);
        turn= turn.playsO();
        gameInstance= instanceChecker();
    }

    public void moveO(Coordinate initialCoord, Coordinate finalCoord) {
    	gameInstance.moveO(initialCoord, finalCoord, Xs, Os, turn);
    	turn= turn.playsX();
    	gameInstance= instanceChecker();
    }

	
	public boolean isEmpty() {
		return (Xs.size()==0) && (Os.size()==0);
	}
	
	public boolean isWinnerX() {
		return XhasCompletedRow() || XhasCompletedColumn() || XhasCompletedDiagonal();
	}
	
	public boolean isWinnerO() {
		return OhasCompletedRow() || OhasCompletedColumn() || OhasCompletedDiagonal();
	}
	
	public boolean XhasCompletedRow() {
		return linesChecker(Xs);
	}
	
	public boolean OhasCompletedRow() {
		return linesChecker(Os);
	}
	
	public boolean XhasCompletedColumn() {
	    return linesChecker(Xs);
	}
	
	public boolean OhasCompletedColumn() {
	    return linesChecker(Os);
	}
	
	public boolean XhasCompletedDiagonal() {
	    return diagonalChecker(Xs);
	}
	public boolean OhasCompletedDiagonal() {
	    return diagonalChecker(Os);
	}

	
	public boolean linesChecker(Set<Coordinate> lista) {
		for (int i = 0; i < 3; i++) {
	        int Observable = i;
	        if (lista.stream().filter(p -> p.row == Observable).count() == 3) {
	            return true;
	        }
	        if (lista.stream().filter(p -> p.column == Observable).count() == 3) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public boolean diagonalChecker(Set<Coordinate> lista) {
		boolean diagonal1 = lista.contains(new Coordinate(0, 0))
	            && lista.contains(new Coordinate(1, 1))
	            && lista.contains(new Coordinate(2, 2));

	    boolean diagonal2 = Xs.contains(new Coordinate(0, 2))
	            && lista.contains(new Coordinate(1, 1))
	            && lista.contains(new Coordinate(2, 0));

	    return diagonal1 || diagonal2;
	}
}