package sourcecode;
import java.util.Scanner;

import cost.Cost;
import cost.Diagonal;
import cost.Euclidean;



public class MazeDriver {
	
	public static void main (String[] args) {
		
		Parse parseMaze = new BMP();
		Scanner scan = new Scanner(System.in);	
		
		String filePath = "";
		filePath = getFilePath(filePath, scan);
		
		Algorithms alg = null;
		alg = getAlgorithm(alg, scan);
		parseMaze.setAlgorithm(alg);
		
		Cost calc = null;
		calc = getCost(calc, scan);
		parseMaze.setCost(calc);
		
		int startX = 0, startY = 0;
		System.out.println("Please Enter Start Node's 'x' Position");
		startX = scan.nextInt();
		System.out.println("Please Enter Start Node's 'y' Position");
		startY = scan.nextInt();
		
		parseMaze.setStart(startX, startY);

		int finishX = 0, finishY = 0;
		System.out.println("Please Enter Finish Node's 'x' Position");
		finishX = scan.nextInt();
		System.out.println("Please Enter Finish Node's 'y' Position");
		finishY = scan.nextInt();
		
		parseMaze.setFinish(finishX, finishY);

		int rgb;
		System.out.println("Please Enter Threshold Value");
		rgb = scan.nextInt();
		parseMaze.setThreshold(rgb);

		//all inputs are accounted for
		if(filePath == "" || filePath == null) {
			System.out.println("Incorrect File Path.");
			return;
		}
		parseMaze.parseMaze(filePath);
	}
	
	private static String getFilePath(String filePath, Scanner scan) {
		System.out.println("Welcome to Maze Solver. Please enter a maze.");
		filePath = scan.nextLine();
		return filePath;
	}
	
	private static Algorithms getAlgorithm(Algorithms alg, Scanner scan) {
		String inData;
		System.out.println("Please Enter which Algorithm to use.");
		System.out.println("Press '1' for A* or '2' for Dijkstra.");
		inData = scan.nextLine();
			
		if(inData.equals("1")) {
			alg = new Astar();
		}
		if(inData.equals("2")) {
			alg = new Dijkstra();
		}
		return alg;
	}
	
	private static Cost getCost(Cost calc, Scanner scan) {
		String inData;
		System.out.println("Please Enter which Heuristic to use.");
		System.out.println("Press '1' for Manhattan, '2' for Diagonal, or '3' " +
							"for Euclidean.");
		inData = scan.nextLine();
		if(inData.equals("1")) {
			calc = new FCost();
		}
		if(inData.equals("2")) {
			calc = new Diagonal();
		}
		if(inData.equals("3")) {
			calc = new Euclidean();
		}		
		return calc;
	}
}
