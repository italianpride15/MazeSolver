package sourcecode;
import gui.MazeView;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import cost.Cost;



import java.awt.Color;
import java.awt.Graphics;

public class BMP implements Parse {

	private File input;
	private BufferedImage image;
	private int height;
	private int width;
	private MazeNode start;
	private MazeNode finish;
	private Maze maze;
	private Color color;
	private int threshold = 2;
	private Algorithms alg;
	private Cost calc;
	
	/* Implements a general parse function specifically for BMPs
	 * @see Parse#parseMaze(java.lang.String)
	 */
	@Override
	public boolean parseMaze(File myFile) {
		
		input = myFile;
		
		try {
			image = ImageIO.read(input);		
		} catch (IOException e) {		
			e.printStackTrace();
		}
		
		height = image.getHeight();
		width = image.getWidth();
		
		createMaze();
		if(alg == null || calc == null) {
			System.out.println("Algorithm or Cost not set correctly");
			return false;
		}
		return alg.findPath(maze, calc);		
	} //end parseMaze()
	
		private void createMaze() {
			
			maze = new Maze(width, height, start, finish);
		
			for(int i = 0; i < maze.getRows(); i++) {
				for(int j = 0; j < maze.getColumns(); j++) {
					color = new Color(image.getRGB(i, j));
					if(colorIsNotWithinThreshold(color)) {
						maze.getNode(i, j).setTraversable(false);
					}
				}//end j
			} //end i
		} //end createMaze()
	
		private boolean colorIsNotWithinThreshold(Color checkColor) {
			if(checkColor.getRed() <= threshold && checkColor.getGreen() <= threshold
			   && checkColor.getBlue() <= threshold) {
				return false;
			}
			return true;
		} //end colorIsNotWithinThreshold()
		
		public BufferedImage drawPath(Algorithms alg) {
			BufferedImage solution = new BufferedImage(width, height, 
													   BufferedImage.TYPE_INT_RGB);
			Graphics g = solution.createGraphics();
			g.drawImage(image, 0, 0, null);
			g.setColor(Color.RED);
			for(MazeNode iterate : alg.getFinalPath()) {
				g.fillRect(iterate.getxPositionInMaze(), iterate.getyPositionInMaze(),
						   1, 1);
			}

			return solution;
		} //end drawPath()
		
		/*
		 * Getters and Setters
		 */
		
		public void setStart(int x, int y) {
			start = new MazeNode(x, y);
		}
		
		public void setFinish(int x, int y) {
			finish = new MazeNode(x, y);
		}
		
		public void setThreshold(int rgb) {
			threshold = rgb;
		}
		
		public void setAlgorithm(Algorithms my_alg) {
			this.alg = my_alg;
		}
		
		public void setCost(Cost calc) {
			this.calc = calc;
		}
}
