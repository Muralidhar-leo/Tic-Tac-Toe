package Game;

public class Board {
	
	private char[][] board;
	private int size=3;
	private char player1sym,player2sym;
	
	public static final int Player1Wins=1;
	public static final int Player2Wins=2;
	public static final int Draw=3;
	public static final int Incomplete=4;
	public static final int Invalid=5;
	
	private int count;
	private static final char empty=' ';
	
	public Board(char player1sym,char player2sym) {
		board=new char[size][size];
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				board[i][j]=empty;
			}
		}
		
		this.player1sym=player1sym;
		this.player2sym=player2sym;
	}
	
	public void printboard() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				System.out.print("| "+board[i][j]+" |");
			}
			System.out.println();
		}
		
		
	}
	
	public int move(char symbol,int x,int y) {
	  if(x<0 || x>=size || y<0 || y>=size || board[x][y]!=empty) {
		  return Invalid;
	  }
	  
	  board[x][y]=symbol;
	  count++;
	  //Row checking
	  if(board[x][0]==board[x][1] && board[x][0]==board[x][2]) {
		  return symbol==player1sym?Player1Wins:Player2Wins;
	  }
	  
	  // Coloumn checking
	  if(board[0][y]==board[1][y] && board[0][y]==board[2][y]) {
		  return symbol==player1sym?Player1Wins:Player2Wins;
	  }
	  
	  //Diagnol Checking
	  if( board[0][0]!=empty && board[0][0]==board[1][1] && board[0][0]==board[2][2]) {
		  return symbol==player1sym?Player1Wins:Player2Wins;
	  }
	  if( board[0][2]!=empty && board[0][2]==board[1][1] && board[1][1]==board[0][2]) {
		  return symbol==player1sym?Player1Wins:Player2Wins;
	  }
	  
	  if(count==size*size) {
		  return Draw;
	  }
	  
	  return Incomplete;
	  
	  
		
	}

	
	
	
	
	
	
	
	

}
