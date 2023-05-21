package marsRover2;

	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertThrows;
	import static org.junit.jupiter.api.Assertions.assertTrue;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.function.Executable;

	public class MarsRover2Test{
	private static final String Right = "r";
	private static final String Left = "l";
	private static final String Backwards = "b";
	private static final String Forward = "f";
	private static final String InvalidCommand = "comando inválido";

	@Test
		public void testCreatesARover() {
			assertRoverIsHeadingNorth(newRoverAtOriginFacingNorth());
			assertRoverIsAtCorrectCoordinates(0,0,newRoverAtOriginFacingNorth());
	}
		
		@Test public void testCreatesARoverWithNegatives() {
			assertRoverIsAtCorrectCoordinates(-1,-1,newRover(-1,-1,north()));
			assertRoverIsHeadingNorth(newRover(-1,-1,north()));
		}
		
		@Test public void testCreatesARoverWithMixedSigns() {
			assertRoverIsAtCorrectCoordinates(-1,1,newRover(-1,1,north()));
			assertRoverIsHeadingNorth(newRover(-1,1,north()));
		}
		
		@Test public void testRoverMovesWith0commands() {
			assertThrowsLike(InvalidCommand, ()->newRoverAtOriginFacingNorth().moveRover(" "));
		}
		
		
		@Test public void testInvalidCommand() {
			assertThrowsLike(InvalidCommand, ()->newRoverAtOriginFacingNorth().moveRover("FsFB"));
		}
		
		@Test public void testRoverMovesForwardWhenFacingfNorth() {
			MarsRover2 rover = newRoverAtOriginFacingNorth();
			rover.moveRover(Forward);
			assertRoverIsAtCorrectCoordinates(0,1,rover);
		}
		
		@Test public void testRoverMovesForwardWhenFacingfSouth() {
			MarsRover2 rover = newRoverAtOriginFacingSouth();
			rover.moveRover(Forward);
			assertRoverIsAtCorrectCoordinates(0,-1,rover);
		}
		
		@Test public void testRoverMovesForwardWhenFacingfEast() {
			MarsRover2 rover = newRoverAtOriginFacingEast();
			rover.moveRover(Forward);
			assertRoverIsAtCorrectCoordinates(1,0,rover);
		}
		
		@Test public void testRoverMovesForwardWhenFacingWest() {
			MarsRover2 rover = newRoverAtOriginFacingWest();
			rover.moveRover(Forward);
			assertRoverIsAtCorrectCoordinates(-1,0,rover);
		}
		
		@Test public void testRoverMovesBackwardsWhenFacingfNorth() {
			MarsRover2 rover = newRoverAtOriginFacingNorth();
			rover.moveRover(Backwards);
			assertRoverIsAtCorrectCoordinates(0,-1,rover);
		}
		
		@Test public void testRoverMovesBacwardsWhenFacingfSouth() {
			MarsRover2 rover = newRoverAtOriginFacingSouth();
			rover.moveRover(Backwards);
			assertRoverIsAtCorrectCoordinates(0,1,rover);
		}
		
		@Test public void testRoverMovesBacwardsWhenFacingfEast() {
			MarsRover2 rover = newRoverAtOriginFacingEast();
			rover.moveRover(Backwards);
			assertRoverIsAtCorrectCoordinates(-1,0,rover);
		}
		
		@Test public void testRoverMovesBackwardsWhenFacingfWest() {
			MarsRover2 rover = newRoverAtOriginFacingWest();
			rover.moveRover(Backwards);
			assertRoverIsAtCorrectCoordinates(1,0,rover);
		}
		
		
		@Test public void testRoverRotatesLeftWhenFacingNorth() {
			MarsRover2 rover = newRoverAtOriginFacingNorth();
			rover.moveRover(Left);
			assertRoverIsHeadingWest(rover);
		}
		
		@Test public void testRoverRotatesLeftWhenFacingSouth() {
			MarsRover2 rover = newRoverAtOriginFacingSouth();
			rover.moveRover(Left);
			assertRoverIsHeadingEast(rover);
		}
		
		@Test public void testRoverRotatesLeftWhenFacingEast() {
			MarsRover2 rover = newRoverAtOriginFacingEast();
			rover.moveRover(Left);
			assertRoverIsHeadingNorth(rover);
		}
		
		@Test public void testRoverRotatesLeftWhenFacingWest() {
			MarsRover2 rover = newRoverAtOriginFacingWest();
			rover.moveRover(Left);
			assertRoverIsHeadingSouth(rover);
		}
		
		
		@Test public void testRoverRotatesRightWhenFacingNorth() {
			MarsRover2 rover = newRoverAtOriginFacingNorth();
			rover.moveRover(Right);
			assertRoverIsHeadingEast(rover);
		}
		
		@Test public void testRoverRotatesRightWhenFacingSouth() {
			MarsRover2 rover = newRoverAtOriginFacingSouth();
			rover.moveRover(Right);
			assertRoverIsHeadingWest(rover);
		}
		
		@Test public void testRoverRotatesRightWhenFacingEast() {
			MarsRover2 rover = newRoverAtOriginFacingEast();
			rover.moveRover(Right);
			assertRoverIsHeadingSouth(rover);
		}
		
		@Test public void testRoverRotatesRight2TimesWhenFacingNorth() {
			MarsRover2 rover = newRoverAtOriginFacingNorth();
			rover.moveRover(Right);
			rover.moveRover(Right);
			assertRoverIsHeadingSouth(rover);
		}
		
		@Test public void testRoverRotatesRightWhenFacingWest() {
			MarsRover2 rover = newRoverAtOriginFacingWest();
			rover.moveRover(Right);
			assertRoverIsHeadingNorth(rover);
		}
		
		@Test public void testRoverMovesWithMoreThanOneCommand() {
			MarsRover2 rover = newRoverAtOriginFacingNorth();
			rover.moveRover("lfflbb");
			System.out.println(rover.position.x);
			System.out.println(rover.position.y);
			assertRoverIsAtCorrectCoordinates(-2,2,rover);
			assertRoverIsHeadingSouth(rover);
		}
		
		//methods
		
		private MarsRover2 newRover(int x, int y, Heading heading) {
			MarsRover2 rover = new MarsRover2(x,y, heading);
			return rover;
		}
		
		private MarsRover2 newRoverAtOriginFacingNorth() {
			return new MarsRover2(0,0,north());
		}
		
		private MarsRover2 newRoverAtOriginFacingSouth() {
			return new MarsRover2(0,0,south());
		}
		
		private MarsRover2 newRoverAtOriginFacingWest() {
			return new MarsRover2(0,0,west());
		}
		
		private MarsRover2 newRoverAtOriginFacingEast() {
			return new MarsRover2(0,0,east());
		}
		
		private North north() {
			return new North();
		}
		
		private South south() {
			return new South();
		}
		
		private East east() {
			return new East();
		}
		
		private West west() {
			return new West();
		}
		
		private void assertThrowsLike(String msg, Executable codeToRun) {
			assertEquals(msg, assertThrows(Exception.class, codeToRun).getMessage());
		}
		
		private void assertRoverIsHeadingNorth(MarsRover2 rover) {
			assertTrue(rover.heading instanceof North);
		}
		
		private void assertRoverIsHeadingWest(MarsRover2 rover) {
			assertTrue(rover.heading instanceof West);
		}
		
		private void assertRoverIsHeadingEast(MarsRover2 rover) {
			assertTrue(rover.heading instanceof East);
		}
		
		private void assertRoverIsHeadingSouth(MarsRover2 rover) {
			assertTrue(rover.heading instanceof South);
		}

		private void assertRoverIsAtCorrectCoordinates(int x1, int x2, MarsRover2 rover) {
			assertTrue(rover.coordinatesChecker(new Coordinates2(x1,x2), rover.position));
		}
	}