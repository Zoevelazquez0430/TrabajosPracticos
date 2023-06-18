package ternilapili;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.jupiter.api.function.Executable;

public class TernilapiliTest {

	@Test
	public void testCreatesBoard() {
		assertNotNull(new Ternilapili());
	}
	
	@Test
	public void testCreatesEmptyBoard() {
		assertTrue(new Ternilapili().isEmpty());
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
		assertThrowsLike(Ternilapili.CoordinateOutOfLimits,()-> new Ternilapili().putXat(new Coordinate( 4, 1 )));
	}
	
	@Test
	public void testCanNotPutPieceOutOfTheBoardInNegatives(){
		assertThrowsLike(Ternilapili.CoordinateOutOfLimits,()-> new Ternilapili().putXat(new Coordinate(-4,-1)));
	}
	
	@Test
	public void testXisTheFirstoneToPlay(){
		assertThrowsLike(Ternilapili.IncorrectTurn,()-> new Ternilapili().putOat(new Coordinate(1,1)));
	}
	
	@Test
	public void testPutX2Times(){
		assertThrowsLike(Ternilapili.IncorrectTurn,()-> boardWithAnXAtCoord1_0().putXat(new Coordinate(1,2)));
	}
	
	@Test
	public void testPutO2Times(){
		assertThrowsLike(Ternilapili.IncorrectTurn,()-> boardWithAnXat1_0AndAnOat1_1().putOat(new Coordinate(1,1)));
	}
	
	@Test
	public void testTriesToPutXInOccupiedCellByX(){
		assertThrowsLike(Ternilapili.SpaceOccupied,()-> boardWithAnXat1_0AndAnOat1_1().putXat(new Coordinate(1,0)));
	}
	
	@Test
	public void testTriesToPutXInOccupiedCellByO(){
		assertThrowsLike(Ternilapili.SpaceOccupied,()-> boardWithAnXat1_0AndAnOat1_1().putXat(new Coordinate(1,1)));
	}
	
	@Test
   public void testTriesToPutOInOccupiedCellByO(){
	   Ternilapili juego = boardWithAnXat1_0AndAnOat1_1();
	   juego.putXat(new Coordinate(1,2));
	   assertThrowsLike(Ternilapili.SpaceOccupied,()-> juego.putOat(new Coordinate(1,1)));
   }
	
	@Test
   public void testTriesToPutOInOccupiedCellByX(){
	   assertThrowsLike(Ternilapili.SpaceOccupied,()-> boardWithAnXAtCoord1_0().putOat(new Coordinate(1,0)));
   }
	
   @Test 
   public void testPutsNoMoreThan3Pieces() {
	   assertThrowsLike(Ternilapili.AlreadyHave3Pieces,()-> sixPiecesBoard().putXat(new Coordinate(2,0)));
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
	   assertThrowsLike(Ternilapili.IncorrectTurn,
			   ()-> sixPiecesBoardWithAnXmovedToCoord1_1().moveX(new Coordinate( 1, 1 ), new Coordinate( 1, 2 )));
   }
   
   @Test
   public void testOmoves2times() {
	   assertThrowsLike(Ternilapili.IncorrectTurn,
			   ()-> sixPiecesBoardWithAnXmovedToCoord1_1AndAnOmovedToCoord1_2().moveO(new Coordinate( 1, 2 ), new Coordinate( 2, 2 )));  
   }
   
   @Test
   public void testXmovesToAnOcuppiedSpaceByO() {
	   assertThrowsLike(Ternilapili.SpaceOccupied,
			   ()->sixPiecesBoard().moveX(new Coordinate( 1, 2 ), new Coordinate( 2, 2 )));   
   }
   
   public void testXmovesToAnOcuppiedSpaceByX() {
	   assertThrowsLike(Ternilapili.SpaceOccupied,
			   ()-> sixPiecesBoard().moveX(new Coordinate( 1, 2 ), new Coordinate( 0, 2 )));    
   }
   
   @Test
   public void testOmovesToAnOcuppiedSpacebyX() {
	   assertThrowsLike(Ternilapili.SpaceOccupied,
			   ()-> sixPiecesBoardWithAnXmovedToCoord1_1().moveO(new Coordinate( 2, 2 ), new Coordinate( 1, 1 )));    
   }
   
