package cost;
import sourcecode.MazeNode;

public class Manhattan implements Cost {

	public int calculateDistance(MazeNode xNode, MazeNode yNode) {
		int result = 0;
		result = Math.abs((xNode.getxPositionInMaze() - yNode.getxPositionInMaze())) + 
				 Math.abs((xNode.getyPositionInMaze() - yNode.getyPositionInMaze()));		 
		return result;
		
	}
}
