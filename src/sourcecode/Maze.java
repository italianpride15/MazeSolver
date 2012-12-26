package sourcecode;

public class Maze {

	private int rows;
	private int columns;
	private MazeNode[][] nodes;
	private MazeNode finish;
	private MazeNode start;
	
	/**
	 * Maze Constructor
	 * @param rows
	 * @param columns
	 */
	public Maze(int rows, int columns, MazeNode start, MazeNode finish) {
		//how to make this more general for what they pass in
		this.rows = rows;
		this.columns = columns;
		
		if(checkForInvalidMazes(rows, columns, start, finish) < 0) {
			return;
		}
		
		nodes = new MazeNode[rows][columns];
		makeMazeNodes();
		this.start = getNode(start.getxPositionInMaze(), start.getyPositionInMaze());
		this.finish = getNode(finish.getxPositionInMaze(), finish.getyPositionInMaze());
		setWalls();
		
	} //end Maze()
	
		private int checkForInvalidMazes(int rows, int columns, MazeNode start, MazeNode finish) {
			if((rows == 1 && columns == 1) || rows < 1 || columns < 1) {
				System.out.println("Incorrect Maze Size.");
				return -1;
			}
			if(start == finish) {
				System.out.println("Same Start and Finish.");
				return -2;
			}
			if(start == null || finish == null) {
				System.out.println("Start or Finish not set.");
				return -3;
			}
			if(start.getxPositionInMaze() < 0 || start.getxPositionInMaze() >= rows ||
			   start.getyPositionInMaze() < 0 || start.getyPositionInMaze() >= columns) {
				System.out.println("Start index out of bounds.");
				return -4;
			}
			if(finish.getxPositionInMaze() < 0 || finish.getxPositionInMaze() >= rows ||
			   finish.getyPositionInMaze() < 0 || finish.getyPositionInMaze() >= columns) {
				System.out.println("Finish index out of bounds.");
				return -5;
			}
			return 0;
		}
		
		private void makeMazeNodes() {
			
			for(int i = 0; i < rows; i++) {
				for(int j = 0; j < columns; j++) {
					nodes[i][j] = new MazeNode(i, j, this);
					
				} //end j loop
			} //end i loop
			//start = getNode(start.getxPositionInMaze(), start.getyPositionInMaze());
			//finish = getNode(finish.getxPositionInMaze(), finish.getyPositionInMaze());
		} //end makeMazeNodes()
		
	public void setWalls() {
			
			
		} //end setStartAndFinish()

		/*
		 * Getters and Setters
		 */
		
		public MazeNode getNode(int i, int j) {
			return nodes[i][j];
		}
		
		public void setNode(MazeNode node) {
			nodes[node.getxPositionInMaze()][node.getyPositionInMaze()] = node;
		}
		
		public MazeNode getStartNode() {
			return start;
		}
		
		public MazeNode getEndNode() {
			return finish;
		}
		
		public int getRows() {
			return rows;
		}
		
		public int getColumns() {
			return columns;
		}
}
	