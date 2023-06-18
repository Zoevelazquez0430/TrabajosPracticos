package ternilapili;

import java.util.Set;

public class Beginning extends GameInstance{

	public void putXat(Coordinate coordinate, Set<Coordinate> Xs, Set<Coordinate> Os, Player turn) {
		if(turn.isPlayingO()) {
			throw new RuntimeException(Ternilapili.IncorrectTurn);
		}
		pieceLocator(coordinate,Os,Xs);
	}

	public void putOat(Coordinate coordinate, Set<Coordinate> Xs, Set<Coordinate> Os, Player turn) {
		if(turn.isPlayingX()) {
			throw new RuntimeException(Ternilapili.IncorrectTurn);
		}
		pieceLocator(coordinate, Xs, Os);
	}

	public void moveX(Coordinate initialCoord, Coordinate finalCoord, Set<Coordinate> Xs, Set<Coordinate> Os,Player turn) {
		throw new RuntimeException(Ternilapili.CanNotMove);
	}

	public void moveO(Coordinate initialCoord, Coordinate finalCoord, Set<Coordinate> Xs, Set<Coordinate> Os,Player turn) {
		throw new RuntimeException(Ternilapili.CanNotMove);
	}
	
	
	public void pieceLocator(Coordinate coordinate, Set<Coordinate> list1, Set<Coordinate> list2) {
		if(list1.contains(coordinate)||list2.contains(coordinate)) {
			throw new RuntimeException(Ternilapili.SpaceOccupied);
		}
		list2.add(coordinate);
	}
}

