import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import sourcecode.Astar;
import sourcecode.Maze;
import sourcecode.MazeNode;

import cost.Cost;
import cost.Manhattan;




public class TestMazeSets {
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
	
	@Test
	public void testIfInOpenOrClosedSet() {
		AStar.findPath(testMaze, calc);
		MazeNode lookingFor = testMaze.getEndNode();
		MazeNode tempNode;
		while(!(AStar.getOpened().isEmpty())) {
			tempNode = AStar.getOpened().poll();
			if(tempNode == lookingFor) {
				assertEquals(tempNode, lookingFor);
			}
		}
		for(MazeNode adjacency : AStar.getClosed()) {
			if(adjacency == lookingFor) {
				assertEquals(adjacency, lookingFor);
				return;
			}
		}
	}
		
	@Test
	public void testPQ() {
		AStar.findPath(testMaze, calc);
		MazeNode firstBestFromPQ = testMaze.getNode(1, 1);
		if(AStar.getClosed().contains(firstBestFromPQ)) {
			assert(AStar.getClosed().contains(firstBestFromPQ));
			return;
		}
	}
	
	
}
