
/*
 * The N Queens problem solved through recursive backtracking
 * The board is represented using a 2D array with zeros as empty spaces 
 * and queens as 1's
 */

public class N_Queens {
	
	private int  N; // NxN board dimensions
	private int[][] board; // the chess board
	

	 
	public N_Queens(int N){
		this.N = N;
		this.board = new int[N][N];
	}
	
	
	/*
	 * A function to initialize the board to all zeros
	 */
	public void setBoard() {
		
		for(int i = 0; i < this.N; i++) {
			for(int j = 0; j < this.N; j++) {
				board[i][j] = 0;
			}
		}
		
	}
	
	/*
	 * A function that return the board
	 */
	public int[][] getBoard(){
		return this.board;
	}
	
	/*
	 * A function that return the number of queens on the board
	 */
	public int getNumQueens() {
		int count = 0;
		
		for(int i = 0; i < this.N; i++) {
			for(int j = 0; j < this.N; j++) {
				if(this.board[i][j] == 1) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	/*
	 * A function that displays the board 
	 */
	public void displayBoard(){
		
		for(int i = 0; i < this.N; i++) {
			for(int j = 0; j < this.N; j++) {
				if(j == N-1) {
					System.out.println(this.board[i][j]);
				}else {
					System.out.print(this.board[i][j] + " ");
				}
			}
		}
	}
	
/*
 * A function that checks if the position of a queen 
 * does not interfere with another queens position 
 */
	public boolean isValid(int row , int col){

	    // check the row
	    for(int i = 0; i < this.N; i++){
	    	
	        if(this.board[row][i] == 1 && i != col){
	            return false;
	        }
	    }
	    
	    // check the column
	    for(int i = 0; i < this.N; i++) {
	    	
	    	if(this.board[i][col] == 1 && i != row) {
	    		return false;
	    	}
	    }
	        
	    // check the upper right diagonal
	    for(int i = row-1 , j = col+1; i >= 0 && j < this.N; i--, j++){
	    
	        if(this.board[i][j] == 1){
	            return false;
	        }
	    }
	
	    // check the lower right diagonal
	    for(int i = row+1, j = col+1; i < this.N && j < this.N; i++, j++){
	
	        if(this.board[i][j] == 1){
	            return false;
	        }
	    }
	
	    // lower left diagonal
	    for(int i = row+1, j = col-1; i < this.N && j >= 0; i++, j--){
	        if(this.board[i][j] == 1){
	            return false;
	        }
	    }
	
	    // check the upper left diagonal
	    for(int i = row-1 , j = col-1; i >= 0 && j >= 0; i--, j--){
	        if(this.board[i][j] == 1){
	            return false;
	        }
	    }

	    return true;

	}
	
	
	/*
	 * A function that solves the N Queens problem using recursive backtracking
	 * taking in a 2D array board and the current row to be checked for placing queens
	 */
	public boolean solve(int [][] bo, int row){
		
		// if the number of queens is equal to N then stop
		if(getNumQueens() >= N ) {
			return true;
		}
		
		// checks the current row to place a queen into
		for(int i = 0; i < this.N; i++) {
			
			// if a queens is placed successfully, put a 1 in that location 
			if(isValid(row,i)) {
				this.board[row][i] = 1;
			
				// recursively call solve to keep placing queens
				if(solve(this.board, row+1) == true) {
					return true;
				}
				
				// Backtrack if a queen cannot be placed in the row and return false
				board[row][i] = 0;
			}
			
				
		}
	
		return false;
	}

	public static void main(String[] args) {

		N_Queens bo = new N_Queens(4);
		bo.setBoard();
	    bo.solve(bo.getBoard(), 0);
		bo.displayBoard();
		
	}

	
}
