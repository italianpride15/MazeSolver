package sourcecode;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import cost.Cost;


/**
 * Find the shortest route from point A to point B using Dijkstra's Pathfinding algorithm
 * 
 * @author italianpride15
 *
 */
public class Dijkstra implements Algorithms{

	private Maze maze;
	private Cost calc;
	private Comparator<MazeNode> comparator = new NodeCompare();
	private PriorityQueue<MazeNode> verticies = new PriorityQueue<MazeNode>(8, comparator);
	int cumulatedDistance = 0;
	static int MAX_VALUE = Integer.MAX_VALUE;
	private boolean foundEnd = false;

	@Override
	public boolean findPath(Maze my_maze, Cost my_calc) {
		
		this.maze = my_maze;
		this.calc = my_calc;
		setAllNodesToInfinity();
		
		MazeNode bestNode = maze.getStartNode();
		verticies.remove(bestNode);
		bestNode.setfScore(0);
		verticies.add(bestNode);
		MazeNode vertex;
		
		while(true) {
			vertex = verticies.poll(); //automatically will be smallest distance
			if(vertex == maze.getEndNode()) {
				foundEnd = true;
				populatePath(vertex);
				break;
			}
			if(vertex.getfScore() == Integer.MAX_VALUE) {
				foundEnd = false;
				break;
			}
			//System.out.print(vertex.getxPositionInMaze());
			//System.out.println(vertex.getyPositionInMaze());
			
			calculateAdjacencies(vertex);
			
		}
		if(foundEnd) {
			return true;
		}
		return false;
	} //end findPath()
	
	public void calculateAdjacencies(MazeNode begin) { //change to loop
		
		for(int i = begin.getxPositionInMaze() - 1; i < 2 + begin.getxPositionInMaze(); i++) {
			for(int j = begin.getyPositionInMaze() - 1; j < 2 + begin.getyPositionInMaze(); j++) {
				if(i >= 0 && i < maze.getRows() && j >= 0 && j < maze.getColumns () &&
				   maze.getNode(i, j).isTraversable()) {
					if(i == begin.getxPositionInMaze() && j == begin.getyPositionInMaze()) {}
					else {
						setAvailableAdj(i, j, begin);
					}
				}
			}
		}
	}
	
		private void setAvailableAdj(int x, int y, MazeNode begin) {
			MazeNode addNode;	
			addNode = maze.getNode(x, y);
			if(verticies.remove(addNode)) {
					int beginVal = setAccumulatedScore(begin, addNode);
					if(addNode.getfScore() > beginVal) {
						addNode.setfScore(beginVal);
						addNode.setParentNode(begin);
					}
			    verticies.add(addNode);
						
			}
	
		} //end setAvailableAdj()
	private void setAllNodesToInfinity() {
		for(int i = 0; i < maze.getRows(); i++) {
			for(int j = 0; j < maze.getColumns(); j++) {
				maze.getNode(i, j).setfScore(MAX_VALUE);
				if(maze.getNode(i, j).isTraversable()) {
					verticies.add(maze.getNode(i, j));
				}
			}
		}
	} //end initialize()
	
	private void setEstimatedScore(MazeNode addNode, int estimatedDistance) {
		addNode.sethScore(estimatedDistance);
	}
	
	private int setAccumulatedScore(MazeNode begin, MazeNode addNode) {
		if(begin.getxPositionInMaze() < addNode.getxPositionInMaze() &&
		   begin.getyPositionInMaze() == addNode.getyPositionInMaze() ||
		   begin.getxPositionInMaze() > addNode.getxPositionInMaze() &&
		   begin.getyPositionInMaze() == addNode.getyPositionInMaze() ||
		   begin.getxPositionInMaze() == addNode.getxPositionInMaze() &&
		   begin.getyPositionInMaze() < addNode.getyPositionInMaze() ||
		   begin.getxPositionInMaze() == addNode.getxPositionInMaze() &&
		   begin.getyPositionInMaze() > addNode.getyPositionInMaze()) {
			return (141 + begin.getfScore());
		}
		else {
			return (100 + begin.getfScore());
		}
	}
	
	private void populatePath(MazeNode populateNode) {
		
		if(populateNode.getParentNode() == null) {
			return;
		}
		//System.out.print(populateNode.getxPositionInMaze());
		//System.out.println(populateNode.getyPositionInMaze());
		finalPath.add(populateNode);
		populateNode = populateNode.getParentNode();
		populatePath(populateNode);
		return;
	} //end populatePath()
	
	/*
	 * Getters and Setters
	 */
	
	public PriorityQueue<MazeNode> getVerticies() {
		return verticies;
	}

	public int getCumulatedDistance() {
		return cumulatedDistance;
	}
	
	public List<MazeNode> getFinalPath() {
		return finalPath;
	}
	
	public boolean getFoundEnd() {
		return foundEnd;
	}

}
