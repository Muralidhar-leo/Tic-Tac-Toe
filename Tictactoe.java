package Game;
import java.util.*;



public class Tictactoe {
	
	 private Player player1,player2;
	 private Board board;
	public static void main(String args[]) {
		Tictactoe t=new Tictactoe();
		t.startgame();
	}
	
	private void startgame() {
		Scanner sc=new Scanner(System.in);
		
		 player1=takeplayerInput(1);
		 player2=takeplayerInput(2);
		if(player1.getSymbol()==player2.getSymbol()) {
			System.out.println("Change the symbol same symbol is not allowed");
			player2.setSymbol(sc.next().charAt(0));
			
		}
		
		 board=new Board(player1.getSymbol(),player2.getSymbol());
		
		boolean isplayer1=true;
		int status=board.Incomplete;
		
		
		while(status==board.Invalid || status==board.Incomplete) {
			if(isplayer1) {
				System.out.println("Player1 "+player1.getName()+"'s turn");
			
			    System.out.println("Enter the co_ordinate");
			     int x=sc.nextInt();
			     int y=sc.nextInt();
			
			
			status=board.move(player1.getSymbol(),x,y);
			board.printboard();
			if(status==board.Invalid) {
				System.out.println("Enter the correct coordinates");
				
			}
			else {
				isplayer1=false;
			}
			}
			else {
				System.out.println("Player2 "+player2.getName()+"'s turn");
				
			    System.out.println("Enter the  co_ordinate");
			     int x=sc.nextInt();
			     int y=sc.nextInt();
			
		     status=board.move(player2.getSymbol(),x,y);
		     board.printboard();
		     if(status==board.Invalid) {
					System.out.println("Enter the correct coordinates");
					
				}
				else {
					isplayer1=true;
				}
				
			}
			
			
			
		}
		if(status==board.Player1Wins) {
			System.out.println("Player1"+player1.getName()+" wins!!");
		}
		else if(status==board.Player2Wins) {
			System.out.println("Player2"+player2.getName()+" wins!!");
		}
		else {
			System.out.println("Draw");	
		}	
		
	}
	
	private Player takeplayerInput(int n) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Player name:");
		String name=sc.nextLine();
		System.out.println("Enter player symbol");
		char symbol=sc.next().charAt(0);
		
		Player P=new Player(name,symbol);
		return P;
		
		
	}

}
