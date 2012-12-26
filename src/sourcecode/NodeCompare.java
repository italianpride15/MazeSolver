package sourcecode;
import java.util.Comparator;

public class NodeCompare implements Comparator<MazeNode> 
{
	@Override
	public int compare(MazeNode x, MazeNode y){
		//put in null/bad input checks
		if(x.getfScore() > y.getfScore()) {
			return 1;
		}
		if(x.getfScore() < y.getfScore()) {
			return -1;
		}
		return 0;
	}
}
