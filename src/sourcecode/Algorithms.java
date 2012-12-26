package sourcecode;
import java.util.ArrayList;
import java.util.List;

import cost.Cost;



public interface Algorithms {
	List<MazeNode> finalPath = new ArrayList<MazeNode>();

	public boolean findPath(Maze maze, Cost calc);
	
	public List<MazeNode> getFinalPath();
	
	public boolean getFoundEnd();
	
}