import static org.junit.Assert.*;



import org.junit.Test;

import sourcecode.Astar;
import sourcecode.Dijkstra;
import sourcecode.Maze;
import sourcecode.MazeNode;

import cost.Cost;
import cost.Diagonal;
import cost.Euclidean;
import cost.Manhattan;



//test for optimal paths
public class TestAlgorithms {
	MazeNode start = new MazeNode(0, 0);
	MazeNode finish = new MazeNode(9, 9);
	Maze maze = new Maze(10, 10, start, finish);
	Astar AStar = new Astar();
	Dijkstra Dijk = new Dijkstra();
	
	@Test
	public void testAStarOptimalPathManhattan() {
		Cost calc = new Manhattan();
		AStar.findPath(maze, calc);
		int i = 9;
		for(MazeNode it : AStar.getFinalPath()) {
			assertEquals(it, maze.getNode(i, i));
			i--;
		}
	}
	
	@Test
	public void testAStarOptimalPathDiagonal() {
		Cost calc = new Diagonal();
		AStar.findPath(maze, calc);
		int i = 9;
		for(MazeNode it : AStar.getFinalPath()) {
			assertEquals(it, maze.getNode(i, i));
			i--;
		}
	}
	
	@Test
	public void testAStarOptimalPathEuclidean() {
		Cost calc = new Euclidean();
		AStar.findPath(maze, calc);
		int i = 9;
		for(MazeNode it : AStar.getFinalPath()) {
			assertEquals(it, maze.getNode(i, i));
			i--;
		}
	}
	
	@Test
	public void testDijkstraOptimalPathManhattan() {
		Cost calc = new Manhattan();
		Dijk.findPath(maze, calc);
		assertEquals(maze.getEndNode().getfScore(), 1000);
		int i = 9;
		for(MazeNode it : Dijk.getFinalPath()) {
			assertEquals(it, maze.getNode(i, i));
			i--;
		}
	
	}

	@Test
	public void testDijkstraOptimalPathDiagonal() {
		Cost calc = new Diagonal();
		Dijk.findPath(maze, calc);
		int i = 9;
		for(MazeNode it : Dijk.getFinalPath()) {
			assertEquals(it, maze.getNode(i, i));
			i--;
		}
	}
	
	@Test
	public void testDijkstraOptimalPathEuclidean() {
		Cost calc = new Euclidean();
		Dijk.findPath(maze, calc);
		int i = 9;
		for(MazeNode it : Dijk.getFinalPath()) {
			assertEquals(it, maze.getNode(i, i));
			i--;
		}
	}
}
