import static org.junit.Assert.*;


import org.junit.Test;

import sourcecode.Astar;
import sourcecode.Maze;
import sourcecode.MazeNode;

import cost.Cost;
import cost.Diagonal;
import cost.Euclidean;
import cost.Manhattan;




public class TestMazeComputation {
	MazeNode start = new MazeNode(0, 0);
	MazeNode finish = new MazeNode(9, 9);
	Maze testMaze = new Maze(10, 10, start, finish);
	Astar AStar = new Astar();
	Cost calc = new Manhattan();

	
	@Test
	public void testAdjPositionComputation() {
		AStar.findPath(testMaze, calc);
		assertEquals(testMaze.getNode(0, 0).getAdjNodes().contains(testMaze.getNode(0, 1)), true);
		assertEquals(testMaze.getNode(0, 0).getAdjNodes().contains(testMaze.getNode(1, 1)), true);
		assertEquals(testMaze.getNode(0, 0).getAdjNodes().contains(testMaze.getNode(1, 0)), true);
	}

	@Test
	public void testTotalDistances() {
		AStar.findPath(testMaze, calc);
		assertEquals(testMaze.getEndNode().getfScore(), 1269); //only correct in 10x10
	}
	

	@Test
	public void testDiagonalDistance() {
		int result;
		Cost calc = new Diagonal();
		result = calc.calculateDistance(testMaze.getStartNode(), testMaze.getEndNode()); 
		assertEquals(result, 1269); //only correct in 10x10
	}
	
	@Test
	public void testDiagonalSameNode() {
		int result;
		Cost calc = new Diagonal();
		result = calc.calculateDistance(testMaze.getStartNode(), testMaze.getStartNode()); 
		assertEquals(result, 0);
	}
	
	@Test
	public void testEuclideanDistance() {
		int result;
		Cost calc = new Euclidean();
		result = calc.calculateDistance(testMaze.getStartNode(), testMaze.getEndNode());
		assertEquals(result, 1272); 
	}
	
	@Test
	public void testEuclideanSameNode() {
		int result;
		Cost calc = new Euclidean();
		result = calc.calculateDistance(testMaze.getStartNode(), testMaze.getStartNode()); 
		assertEquals(result, 0);
	}
}
