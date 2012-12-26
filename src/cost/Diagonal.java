package cost;
import sourcecode.MazeNode;




public class Diagonal implements Cost {
	
	//chebyshev distance
		public int calculateDistance(MazeNode xNode, MazeNode yNode) {
			int result;
			result = diagCost * getDiagonalDistance(xNode, yNode) + 
					 moveCost * (getStraightDistance(xNode, yNode) - 
					   2 * getDiagonalDistance(xNode, yNode));
			return result;
			
		} //end diagonalDistance()
		
			private int getDiagonalDistance(MazeNode xNode, MazeNode yNode) {
				int result;
				result = Math.min(Math.abs(xNode.getxPositionInMaze() - 
									yNode.getxPositionInMaze()),
								  Math.abs(xNode.getyPositionInMaze() - 
									yNode.getyPositionInMaze()));
				return result;
			} //end getDiagonalDistance()
			
			private int getStraightDistance(MazeNode xNode, MazeNode yNode) {
				int result;
				result = Math.abs(xNode.getxPositionInMaze() -
									yNode.getxPositionInMaze()) +
						 Math.abs(xNode.getyPositionInMaze() -
						 			yNode.getyPositionInMaze());
				return result;
			} //getStraightDistance()
}
