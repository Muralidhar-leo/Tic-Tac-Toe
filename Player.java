package Game;

public class Player {
	private String Name;
	private char Symbol;
	
	public Player(String Name,char Symbol) {
		setName(Name);
		setSymbol(Symbol);
		
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public char getSymbol() {
		return Symbol;
	}

	public void setSymbol(char symbol) {
		Symbol = symbol;
	}

}
