import java.util.Scanner;

public class Main 
{

  // plays a card game
  public static void playAGame(Board board)
  {
	CardGameConsole console = new CardGameConsole(board);
	console.playGame();
  }
  
  public static void main(String[] args) 
  {
    
    // ask the use to choose a game to play...
	Scanner scan = new Scanner(System.in);
	System.out.println("TWELVES: Either pair adds to 12, or you remove a jack. Ace = 1, Queen = 6, King = 11");
	System.out.print("Pick a Game (Elevens, Twelves, Thirteens): ");
	String game = scan.next();
	Board board = null;
	if(game.equalsIgnoreCase("elevens")) {
		board = new ElevensBoard();
	}
	if(game.equalsIgnoreCase("twelves")) {
		board = new TwelvesBoard();
		}
	if(game.equalsIgnoreCase("thirteens")) {
		board = new ThirteensBoard();
	}

	if (board != null) {
		playAGame(board);
	} else {
		System.out.println("Invalid Gametype");
	}
  }
}
