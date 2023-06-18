package ternilapilli;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

public class TernilapiliTest {

	@Test
	public void testCreatesBoard() {
		assertNotNull(new Ternilapilli());
	}
	
	@Test
	public void testCreatesEmptyBoard() {
		assertTrue(new Ternilapilli().isEmpty());
	}
	
	@Test 
	public void testPutXatTheRightPosition() {
	   assertEquals(1, boardWithAnXatCoord1_1().Xs.size());
	   assertTrue(boardWithAnXatCoord1_1().Xs.contains(new Coordinate( 1, 1 )));
	   }
	
	@Test 
	public void testPutOatTheRightPosition() {
	   assertEquals(1, boardWithAndXat1_1AndAnOat1_2().Xs.size());
	   assertTrue(boardWithAndXat1_1AndAnOat1_2().Xs.contains(new Coordinate( 1, 1 )));
	   assertEquals(1, boardWithAndXat1_1AndAnOat1_2().Os.size());
	   assertTrue(boardWithAndXat1_1AndAnOat1_2().Os.contains(new Coordinate( 1, 2 )));
	   }
	
   @Test 
   public void testPutMultiplePiecesAtTheRightPosition() {
	   assertEquals(3, sixPiecesBoard().Xs.size());
	   assertTrue(sixPiecesBoard().Xs.contains(new Coordinate( 0, 2 )));
	   assertTrue(sixPiecesBoard().Xs.contains(new Coordinate( 0, 0 )));
	   assertTrue(sixPiecesBoard().Xs.contains(new Coordinate( 1, 2 )));
	   
	   assertEquals(3, sixPiecesBoard().Os.size());
	   assertTrue(sixPiecesBoard().Os.contains(new Coordinate( 1, 0 )));
	   assertTrue(sixPiecesBoard().Os.contains(new Coordinate( 2, 2 )));
	   assertTrue(sixPiecesBoard().Os.contains(new Coordinate( 2, 1 )));
   }
	
	@Test
	public void testCanNotPutPieceOutOfTheBoard(){
		assertThrowsLike(Ternilapilli.CoordinateOutOfLimits,()-> new Ternilapilli().putXat(new Coordinate( 4, 1 )));
	}
	
	@Test
	public void testCanNotPutPieceOutOfTheBoardInNegatives(){
		assertThrowsLike(Ternilapilli.CoordinateOutOfLimits,()-> new Ternilapilli().putXat(new Coordinate(-4,-1)));
	}
	
	@Test
	public void testXisTheFirstoneToPlay(){
		assertThrowsLike(Ternilapilli.IncorrectTurn,()-> new Ternilapilli().putOat(new Coordinate(1,1)));
	}
	
	@Test
	public void testPutX2Times(){
		assertThrowsLike(Ternilapilli.IncorrectTurn,()-> boardWithAnXAtCoord1_0().putXat(new Coordinate(1,2)));
	}
	
	@Test
	public void testPutO2Times(){
		assertThrowsLike(Ternilapilli.IncorrectTurn,()-> boardWithAnXat1_0AndAnOat1_1().putOat(new Coordinate(1,1)));
	}
	
	@Test
	public void testTriesToPutXInOccupiedCellByX(){
		assertThrowsLike(Ternilapilli.SpaceOccupied,()-> boardWithAnXat1_0AndAnOat1_1().putXat(new Coordinate(1,0)));
	}
	
	@Test
	public void testTriesToPutXInOccupiedCellByO(){
		assertThrowsLike(Ternilapilli.SpaceOccupied,()-> boardWithAnXat1_0AndAnOat1_1().putXat(new Coordinate(1,1)));
	}
	
	@Test
   public void testTriesToPutOInOccupiedCellByO(){
	   Ternilapilli juego = boardWithAnXat1_0AndAnOat1_1();
	   juego.putXat(new Coordinate(1,2));
	   assertThrowsLike(Ternilapilli.SpaceOccupied,()-> juego.putOat(new Coordinate(1,1)));
   }
	
	@Test
   public void testTriesToPutOInOccupiedCellByX(){
	   assertThrowsLike(Ternilapilli.SpaceOccupied,()-> boardWithAnXAtCoord1_0().putOat(new Coordinate(1,0)));
   }
	
   @Test 
   public void testPutsNoMoreThan3Pieces() {
	   assertThrowsLike(Ternilapilli.AlreadyHave3Pieces,()-> sixPiecesBoard().putXat(new Coordinate(2,0)));
   }
   
   @Test
   public void testXmoves() {
	   assertTrue(sixPiecesBoardWithAnXmovedToCoord1_1().Xs.contains(new Coordinate( 1, 1 )));
	   assertFalse(sixPiecesBoardWithAnXmovedToCoord1_1().Xs.contains(new Coordinate( 1, 2 )));   
   }
   
   
   @Test
   public void testOmoves() {
	   assertTrue(sixPiecesBoardWithAnXmovedToCoord1_1AndAnOmovedToCoord1_2().Os.contains(new Coordinate( 1, 2 )));
	   assertFalse(sixPiecesBoardWithAnXmovedToCoord1_1AndAnOmovedToCoord1_2().Os.contains(new Coordinate( 2, 2 )));   
   }
   
