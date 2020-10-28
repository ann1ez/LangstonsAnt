import java.util.Scanner;

public class Main{

	private static Ant[] ants;
	private static Board board;
	private static int steps;
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Hello, welcome to the Langton's Ant program!");
		while(menu()) {
			simulate();
			System.out.println("Would you like to run the simulation again?");
		}
	}
	
	public static void simulate() {
		System.out.println("STEP: 0");
		board.print(ants);
		
		for(int step = 1; step<= steps; step++) {
			System.out.println("STEP: "+step);
			for(Ant a : ants)
				singleAnt(a);
			board.print(ants);
		}
	}
	
	public static void singleAnt(Ant ant) {
		board.singleStep(ant);
		
		//determining next spot
		switch(ant.get_o()) {
		case 0:
			ant.set_r(ant.get_r()-1);
			break;
		case 1:
			ant.set_c(ant.get_c()+1);
			break;
		case 2:
			ant.set_r(ant.get_r()+1);
			break;
		case 3:
			ant.set_c(ant.get_c()-1);
			break;
		}
		//accounting for edge cases
		if(ant.get_r() < 0) ant.set_r(board.R()-1);
		else if(ant.get_r() > board.R()-1) ant.set_r(0);
		else if(ant.get_c() < 1) ant.set_c(board.C()-2);
		else if(ant.get_c() > board.C()-2) ant.set_c(1);
	}
	
	
	public static boolean menu() {
		System.out.println("Enter 1 if you would like to start the Langton's ant simulation. Enter 2 to quit.");
		int choice = verifyInput(1,2);
		
		if(choice == 1) {
			System.out.println("How many rows would you like for the board? (please choose an integer from 1 to 100)");
			int numR = verifyInput(1, 100);
			System.out.println("How many columns would you like for the board? (please choose an integer from 1 to 100)");
			int numC = verifyInput(1, 100);
			board = new Board(numR, numC);
			--numR; --numC;
			
			System.out.println("How many ants would you like to have? (please choose a reasonable integer)");
			ants = new Ant[verifyInput(1, numR*numC - 1)];
			
			for(int i=0; i<ants.length; i++) {
				Ant ant = new Ant(); 
				
				System.out.println("Please enter a starting row for Ant "+ i +": (please choose an integer from 0 to "+ numR+ ")");
				ant.set_r(verifyInput(0,numR));
				
				System.out.println("Please enter a starting column for Ant "+ i +": (please choose an integer from 0 to "+ numC +")");
				ant.set_c(verifyInput(0,numC) + 1);
				
				System.out.println("Please enter the starting orientation for Ant "+ i +": ");
				System.out.println("0 = North, 1 = East, 2 = South, 3 = West");
				ant.set_o(verifyInput(0, 3));
				
				ants[i] = ant;
			}
			
			System.out.println("How many steps should all ants take?");
			steps = verifyInput(1, 100000);
			
			return true;
		}
		System.out.println("Okay, good bye.");
		in.close();
		return false;
	}
	
	public static int verifyInput(int lower, int upper) {
	    
	    boolean valid = false;
	    int input = -1;
	    String invalid = "";
	    String other = "";
	    while(!valid){
	      if(!in.hasNextInt()){
	        invalid = in.nextLine();
	        System.out.print(invalid + " is not an integer. Please type in an integer: ");
	      }
	      else{
	        input = in.nextInt();
	        other = in.nextLine();
	        if(!other.equals("")){
	          System.out.print("Please enter only one integer: ");
	        }
	        else if(input > upper){
	          System.out.print("Please enter an integer less than or equal to " + upper +": ");
	        }
	        else if(input<lower){
	          System.out.print("Please enter an integer greater than or equal to "+ lower +": ");
	        }
	        else{
	          valid = true;
	        }
	      }  
	    }
	    return input;
	}

}
