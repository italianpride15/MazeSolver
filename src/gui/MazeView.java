package gui;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MazeView {

	private JButton testMazeButton;
	private JButton solveMazeButton;
	private JRadioButton manhattanRButton;
	private JRadioButton diagonalRButton;
	private JRadioButton euclideanRButton;
	private JRadioButton astarRButton;
	private JRadioButton dijkstraRButton;
	private JMenuItem menuItemOpen;
	private JMenuItem menuItemSave;
	private JTextField startXField;
	private JTextField startYField;
	private JTextField finalXField;
	private JTextField finalYField;
	private JLabel mazeIcon;
	
	
    /** MazeView Constructor
     * @param itsApplet
     */
    public MazeView(MazeController itsApplet) {
       
        itsApplet.setSize(500, 500);
        JPanel myPanel = initializePanel();
        initializeButtons(myPanel);
        initializeTextFields(myPanel);
        JMenuBar menuBar = initializeMenuBar(); 
        mazeIcon = new JLabel();
        mazeIcon.setBounds(75, 215, 320, 240);
        myPanel.add(mazeIcon);
        itsApplet.setJMenuBar(menuBar);
        itsApplet.add(myPanel);
        itsApplet.setContentPane(myPanel);
    } //end MazeView()
    
    // ** private helpers **
    private JMenuBar initializeMenuBar() {
    	//Build JMenuBar
    	JMenuBar menuBar = new JMenuBar();
    	
    	//Build JMenu.
    	JMenu menu = new JMenu("File");
    	menuBar.add(menu);

    	//Build JMenuItems
    	menuItemOpen = new JMenuItem("Open");
    	menuItemSave = new JMenuItem("Save");
    	menu.add(menuItemOpen);
    	menu.add(menuItemSave);
    	return menuBar;
    } //end initializeMenuBar()
    
    private JPanel initializePanel() {
        JPanel myPanel = new JPanel();
        myPanel.setPreferredSize(new Dimension(500,700));
        myPanel.setLayout(null);
        return myPanel;
    } //end initializePanel()
    
    private void initializeButtons(JPanel myPanel) {
    	  //added button groups
          ButtonGroup heuristics = new ButtonGroup();
          ButtonGroup algorithms = new ButtonGroup();
    	  	  initializeTestMazeButton(myPanel);
          initializeSolveMazeButton(myPanel);
          initializeManhattanRButton(myPanel, heuristics);
          initializeDiagonalRButton(myPanel, heuristics);
          initializeEuclideanRButton(myPanel, heuristics);
          initializeAstarRButton(myPanel, algorithms);
          initializeDijkstraRButton(myPanel, algorithms);
    } //end initializeButtons
    
    // ** helper functions to initialize all buttons **
    private void initializeTestMazeButton(JPanel myPanel) {
        testMazeButton = new JButton("Test Maze");
        myPanel.add(testMazeButton);
        testMazeButton.setBounds(75, 25, testMazeButton.getPreferredSize().width, 
	 				             testMazeButton.getPreferredSize().height);
    }
    
     private void initializeSolveMazeButton(JPanel myPanel) {
        solveMazeButton = new JButton("Solve Maze");
        myPanel.add(solveMazeButton);
        solveMazeButton.setBounds(275, 25, solveMazeButton.getPreferredSize().width,
        						  solveMazeButton.getPreferredSize().height);
    }
  
      private void initializeManhattanRButton(JPanel myPanel, ButtonGroup heuristics) {
    	  manhattanRButton = new JRadioButton("Manhattan");
    	  manhattanRButton.setMnemonic(KeyEvent.VK_M);
    	  myPanel.add(manhattanRButton);
    	  manhattanRButton.setBounds(50, 75, manhattanRButton.getPreferredSize().width,
    			  					 manhattanRButton.getPreferredSize().height);
    	  heuristics.add(manhattanRButton);
      }
  
	  private void initializeDiagonalRButton(JPanel myPanel, ButtonGroup heuristics) {
	      diagonalRButton = new JRadioButton("Diagonal");
	      diagonalRButton.setMnemonic(KeyEvent.VK_D);
	      myPanel.add(diagonalRButton);
	      diagonalRButton.setBounds(200, 75, diagonalRButton.getPreferredSize().width,
					   				diagonalRButton.getPreferredSize().height);
	      heuristics.add(diagonalRButton);
	  }
	  
	  private void initializeEuclideanRButton(JPanel myPanel, ButtonGroup heuristics) {
	      euclideanRButton = new JRadioButton("Euclidean");
	      euclideanRButton.setMnemonic(KeyEvent.VK_E);
	      myPanel.add(euclideanRButton);
	      euclideanRButton.setBounds(350, 75, euclideanRButton.getPreferredSize().width,
					   				 euclideanRButton.getPreferredSize().height);
	      heuristics.add(euclideanRButton);
	  }
	  
	  private void initializeAstarRButton(JPanel myPanel, ButtonGroup algorithms) {
	      astarRButton = new JRadioButton("A*");
	      astarRButton.setMnemonic(KeyEvent.VK_A);
	      myPanel.add(astarRButton);
	      astarRButton.setBounds(150, 115, astarRButton.getPreferredSize().width,
	      					     astarRButton.getPreferredSize().height);
	      algorithms.add(astarRButton);
	  }
	  
	  private void initializeDijkstraRButton(JPanel myPanel, ButtonGroup algorithms) {
	       dijkstraRButton = new JRadioButton("Dijkstra");
	       dijkstraRButton.setMnemonic(KeyEvent.VK_J);
	       myPanel.add(dijkstraRButton);
	       dijkstraRButton.setBounds(250, 115, dijkstraRButton.getPreferredSize().width,
			   		   			     dijkstraRButton.getPreferredSize().height);
	       algorithms.add(dijkstraRButton);
	  }
	  
	  //initializing text fields
	  private void initializeTextFields(JPanel myPanel) {
		  startXField = new JTextField();
		  startYField = new JTextField();
		  finalXField = new JTextField();
		  finalYField = new JTextField();
		  
		  JLabel startXLabel = new JLabel("Start X");
		  JLabel startYLabel = new JLabel("Start Y");
		  JLabel finalXLabel = new JLabel("Finish X");
		  JLabel finalYLabel = new JLabel("Finish Y");
		  
		  startXField.setText("0");
		  startYField.setText("0");
		  finalXField.setText("0");
		  finalYField.setText("0");
		  
		  startXField.setBounds(200, 150, 38, startXField.getPreferredSize().height);
		  startYField.setBounds(200, 175, 38, startYField.getPreferredSize().height);
		  finalXField.setBounds(300, 150, 38, finalXField.getPreferredSize().height);
		  finalYField.setBounds(300, 175, 38, finalYField.getPreferredSize().height);
		  startXLabel.setBounds(155, 155, startXLabel.getPreferredSize().width, 
				  				startXLabel.getPreferredSize().height);
		  startYLabel.setBounds(155, 180, startYLabel.getPreferredSize().width, 
	  							startYLabel.getPreferredSize().height);
		  finalXLabel.setBounds(245, 155, finalXLabel.getPreferredSize().width, 
	  							finalXLabel.getPreferredSize().height);
		  finalYLabel.setBounds(245, 180, finalYLabel.getPreferredSize().width, 
	  							finalYLabel.getPreferredSize().height);
	  
		  myPanel.add(startXField);
		  myPanel.add(startYField);
		  myPanel.add(finalXField);
		  myPanel.add(finalYField);	
		  myPanel.add(startXLabel);
		  myPanel.add(startYLabel);
		  myPanel.add(finalXLabel);
		  myPanel.add(finalYLabel);
	  } //end initializeTextFields()
	  
	// ** public methods **	
	  
	// ** add listeners **
	public void addTestButtonListener(ActionListener e) {
		testMazeButton.addActionListener(e);
	}
	
	public void addSolveButtonListener(ActionListener e) {
		solveMazeButton.addActionListener(e);
	}
	
	public void addMenuOpenListener(ActionListener e) {
		menuItemOpen.addActionListener(e);
	}

	public void addMenuSaveListener(ActionListener e) {
		menuItemSave.addActionListener(e);
	}
	
	// ** states **
	public void setStartState() {
		testMazeButton.setEnabled(false);
		solveMazeButton.setEnabled(false);
		menuItemSave.setEnabled(false);
		manhattanRButton.setSelected(true);
        astarRButton.setSelected(true);
	}
	public void setTestState() {
		testMazeButton.setEnabled(true);
		solveMazeButton.setEnabled(false);
		menuItemSave.setEnabled(false);
	}
	
	public void setSolveState() {
		testMazeButton.setEnabled(false);
		solveMazeButton.setEnabled(true);
		menuItemSave.setEnabled(false);
	}
	
	public void setFinishedState() {
		testMazeButton.setEnabled(false);
		solveMazeButton.setEnabled(false);
		menuItemSave.setEnabled(true);
	}
	
	// ** Getters and Setters **
	
	public void setMaze(BufferedImage myMaze) {
		this.mazeIcon.setIcon(new ImageIcon(myMaze));
	}
	
	public JTextField getStartXField() {
		return startXField;
	}

	public JTextField getStartYField() {
		return startYField;
	}

	public JTextField getFinalXField() {
		return finalXField;
	}

	public JTextField getFinalYField() {
		return finalYField;
	}
	
	public JRadioButton getManhattanRButton() {
		return manhattanRButton;
	}

	public JRadioButton getDiagonalRButton() {
		return diagonalRButton;
	}

	public JRadioButton getEuclideanRButton() {
		return euclideanRButton;
	}

	public JRadioButton getAstarRButton() {
		return astarRButton;
	}

	public JRadioButton getDijkstraRButton() {
		return dijkstraRButton;
	}
}