   @Test
   public void testXmoves2times() {
	   assertThrowsLike(Ternilapilli.IncorrectTurn,
			   ()-> sixPiecesBoardWithAnXmovedToCoord1_1().moveX(new Coordinate( 1, 1 ), new Coordinate( 1, 2 )));
   }
   
   @Test
   public void testOmoves2times() {
	   assertThrowsLike(Ternilapilli.IncorrectTurn,
			   ()-> sixPiecesBoardWithAnXmovedToCoord1_1AndAnOmovedToCoord1_2().moveO(new Coordinate( 1, 2 ), new Coordinate( 2, 2 )));  
   }
   
   @Test
   public void testXmovesToAnOcuppiedSpaceByO() {
	   assertThrowsLike(Ternilapilli.SpaceOccupied,
			   ()->sixPiecesBoard().moveX(new Coordinate( 1, 2 ), new Coordinate( 2, 2 )));   
   }
   
   public void testXmovesToAnOcuppiedSpaceByX() {
	   assertThrowsLike(Ternilapilli.SpaceOccupied,
			   ()-> sixPiecesBoard().moveX(new Coordinate( 1, 2 ), new Coordinate( 0, 2 )));    
   }
   
   @Test
   public void testOmovesToAnOcuppiedSpacebyX() {
	   assertThrowsLike(Ternilapilli.SpaceOccupied,
			   ()-> sixPiecesBoardWithAnXmovedToCoord1_1().moveO(new Coordinate( 2, 2 ), new Coordinate( 1, 1 )));    
   }
   
   @Test
   public void testOmovesToAnOcuppiedSpacebyO() {
	   assertThrowsLike(Ternilapilli.SpaceOccupied,
			   ()-> sixPiecesBoardWithAnXmovedToCoord1_1().moveO(new Coordinate( 2, 2 ), new Coordinate( 2, 1 )));    
   }
   
   @Test
   public void testXmovesAndWins() {
	   assertTrue(sixPiecesBoardWithAnXmovedToCoord0_1().isWinnerX());
   }
   
   @Test
   public void testOmovesAndWins() {
	   assertTrue(sixPiecesBoardWithAnXAndAnOmoved().isWinnerO());
   }
   
   @Test
   public void testXwinsAtRow() {
       assertWinsX(boardWithRowOfXs());
   }
   
   @Test
   public void testXwinsAtColumn() {
	   assertWinsX(boardWithColumnOfXs());
   }

   @Test
   public void testXwinsAtDiagonal() {
	   assertWinsX(boardWithDiagonalOfXs());
   }
   
   @Test
   public void testOwinsAtRow() {
       assertWinsO(boardWithRowOfOs());
   }
   
   @Test
   public void testOwinsAtColumn() {
	   assertWinsO(boardWithColumnOfOs());
   }
   
   @Test
   public void testOwinsAtDiagonal() {
	   assertWinsO(boardWithDiagonalOfOs());
   }

   
   @Test
   public void testXWinsAndOtriesToPutAnewPiece() {
	   assertTrue(sixPiecesBoardWithAnXmovedToCoord0_1().isWinnerX());
	   assertThrowsLike(Ternilapilli.AlreadyHave3Pieces,()->sixPiecesBoardWithAnXmovedToCoord0_1().putOat(new Coordinate( 1, 1 )));
   }
   
   @Test
   public void testOWinsAndXtriesToPutAnewPiece() {
	   assertTrue(sixPiecesBoardWithAnXAndAnOmoved().isWinnerO());
	   assertThrowsLike(Ternilapilli.AlreadyHave3Pieces,()-> sixPiecesBoardWithAnXAndAnOmoved().putXat(new Coordinate( 1, 1 )));
   }
   
   
   @Test
   public void testXWinsAndOtriesToMove() {
	   assertTrue(sixPiecesBoardWithAnXmovedToCoord0_1().isWinnerX());
	   assertThrowsLike(Ternilapilli.CanNotMove,()-> sixPiecesBoardWithAnXmovedToCoord0_1().moveO(new Coordinate( 1, 0 ), new Coordinate( 1, 1 )));
   }
   
   @Test
   public void testOWinsAndXtriesToMove() {
	   assertTrue(sixPiecesBoardWithAnXAndAnOmoved().isWinnerO());
	   assertThrowsLike(Ternilapilli.CanNotMove,()-> sixPiecesBoardWithAnXAndAnOmoved().moveX(new Coordinate( 1, 1 ), new Coordinate( 0, 1 )));
   }
   
   
   
   public Ternilapilli sixPiecesBoard() {
	   Ternilapilli game = new Ternilapilli();
	   game.putXat( new Coordinate( 0, 2 ));
	   game.putOat( new Coordinate( 1, 0 ));
	   game.putXat( new Coordinate( 0, 0 ));
	   game.putOat( new Coordinate( 2, 2 ));
	   game.putXat( new Coordinate( 1, 2 ));
	   game.putOat( new Coordinate( 2, 1 ));
	   return game;
	}
	
