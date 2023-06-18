package ternilapilli;

import java.util.Objects;

public class Coordinate {
	public int row;
	public int column;

	public Coordinate(int i, int j) {
		if((i>=3) || (j>=3) || (i<0) || (j<0)){
			throw new RuntimeException(Ternilapilli.CoordinateOutOfLimits);
		}
		row = i;
		column = j;
	}
	
	public static int calculateDistance(Coordinate coord1, Coordinate coord2) {
	    int rowDiff = Math.abs(coord1.row - coord2.row);
	    int columnDiff = Math.abs(coord1.column - coord2.column);
	    if (rowDiff == columnDiff) {
	        return rowDiff;
	    }
	    return Math.max(rowDiff, columnDiff);
	}
	
	public boolean equals(Object obj) {
		Coordinate position = (Coordinate) obj;
		return row == position.row && column == position.column;
	}
	
	public int hashCode() {
		return Objects.hash(row, column);
	}
}

