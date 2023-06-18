package ternilapili;

import java.util.Set;

public class Over extends GameInstance{

	public void putXat(Coordinate coordinate, Set<Coordinate> Xs, Set<Coordinate> Os, Player turn) {
		throw new RuntimeException(Ternilapili.AlreadyHave3Pieces);
	}

	public void putOat(Coordinate coordinate, Set<Coordinate> Xs, Set<Coordinate> Os, Player turn) {
		throw new RuntimeException(Ternilapili.AlreadyHave3Pieces);
	}

	public void moveX(Coordinate initialCoord, Coordinate finalCoord, Set<Coordinate> Xs, Set<Coordinate> Os,Player turn) {
		throw new RuntimeException(Ternilapili.CanNotMove);
	}

	public void moveO(Coordinate initialCoord, Coordinate finalCoord, Set<Coordinate> Xs, Set<Coordinate> Os,Player turn) {
		throw new RuntimeException(Ternilapili.CanNotMove);
	}
}
