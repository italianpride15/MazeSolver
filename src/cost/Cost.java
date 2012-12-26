package cost;
import sourcecode.MazeNode;




public interface Cost {

	public final int moveCost = 100;
	public final int diagCost = 141;

	public int calculateDistance(MazeNode xNode, MazeNode yNode);
}
