import static org.junit.Assert.*;

import org.junit.Test;

import sourcecode.Astar;
import sourcecode.Maze;
import sourcecode.MazeNode;

import cost.Cost;
import cost.Manhattan;

import java.util.Random;

public class TestMazeConstruction {
	//checks random size maze each time
    Random generator = new Random();
    int my_rand = generator.nextInt(4) + 1;
    int rows = my_rand * 100;
	int columns = my_rand * 100;
	MazeNode start = new MazeNode(0, 0);
	MazeNode finish = new MazeNode(rows-1, columns-1);
	Maze testMaze = new Maze(rows, columns, start, finish);
	Astar AStar = new Astar();
	Cost calc = new Manhattan();

	//tests Maze Constructor and all of its private functions
	@Test
	public void testSuccessfullyConstructedMaze() throws Exception {
		int totalNodes = rows * columns;

		assertEquals(rows, testMaze.getRows());
		assertEquals(columns, testMaze.getColumns());

		int numberOfNodes = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(testMaze.getNode(i, j) != null)
					numberOfNodes++;
			}
		}
		assertEquals(totalNodes, numberOfNodes);

	}

	@Test
	public void checkStartAndFinish() {
		assertNotNull(testMaze.getStartNode());
		assertNotNull(testMaze.getEndNode());
		if(testMaze.getStartNode() == testMaze.getEndNode()) {
			fail();
		}
	}
	
	@Test
	public void checkBounds() {
		if(testMaze.getStartNode().getxPositionInMaze() < 0 ||
				testMaze.getStartNode().getxPositionInMaze() >= rows) {
			fail();
		}
		if(testMaze.getStartNode().getyPositionInMaze() < 0 ||
				testMaze.getStartNode().getyPositionInMaze() >= columns) {
			fail();
		}
		if(testMaze.getEndNode().getxPositionInMaze() < 0 ||
				testMaze.getEndNode().getxPositionInMaze() >= rows) {
			fail();
		}
		if(testMaze.getEndNode().getyPositionInMaze() < 0 ||
				testMaze.getEndNode().getyPositionInMaze() >= columns) {
			fail();
		}
	}
	
	@Test
	public void testInvalidMazeSize() throws Exception {
		Maze invalidMaze = new Maze(0, 0, start, finish);
		assertEquals(0, invalidMaze.getRows());
		assertEquals(0, invalidMaze.getColumns());
		
		Maze invalidMaze1 = new Maze(-1, -1, start, finish);
		assertEquals(-1, invalidMaze1.getRows());
		assertEquals(-1, invalidMaze1.getColumns());
	}
	
	@Test
	public void testIfTraversable() { //change after passing in walls
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				if(!(testMaze.getNode(i, j).isTraversable())) {
					System.out.print(testMaze.getNode(i, j).getxPositionInMaze());
					System.out.print(testMaze.getNode(i, j).getyPositionInMaze());
				}
			} //end j loop
		} //end i loop
	}
	
	@Test
	public void testIfStartOrEnd() {
		assertEquals(testMaze.getStartNode().getxPositionInMaze(), start.getxPositionInMaze());
		assertEquals(testMaze.getStartNode().getyPositionInMaze(), start.getyPositionInMaze());
		assertEquals(testMaze.getEndNode().getxPositionInMaze(), finish.getxPositionInMaze());
		assertEquals(testMaze.getEndNode().getyPositionInMaze(), finish.getyPositionInMaze());
	}
	
	@Test
	public void testIfReachedGoal() {
		AStar.findPath(testMaze, calc);
		assertEquals(AStar.getFoundEnd(), true);
	}
}