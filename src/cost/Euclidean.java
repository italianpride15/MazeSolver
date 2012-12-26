package cost;
import sourcecode.MazeNode;




public class Euclidean implements Cost {

	//euclidean distance
		public int calculateDistance(MazeNode xNode, MazeNode yNode) {
			int result;
			result = ((int) (moveCost * Math.sqrt(Math.pow(xNode.getxPositionInMaze() - 
											yNode.getxPositionInMaze(), 2) + 
											Math.pow(xNode.getyPositionInMaze() - 
											yNode.getxPositionInMaze(), 2))));
			return result;		
		} //end euclideanDistance()
}
