package ternilapili;

import java.util.Set;

public class Moving extends GameInstance{

	public void putXat(Coordinate coordinate, Set<Coordinate> Xs, Set<Coordinate> Os, Player turn) {
		throw new RuntimeException(Ternilapili.AlreadyHave3Pieces);
		
	}

	public void putOat(Coordinate coordinate, Set<Coordinate> Xs, Set<Coordinate> Os, Player turn) {
		throw new RuntimeException(Ternilapili.AlreadyHave3Pieces);
	}

	public void moveX(Coordinate initialCoord, Coordinate finalCoord, Set<Coordinate> Xs, Set<Coordinate> Os,Player turn) {
		if(turn.isPlayingO()) {
			throw new RuntimeException(Ternilapili.IncorrectTurn);
		}
	    pieceMover(initialCoord, finalCoord, Xs, Os);
	}

	public void moveO(Coordinate initialCoord, Coordinate finalCoord, Set<Coordinate> Xs, Set<Coordinate> Os,Player turn) {
    	if(turn.isPlayingX()) {
			throw new RuntimeException(Ternilapili.IncorrectTurn);
		}
    	 pieceMover(initialCoord, finalCoord, Os, Xs);
	}
	
	public void pieceMover(Coordinate initialCoord, Coordinate finalCoord, Set<Coordinate> list1, Set<Coordinate> list2) {
		if (!list1.contains(initialCoord)) {
	        throw new RuntimeException(Ternilapili.NoPieceAtTheGivenCoordinate);
	    }
	    if (list1.contains(finalCoord)||list2.contains(finalCoord)) {
	        throw new RuntimeException(Ternilapili.SpaceOccupied);
	    }
        if (Coordinate.calculateDistance(initialCoord, finalCoord) != 1) {
            throw new RuntimeException(Ternilapili.InvalidMove);
        }
        list1.remove(initialCoord);
        list1.add(finalCoord);
	}

}
