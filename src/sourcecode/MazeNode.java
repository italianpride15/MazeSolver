package sourcecode;
/*
@author npanta2
*/

import java.util.HashSet;

import java.util.Set;

import cost.Cost;


public class MazeNode
{
	private MazeNode parentNode; //path for Dijkstra's algorithm
	private Set<MazeNode> adjacencies = new HashSet<MazeNode>();
	private Maze maze;
	
	private boolean isTraversable = true;
	private boolean isDiagonal = false;

	private int xPositionInMaze;
	private int yPositionInMaze;
	
	//Manhattan Distance
	private int fScore = 0; //F = G + H or total cost
	private int gScore = 0;
	private int hScore = 0;
	
	/**
	 * MazeNode Constructor
	 * @param i
	 * @param j
	 * @param maze
	 */
	public MazeNode(int i, int j, Maze maze) {
		
		this.xPositionInMaze = i;
		this.yPositionInMaze = j;
		this.maze = maze;
		
	} //end MazeNode()
	
	public MazeNode(int i, int j) {
		this.xPositionInMaze = i;
		this.yPositionInMaze = j;
	}
	
	/*
	 * Getter and Setter Methods
	 */

	public int getgScore() {
		return gScore;
	}

	public void setgScore(int gScore) {
		this.gScore = gScore;
	}

	public int gethScore() {
		return hScore;
	}

	public void sethScore(int hScore) {
		this.hScore = hScore;
	}
	
	public Set<MazeNode> getAdj() {
		return adjacencies;
	}
	public boolean isDiagonal() {
		return isDiagonal;
	}

	public void setDiagonal(boolean isDiagonal) {
		this.isDiagonal = isDiagonal;
	}

	public Set<MazeNode> getAdjNodes() {
		return adjacencies;
	}

	public boolean isTraversable() {
		return isTraversable;
	}

	public void setTraversable(boolean isTraversable) {
		this.isTraversable = isTraversable;
	}
	
	public MazeNode getParentNode() {
		return parentNode;
	}
	
	public void setParentNode(MazeNode parent) {
		this.parentNode = parent;
	}
	
	public int getxPositionInMaze() {
		return xPositionInMaze;
	}

	public void setxPositionInMaze(int xPositionInMaze) {
		this.xPositionInMaze = xPositionInMaze;
	}

	public int getyPositionInMaze() {
		return yPositionInMaze;
	}

	public void setyPositionInMaze(int yPositionInMaze) {
		this.yPositionInMaze = yPositionInMaze;
	}
	
	public int getfScore() {
		return fScore;
	}

	public void setfScore(int fScore) {
		this.fScore = fScore;
	}
}
