import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import org.junit.Test;

import sourcecode.Algorithms;
import sourcecode.Dijkstra;
import sourcecode.Maze;
import sourcecode.MazeNode;

import cost.Cost;
import cost.Diagonal;
import cost.Euclidean;
import cost.Manhattan;


public class MockitoDijkstra {

		MazeNode start = new MazeNode(0, 0);
		MazeNode finish = new MazeNode(99, 99);
		
		@Test
		public void mockMazeWithDijkstraManhattan() {
			Maze mockMaze = mock(Maze.class);
			Cost calc = new Manhattan();
			Algorithms Dijkstra = new Dijkstra();
			Dijkstra.findPath(mockMaze, calc);
			verify(mockMaze).getStartNode();
			verify(mockMaze).getEndNode();
		}
		
		@Test
		public void mockMazeWithDijkstraDiagonal() {
			Maze mockMaze = mock(Maze.class);
			Cost calc = new Diagonal();
			Algorithms Dijkstra = new Dijkstra();
			Dijkstra.findPath(mockMaze, calc);
			verify(mockMaze).getStartNode();
			verify(mockMaze).getEndNode();	
		}
		
		@Test
		public void mockMazeWithDijkstraEuclidean() {
			Maze mockMaze = mock(Maze.class);
			Cost calc = new Euclidean();
			Algorithms Dijkstra = new Dijkstra();
			Dijkstra.findPath(mockMaze, calc);
			verify(mockMaze).getStartNode();
			verify(mockMaze).getEndNode();	
		}
		
		@Test
		public void mockCostDijkstraManhattan() {
			Cost mockCost = mock(Manhattan.class);
			Maze maze = new Maze(100, 100, start, finish);
			Algorithms Dijkstra = new Dijkstra();
			Dijkstra.findPath(maze, mockCost);
			verify(mockCost).calculateDistance(start, finish);	
		}
		
		@Test
		public void mockCostDijkstraDiagonal() {
			Cost mockCost = mock(Diagonal.class);
			Maze maze = new Maze(100, 100, start, finish);
			Algorithms Dijkstra = new Dijkstra();
			Dijkstra.findPath(maze, mockCost);
			verify(mockCost).calculateDistance(start, finish);		
		}
		@Test
		public void mockCostDijkstraEuclidean() {
			Cost mockCost = mock(Euclidean.class);
			Maze maze = new Maze(100, 100, start, finish);
			Algorithms Dijkstra = new Dijkstra();
			Dijkstra.findPath(maze, mockCost);
			verify(mockCost).calculateDistance(start, finish);
		}
}
