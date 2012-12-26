import static org.junit.Assert

.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import sourcecode.Algorithms;
import sourcecode.Astar;
import sourcecode.Maze;
import sourcecode.MazeNode;

import cost.Cost;
import cost.Diagonal;
import cost.Euclidean;
import cost.Manhattan;



public class MockitoAstar {
	MazeNode start = new MazeNode(0, 0);
	MazeNode finish = new MazeNode(99, 99);
	
	@Test
	public void mockMazeWithAstarManhattan() {
		Maze mockMaze = mock(Maze.class);
		Cost calc = new Manhattan();
		Algorithms AStar = new Astar();
		AStar.findPath(mockMaze, calc);
		verify(mockMaze).getStartNode();
		verify(mockMaze).getEndNode();
	}
	
	@Test
	public void mockMazeWithAstarDiagonal() {
		Maze mockMaze = mock(Maze.class);
		Cost calc = new Diagonal();
		Algorithms AStar = new Astar();
		AStar.findPath(mockMaze, calc);
		verify(mockMaze).getStartNode();
		verify(mockMaze).getEndNode();	
	}
	
	@Test
	public void mockMazeWithAstarEuclidean() {
		Maze mockMaze = mock(Maze.class);
		Cost calc = new Euclidean();
		Algorithms AStar = new Astar();
		AStar.findPath(mockMaze, calc);
		verify(mockMaze).getStartNode();
		verify(mockMaze).getEndNode();	
	}
	
	@Test
	public void mockCostAstarManhattan() {
		Cost mockCost = mock(Manhattan.class);
		Maze maze = new Maze(100, 100, start, finish);
		Algorithms AStar = new Astar();
		AStar.findPath(maze, mockCost);
		verify(mockCost).calculateDistance(start, finish);	
	}
	
	@Test
	public void mockCostAstarDiagonal() {
		Cost mockCost = mock(Diagonal.class);
		Maze maze = new Maze(100, 100, start, finish);
		Algorithms AStar = new Astar();
		AStar.findPath(maze, mockCost);
		verify(mockCost).calculateDistance(start, finish);		
	}
	@Test
	public void mockCostAstarEuclidean() {
		Cost mockCost = mock(Euclidean.class);
		Maze maze = new Maze(100, 100, start, finish);
		Algorithms AStar = new Astar();
		AStar.findPath(maze, mockCost);
		verify(mockCost).calculateDistance(start, finish);
	}
	
}
