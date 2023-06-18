package ternilapilli;

import java.util.Set;

public abstract class GameInstance {
	public abstract void putXat(Coordinate coordinate, Set<Coordinate> Xs, Set<Coordinate> Os, Player turn);
	public abstract void putOat(Coordinate coordinate, Set<Coordinate> Xs, Set<Coordinate> Os, Player turn);
	public abstract void moveX(Coordinate initialCoord, Coordinate finalCoord, Set<Coordinate> Xs, Set<Coordinate> Os, Player turn);
	public abstract void moveO(Coordinate initialCoord, Coordinate finalCoord, Set<Coordinate> Xs, Set<Coordinate> Os, Player turn);

}