package sourcecode;
import gui.MazeView;

import java.awt.image.BufferedImage;
import java.io.File;
import cost.Cost;



public interface Parse {

	public boolean parseMaze(File myFile);
	
	public BufferedImage drawPath(Algorithms alg);
	
	public void setStart(int x, int y);
	
	public void setFinish(int x, int y);
	
	public void setThreshold(int rgb);
	
	public void setAlgorithm(Algorithms my_alg); 
	
	public void setCost(Cost calc); 
}
