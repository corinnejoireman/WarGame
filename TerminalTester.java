/**
 * Tester Application that tests the WarGame class
 * @author George Barker, Rinn, Bethany, Pengrui
 *
 */
public class TerminalTester {

	public static void main(String[] args) {
		// Creates a new WarGame class
		WarGame gameTest = new WarGame();
		// Tests isEmpty() method
		System.out.println("Expect True:");
		System.out.println(gameTest.isEmpty()+"\n");
		// Tests gameDeal() and toString() method
		gameTest.gameDeal();
		
		System.out.println("Expect Player 1's card is: "+ gameTest.seePlayer1Card());
		System.out.println("Expect Player 2's card is: "+ gameTest.seePlayer2Card());
		//System.out.println(gameTest.toString());
		// Tests the getPlayer1Card() and getPlayer2Card() methods
		// Tests the step method()
		gameTest.step();
		System.out.println("-------------------");
		System.out.println("Step");
		System.out.println("\nExpect Player 1's card is: "+ gameTest.seePlayer1Card());
		System.out.println("Expect Player 2's card is: "+ gameTest.seePlayer2Card());
		System.out.println(gameTest);
		
		gameTest.step();
		System.out.println("Step");
		System.out.println("\nExpect Player 1's card is: "+ gameTest.seePlayer1Card());
		System.out.println("Expect Player 2's card is: "+ gameTest.seePlayer2Card());
		System.out.println(gameTest);
		// Tests the whoWon() method
		
		System.out.println("If a tie, expect 0. If player 1 has more, expect positive"
				+ " if Player 2 has more, Expect negative.");
		System.out.println(gameTest.whoWon());
	}

}
