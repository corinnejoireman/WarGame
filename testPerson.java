import java.util.Stack;
public class testPerson {
	public static void main(String[] args) {
  
		Deck deck = new Deck();
		Player p1 = new Player();
		Player p2 = new Player();
		Stack<Card> testWarPile = new Stack<Card>();
		while(!(deck.isEmpty())) {
			Card card = deck.deal();
			p1.addToUnplayed(card);
			card = deck.deal();
			p2.addToUnplayed(card);
		}
  
		System.out.println("\nExpect 26");
		System.out.println(p1.getUnplayedSize());
  
		System.out.println("\nExpect false:");
		System.out.println(p2.isEmpty());
		
		System.out.println("Expect Card" );
		System.out.println(p1.seeCurrentCard());
  
		for (int i = 0; i <= 25; i++) {
			Card currentCard = p1.getCurrentCard();
			testWarPile.add(currentCard);
		}
		p1.addToWinnings(testWarPile);
  
		System.out.println("\nExpect 26");
		System.out.println(p1.getWinnings());
  
		System.out.println("\nExpect 0");
		System.out.println(p1.getUnplayedSize());
  
		System.out.println("\nExpect true");
		System.out.println(p1.isEmpty());

	}
}