	public Ternilapilli boardWithRowOfXs() {
	   Ternilapilli game= new Ternilapilli();
	   game.putXat(new Coordinate(0, 0));
       game.putOat(new Coordinate(2, 1)); 
       game.putXat(new Coordinate(1, 0));
       game.putOat(new Coordinate(1, 1));
       game.putXat(new Coordinate(2, 0));
       return game;
	}
	
	public Ternilapilli boardWithColumnOfXs() {
	   Ternilapilli game= new Ternilapilli();
	   game.putXat(new Coordinate(0, 0));
	   game.putOat(new Coordinate(2, 1)); 
	   game.putXat(new Coordinate(0, 1));
	   game.putOat(new Coordinate(1, 1));
	   game.putXat(new Coordinate(0, 2));
	   return game;
	}
	
	public Ternilapilli boardWithDiagonalOfXs() {
		Ternilapilli game= new Ternilapilli();
		game.putXat(new Coordinate(0, 0));
	    game.putOat(new Coordinate(2, 1)); 
	    game.putXat(new Coordinate(1, 1));
	    game.putOat(new Coordinate(1, 0));
	    game.putXat(new Coordinate(2, 2));
	    return game;
	}
	
	public Ternilapilli boardWithRowOfOs() {
	   Ternilapilli game= new Ternilapilli();
	   game.putXat(new Coordinate(0, 1));
       game.putOat(new Coordinate(0, 0)); 
       game.putXat(new Coordinate(1, 1));
       game.putOat(new Coordinate(1, 0));
       game.putXat(new Coordinate(2, 2));
       game.putOat(new Coordinate(2, 0));
       return game;
	}
	
	public Ternilapilli boardWithColumnOfOs() {
	   Ternilapilli game = boardWithAnXatCoord1_1();
       game.putOat(new Coordinate(0, 0)); 
       game.putXat(new Coordinate(1, 0));
       game.putOat(new Coordinate(0, 1));
       game.putXat(new Coordinate(2, 2));
       game.putOat(new Coordinate(0, 2));
       return game;
	}
	
	public Ternilapilli boardWithDiagonalOfOs() {
	   Ternilapilli game= new Ternilapilli();
	   game.putXat(new Coordinate(2, 0));
       game.putOat(new Coordinate(0, 0)); 
       game.putXat(new Coordinate(0, 1));
       game.putOat(new Coordinate(1, 1));
       game.putXat(new Coordinate(2, 1));
       game.putOat(new Coordinate(2, 2));
       return game;
	}
	
	public void assertThrowsLike(String msg, Executable codeToRun) {
		assertEquals(msg, assertThrows(Exception.class, codeToRun).getMessage());
	}
	
	public Ternilapilli boardWithAnXAtCoord1_0() {
		Ternilapilli juego= new Ternilapilli();
		juego.putXat(new Coordinate(1,0));
		return juego;
	}
	
	public Ternilapilli boardWithAnXat1_0AndAnOat1_1() {
		Ternilapilli juego = boardWithAnXAtCoord1_0();
		juego.putOat(new Coordinate(1,1));
		return juego;
	}
	
	public Ternilapilli boardWithAnXatCoord1_1() {
		Ternilapilli game = new Ternilapilli();
		game.putXat( new Coordinate( 1, 1 ));
		return game;
	}
	
	public Ternilapilli boardWithAndXat1_1AndAnOat1_2() {
		Ternilapilli game = boardWithAnXatCoord1_1();
		game.putOat( new Coordinate( 1, 2 ));
		return game;
	}

	
	public Ternilapilli sixPiecesBoardWithAnXmovedToCoord0_1() {
		Ternilapilli game = sixPiecesBoard();
		game.moveX(new Coordinate( 1, 2 ), new Coordinate( 0, 1 ));
		return game;
	}
	
	public Ternilapilli sixPiecesBoardWithAnXmovedToCoord1_1() {
		Ternilapilli game = sixPiecesBoard();
		game.moveX(new Coordinate( 1, 2 ), new Coordinate( 1, 1 ));
		return game;
	}
	
	public Ternilapilli sixPiecesBoardWithAnXmovedToCoord1_1AndAnOmovedToCoord1_2() {
		Ternilapilli game = sixPiecesBoardWithAnXmovedToCoord1_1();
		game.moveO(new Coordinate( 2, 2 ), new Coordinate( 1, 2 ));
		return game;
	}
	
	public Ternilapilli sixPiecesBoardWithAnXAndAnOmoved() {
		Ternilapilli game = sixPiecesBoardWithAnXmovedToCoord1_1();
		game.moveO(new Coordinate( 1, 0 ), new Coordinate( 2, 0 ));
		return game;
	}
	
	public void assertWinsX(Ternilapilli board) {
		assertTrue(board.isWinnerX());
	    assertFalse(board.isWinnerO());
	}
	
	public void assertWinsO(Ternilapilli board) {
		assertTrue(board.isWinnerO());
	    assertFalse(board.isWinnerX());
	}
}