   @Test
   public void testOmovesToAnOcuppiedSpacebyO() {
	   assertThrowsLike(Ternilapili.SpaceOccupied,
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
	   assertThrowsLike(Ternilapili.AlreadyHave3Pieces,()->sixPiecesBoardWithAnXmovedToCoord0_1().putOat(new Coordinate( 1, 1 )));
   }
   
   @Test
   public void testOWinsAndXtriesToPutAnewPiece() {
	   assertTrue(sixPiecesBoardWithAnXAndAnOmoved().isWinnerO());
	   assertThrowsLike(Ternilapili.AlreadyHave3Pieces,()-> sixPiecesBoardWithAnXAndAnOmoved().putXat(new Coordinate( 1, 1 )));
   }
   
   
   @Test
   public void testXWinsAndOtriesToMove() {
	   assertTrue(sixPiecesBoardWithAnXmovedToCoord0_1().isWinnerX());
	   assertThrowsLike(Ternilapili.CanNotMove,()-> sixPiecesBoardWithAnXmovedToCoord0_1().moveO(new Coordinate( 1, 0 ), new Coordinate( 1, 1 )));
   }
   
   @Test
   public void testOWinsAndXtriesToMove() {
	   assertTrue(sixPiecesBoardWithAnXAndAnOmoved().isWinnerO());
	   assertThrowsLike(Ternilapili.CanNotMove,()-> sixPiecesBoardWithAnXAndAnOmoved().moveX(new Coordinate( 1, 1 ), new Coordinate( 0, 1 )));
   }
   
   
   
   public Ternilapili sixPiecesBoard() {
	   Ternilapili game = new Ternilapili();
	   game.putXat( new Coordinate( 0, 2 ));
	   game.putOat( new Coordinate( 1, 0 ));
	   game.putXat( new Coordinate( 0, 0 ));
	   game.putOat( new Coordinate( 2, 2 ));
	   game.putXat( new Coordinate( 1, 2 ));
	   game.putOat( new Coordinate( 2, 1 ));
	   return game;
	}
	
	public Ternilapili boardWithRowOfXs() {
	   Ternilapili game= new Ternilapili();
	   game.putXat(new Coordinate(0, 0));
       game.putOat(new Coordinate(2, 1)); 
       game.putXat(new Coordinate(1, 0));
       game.putOat(new Coordinate(1, 1));
       game.putXat(new Coordinate(2, 0));
       return game;
	}
	
	public Ternilapili boardWithColumnOfXs() {
	   Ternilapili game= new Ternilapili();
	   game.putXat(new Coordinate(0, 0));
	   game.putOat(new Coordinate(2, 1)); 
	   game.putXat(new Coordinate(0, 1));
	   game.putOat(new Coordinate(1, 1));
	   game.putXat(new Coordinate(0, 2));
	   return game;
	}
	
	public Ternilapili boardWithDiagonalOfXs() {
		Ternilapili game= new Ternilapili();
		game.putXat(new Coordinate(0, 0));
	    game.putOat(new Coordinate(2, 1)); 
	    game.putXat(new Coordinate(1, 1));
	    game.putOat(new Coordinate(1, 0));
	    game.putXat(new Coordinate(2, 2));
	    return game;
	}
	
	public Ternilapili boardWithRowOfOs() {
	   Ternilapili game= new Ternilapili();
	   game.putXat(new Coordinate(0, 1));
       game.putOat(new Coordinate(0, 0)); 
       game.putXat(new Coordinate(1, 1));
       game.putOat(new Coordinate(1, 0));
       game.putXat(new Coordinate(2, 2));
       game.putOat(new Coordinate(2, 0));
       return game;
	}
	
	public Ternilapili boardWithColumnOfOs() {
	   Ternilapili game = boardWithAnXatCoord1_1();
       game.putOat(new Coordinate(0, 0)); 
       game.putXat(new Coordinate(1, 0));
       game.putOat(new Coordinate(0, 1));
       game.putXat(new Coordinate(2, 2));
       game.putOat(new Coordinate(0, 2));
       return game;
	}
	
	public Ternilapili boardWithDiagonalOfOs() {
	   Ternilapili game= new Ternilapili();
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
	
	public Ternilapili boardWithAnXAtCoord1_0() {
		Ternilapili juego= new Ternilapili();
		juego.putXat(new Coordinate(1,0));
		return juego;
	}
	
	public Ternilapili boardWithAnXat1_0AndAnOat1_1() {
		Ternilapili juego = boardWithAnXAtCoord1_0();
		juego.putOat(new Coordinate(1,1));
		return juego;
	}
	
	public Ternilapili boardWithAnXatCoord1_1() {
		Ternilapili game = new Ternilapili();
		game.putXat( new Coordinate( 1, 1 ));
		return game;
	}
	
	public Ternilapili boardWithAndXat1_1AndAnOat1_2() {
		Ternilapili game = boardWithAnXatCoord1_1();
		game.putOat( new Coordinate( 1, 2 ));
		return game;
	}

	
	public Ternilapili sixPiecesBoardWithAnXmovedToCoord0_1() {
		Ternilapili game = sixPiecesBoard();
		game.moveX(new Coordinate( 1, 2 ), new Coordinate( 0, 1 ));
		return game;
	}
	
	public Ternilapili sixPiecesBoardWithAnXmovedToCoord1_1() {
		Ternilapili game = sixPiecesBoard();
		game.moveX(new Coordinate( 1, 2 ), new Coordinate( 1, 1 ));
		return game;
	}
	
	public Ternilapili sixPiecesBoardWithAnXmovedToCoord1_1AndAnOmovedToCoord1_2() {
		Ternilapili game = sixPiecesBoardWithAnXmovedToCoord1_1();
		game.moveO(new Coordinate( 2, 2 ), new Coordinate( 1, 2 ));
		return game;
	}
	
	public Ternilapili sixPiecesBoardWithAnXAndAnOmoved() {
		Ternilapili game = sixPiecesBoardWithAnXmovedToCoord1_1();
		game.moveO(new Coordinate( 1, 0 ), new Coordinate( 2, 0 ));
		return game;
	}
	
	public void assertWinsX(Ternilapili board) {
		assertTrue(board.isWinnerX());
	    assertFalse(board.isWinnerO());
	}
	
	public void assertWinsO(Ternilapili board) {
		assertTrue(board.isWinnerO());
	    assertFalse(board.isWinnerX());
	}
}