package gui;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JApplet;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import sourcecode.Algorithms;
import sourcecode.Astar;
import sourcecode.Dijkstra;
import sourcecode.BMP;
import sourcecode.Parse;
import cost.Cost;
import cost.Diagonal;
import cost.Euclidean;
import cost.Manhattan;

public class MazeController extends JApplet{

	private BufferedImage image;
	private Algorithms alg;
	private Cost calc;
	private MazeView view;
	private BMP parseMaze;
	private File selectedFile;
	
	
	/* Initialize View
	 * @see java.applet.Applet#init()
	 */
	public void init() {
		this.setName("Maze Solver");
		view = new MazeView(this);
		view.setStartState();
		
		initializeActionListeners();
	
	}
	
		// ** implement action listeners **
		private void initializeActionListeners() {
			
			view.addTestButtonListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					parseMaze = new BMP();		
					
					//check for invalid inputs
					if(Integer.parseInt(view.getStartXField().getText()) < 0 ||
					   Integer.parseInt(view.getStartYField().getText()) < 0 ||
					   Integer.parseInt(view.getFinalXField().getText()) > 319 ||
					   Integer.parseInt(view.getFinalYField().getText()) > 239) {
						
						return;
					}
					
					//add start and finish
					parseMaze.setStart(Integer.parseInt(view.getStartXField().getText()),
									   Integer.parseInt(view.getStartYField().getText()));
					parseMaze.setFinish(Integer.parseInt(view.getFinalXField().getText()),
							   		   Integer.parseInt(view.getFinalYField().getText()));
					
					//add heuristic and algorithms
					if(view.getManhattanRButton().isSelected()) {
						calc = new Manhattan();
						parseMaze.setCost(calc);
					}
					if(view.getDiagonalRButton().isSelected()) {
						calc = new Diagonal();
						parseMaze.setCost(calc);
					}
					if(view.getEuclideanRButton().isSelected()) {
						calc = new Euclidean();
						parseMaze.setCost(calc);
					}
					
					if(view.getAstarRButton().isSelected()) {
						alg = new Astar();
						parseMaze.setAlgorithm(alg);
					}
					if(view.getDijkstraRButton().isSelected()) {
						alg = new Dijkstra();
						parseMaze.setAlgorithm(alg);
					}
					
					if(parseMaze.parseMaze(selectedFile)) {
						view.setSolveState();
					}
					else {
						view.setStartState();
					}
				}
			});
			
			view.addSolveButtonListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					image = parseMaze.drawPath(alg);
					view.setMaze(image);
					view.setFinishedState();
					
				}
			});
			
			//implement using filechooser
			view.addMenuOpenListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter(
							"BMP Images", "bmp");
					fc.setFileFilter(filter);
					int returnVal = fc.showOpenDialog(getLayeredPane());
					if(returnVal == JFileChooser.APPROVE_OPTION) {
						selectedFile = fc.getSelectedFile();
						BufferedImage myPicture;
						try {
							myPicture = ImageIO.read(selectedFile);
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							view.setStartState();
							return;
						}
						view.setMaze(myPicture);
						view.setTestState();
					}
				}
			});
			
			//implement using filechooser
			view.addMenuSaveListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						ImageIO.write(image, "bmp", new File(selectedFile.getPath() + "_solution.bmp"));
					} catch (IOException e1) {
						//silent
					}
					view.setStartState();
				}
			});
		}
	
}
