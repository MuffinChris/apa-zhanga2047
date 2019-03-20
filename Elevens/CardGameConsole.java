import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardGameConsole {

	private Board board;
	
	public CardGameConsole(Board b) {
		
		board = b;
		
	}
	
	public void playGame() {
		Scanner scan = new Scanner(System.in);
		while (!board.gameIsWon()) {
			boardState();
			
			System.out.print("Select Cards (Separate by -): ");
			String input = scan.next();
			System.out.println();
			
			String[] inputs = input.split("-");
			
			List<Integer> selectedInputs = new ArrayList<Integer>();

			for (String s : inputs) {
				selectedInputs.add(Integer.valueOf(s));
			}
			
			if (board.isLegal(selectedInputs)) {
				board.replaceSelectedCards(selectedInputs);
				System.out.println();
				System.out.println("You have replaced cards at indexes: " + selectedInputs.toString());
				System.out.println();
			} else {
				System.out.println();
				System.out.println("----- Illegal Move. -----");
				System.out.println();
			}
		}
		
		System.out.println("YOU WON, CONGRATS!");
		
	}
	
	public void boardState() {
		
		System.out.println("UNDEALT CARDS: " + board.deckSize());
		System.out.println("DEALT CARDS: ");
		int index = 0;
		for (int i : board.cardIndexes()) {
			System.out.print(board.cardAt(i) + "["+ index +"], ");
			index++;
		}
		System.out.println();
	}
	
}
