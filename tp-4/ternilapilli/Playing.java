package ternilapilli;

import java.util.Set;

public class Playing extends GameInstance{

	public void putXat(Coordinate coordinate, Set<Coordinate> Xs, Set<Coordinate> Os, Player turn) {
		throw new RuntimeException(Ternilapilli.AlreadyHave3Pieces);
		
	}

	public void putOat(Coordinate coordinate, Set<Coordinate> Xs, Set<Coordinate> Os, Player turn) {
		throw new RuntimeException(Ternilapilli.AlreadyHave3Pieces);
	}

	public void moveX(Coordinate initialCoord, Coordinate finalCoord, Set<Coordinate> Xs, Set<Coordinate> Os,Player turn) {
		if(turn.isPlayingO()) {
			throw new RuntimeException(Ternilapilli.IncorrectTurn);
		}
	    pieceMover(initialCoord, finalCoord, Xs, Os);
	}

	public void moveO(Coordinate initialCoord, Coordinate finalCoord, Set<Coordinate> Xs, Set<Coordinate> Os,Player turn) {
    	if(turn.isPlayingX()) {
			throw new RuntimeException(Ternilapilli.IncorrectTurn);
		}
    	 pieceMover(initialCoord, finalCoord, Os, Xs);
	}
	
	public void pieceMover(Coordinate initialCoord, Coordinate finalCoord, Set<Coordinate> list1, Set<Coordinate> list2) {
		if (!list1.contains(initialCoord)) {
	        throw new RuntimeException(Ternilapilli.NoPieceAtTheGivenCoordinate);
	    }
	    if (list1.contains(finalCoord)||list2.contains(finalCoord)) {
	        throw new RuntimeException(Ternilapilli.SpaceOccupied);
	    }
        if (Coordinate.calculateDistance(initialCoord, finalCoord) != 1) {
            throw new RuntimeException(Ternilapilli.InvalidMove);
        }
        list1.remove(initialCoord);
        list1.add(finalCoord);
	}

}
