package ar.edu.uno.poo1.proyecto_pacman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMaze {

	private Maze maze;

	@Before
	public void setUp() {
		maze = new Maze(5, 5);
	}

	@After
	public void tearDown() {
		assertThereIsExactlyOnePacMan();
	}

	@Test
	public void testPacManLooksUpInCenterOfMaze() {
		assertTrue(maze.isPacManAt(2, 2));
		assertTrue(maze.isPacManLookingUp());
	}

	@Test
	public void testPacManMovesUp() {
		maze.tick();
		assertTrue(maze.isPacManAt(1, 2));
		assertTrue(maze.isPacManLookingUp());
		assertTrue(maze.isEmptyAt(2, 2));
	}

	@Test
	public void testPacManWrapsAroundWhenAtTop() {
		maze.tick();
		maze.tick();
		maze.tick();
		assertTrue(maze.isPacManAt(4, 2));
		assertTrue(maze.isPacManLookingUp());
		assertTrue(maze.isEmptyAt(2, 2));
		assertTrue(maze.isEmptyAt(1, 2));
		assertTrue(maze.isEmptyAt(0, 2));
	}

	@Test
	public void testTickLeftTickCheck() {
		maze.tick();
		maze.pacManLeft();
		maze.tick();
		assertTrue(maze.isPacManAt(1, 1));
		assertTrue(maze.isPacManLookingLeft());
	}

	@Test
	public void testPacManMovesUpAndBackAgain() {
		maze.pacManDown();
		maze.tick();
		assertTrue(maze.isPacManAt(3, 2));
		assertTrue(maze.isPacManLookingDown());
	}

	@Test
	public void testPacManMovesLeftAndBackAgain() {
		maze.pacManLeft();
		maze.tick();
		maze.pacManRight();
		maze.tick();
		assertTrue(maze.isPacManAt(2, 2));
		assertTrue(maze.isPacManLookingRight());
	}

	@Test
	public void testPacManChangesDirectionLeft() {
		maze.pacManLeft();
		assertTrue(maze.isPacManAt(2, 2));
		assertTrue(maze.isPacManLookingLeft());
	}

	@Test
	public void testPacManMovesLeft() {
		maze.pacManLeft();
		maze.tick();
		assertTrue(maze.isPacManAt(2, 1));
		assertTrue(maze.isPacManLookingLeft());
		assertTrue(maze.isEmptyAt(2, 2));
	}

	@Test
	public void testPacManWrapsAroundLeft() {
		maze.pacManLeft();
		maze.tick();
		maze.tick();
		maze.tick();
		assertTrue(maze.isPacManAt(2, 4));
		assertTrue(maze.isPacManLookingLeft());
		assertTrue(maze.isEmptyAt(2, 2));
		assertTrue(maze.isEmptyAt(2, 1));
		assertTrue(maze.isEmptyAt(2, 0));
	}

	@Test
	public void testPacManChangesDirectionDown() {
		maze.pacManDown();
		assertTrue(maze.isPacManAt(2, 2));
		assertTrue(maze.isPacManLookingDown());
	}

	@Test
	public void testPacManChangesDirectionRight() {
		maze.pacManRight();
		assertTrue(maze.isPacManAt(2, 2));
		assertTrue(maze.isPacManLookingRight());
	}

	@Test
	public void testPacManChangesDirectionUp() {
		maze.pacManDown();
		maze.pacManUp();
		assertTrue(maze.isPacManAt(2, 2));
		assertTrue(maze.isPacManLookingUp());
	}

	private void assertThereIsExactlyOnePacMan() {
		int pacmans = 0;
		for (int row = 0; row < maze.getRows(); row++)
			for (int column = 0; column < maze.getColumns(); column++)
				if (maze.isPacManAt(row, column))
					pacmans++;
		assertEquals(1, pacmans);
	}

}