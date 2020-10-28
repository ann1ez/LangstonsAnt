
public class Board {
	private static String[][] board;
	private static String[][] antLocations;
	private static int numR;
	private static int numC;
	
	public Board(int r, int c) {
		board = new String[r][c+2];
		antLocations = new String[r][c+2];
		numR=r; numC=c+2;
		
		for(int a=0; a<numR; a++) {
			
			//adding the left and right borders
			board[a][0] = "|";
			board[a][numC-1] = "|";
			
			//the rest of the board
			for(int b=1; b<numC-1; b++) {
				board[a][b] = " ";
			}
		}
	}
	
	public void singleStep(Ant ant) {
		if(board[ant.get_r()][ant.get_c()].equals("#")) {
			ant.set_o((ant.get_o()+3)%4);
			board[ant.get_r()][ant.get_c()] = " ";
		}
		else {
			ant.set_o((ant.get_o()+1)%4);
			board[ant.get_r()][ant.get_c()]= "#";
		}
	}
	
	public static void addAnts(Ant[] ants) {
		String[][] newLocations = new String[numR][numC];
		for(Ant each : ants) {
			newLocations[each.get_r()][each.get_c()] = each.style();
		}
		antLocations = newLocations;
	}
	
	public void print(Ant[] ants) {
		addAnts(ants);
		
		//the top border
		for(int j=0; j<board[0].length; j++) {
			System.out.print("-");
		}
		System.out.println();
		
		//the middle bulk
		for(int i=0; i<numR; i++) {
			for(int j=0; j<numC; j++) {
				if(antLocations[i][j]==null)
					System.out.print(board[i][j]);
				else
					System.out.print(antLocations[i][j]);
			}
			System.out.println();
		}
		
		//the bottom border
		for(int j=0; j<board[0].length; j++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	public int R() {
		return numR;
	}
	public int C() {
		return numC;
	}
}
