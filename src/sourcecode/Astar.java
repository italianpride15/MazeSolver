package sourcecode;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import cost.Cost;


/**
 * Find the shortest route from point A to point B using A* algorithm
 * @author italianpride15
 *
 */
public class Astar implements Algorithms {

	private Maze maze;
	private Cost calc;
	private Comparator<MazeNode> comparator = new NodeCompare();
	private PriorityQueue<MazeNode> opened = new PriorityQueue<MazeNode>(8, comparator);
	private List<MazeNode> closed = new ArrayList<MazeNode>();
	private boolean foundEnd = false;
	
	@Override
	public boolean findPath(Maze my_maze, Cost my_calc) {
		
		this.maze = my_maze;
		this.calc = my_calc;
		MazeNode bestNode = maze.getStartNode();
		opened.add(bestNode);
		while(!foundEnd) {
			bestNode = opened.poll();
			System.out.print(bestNode.getxPositionInMaze());
			System.out.println(bestNode.getyPositionInMaze());
			if(bestNode == null) {
				System.out.println("No Path Found");
				break;
			}
			
			closed.add(bestNode);
			if(bestNode == maze.getEndNode()) {
				System.out.println("Found it");
				populatePath(bestNode);
				foundEnd = true;
				break;
			}
			
			calculateAdjacencies(bestNode);
			
//			bestNode.setTraversable(false);
			
//			closed.add(bestNode);
			
			
		}
		if(foundEnd) {
			return true;
		}
		return false;
	} //end findPath()
		
		
		private void populatePath(MazeNode populateNode) {
			
			if(populateNode.getParentNode() == null) {
				return;
			}
			finalPath.add(populateNode);
			//System.out.print(populateNode.getxPositionInMaze());
			//System.out.println(populateNode.getyPositionInMaze());
			populateNode = populateNode.getParentNode();
			populatePath(populateNode);
			return;
		} //end populatePath()
		
		/**
		 * Calculates N, E, S, W nodes from the current node.
		 */
		public void calculateAdjacencies(MazeNode begin) { //change to loop
						
			for(int i = begin.getxPositionInMaze() - 1; i < 2 + begin.getxPositionInMaze(); i++) {
				for(int j = begin.getyPositionInMaze() - 1; j < 2 + begin.getyPositionInMaze(); j++) {
					if(i >= 0 && i < maze.getRows() && j >= 0 && j < maze.getColumns () &&
					   maze.getNode(i, j).isTraversable() && !closed.contains(maze.getNode(i, j))){
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
					if(addNode.getParentNode() == null) {
						addNode.setParentNode(begin);
						setEstimatedScore(addNode, calc.calculateDistance(addNode, maze.getEndNode()));
						setAccumulatedScore(begin, addNode);
						setTotalScore(addNode);
						begin.getAdj().add(addNode);
						opened.add(addNode);
					}
					else {
						int beginVal = setAccumulatedScore(begin, addNode);
						if(addNode.getgScore() > beginVal) {
							addNode.setgScore(beginVal);
							setTotalScore(addNode);
							opened.remove(addNode);
							opened.add(addNode);
							
						}
				}		
			} //end setAvailableAdj()
			
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
					return (141 + begin.getgScore());
				}
				else {
					return (100 + begin.getgScore());
				}
			}
			
			private void setTotalScore(MazeNode addNode) {
				addNode.setfScore(addNode.getgScore() + addNode.gethScore());
			}
		/*
		 * Getters and Setters
		 */
		
		public boolean getFoundEnd() {
			return foundEnd;
		}
		
		public PriorityQueue<MazeNode> getOpened() {
			return opened;
		}

		public List<MazeNode> getClosed() {
			return closed;
		}
		
		public List<MazeNode> getFinalPath() {
			return finalPath;
		}
}
