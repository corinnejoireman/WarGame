import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Player extends JPanel {
	
	private Stack<Card> winnings = new Stack<Card>();
	private Stack<Card> unplayed = new Stack<Card>();
	//top card on unplayed pile
	private Card currentCard;
	
	public Player() {
		
	}
	
	public void addToUnplayed(Card c) {
		unplayed.push(c);
		currentCard = c;
	}

	public void addToWinnings(Stack<Card> s) {
		for(Card thing : s) {
			winnings.push(thing);
		}
	}
	
	public Card seeCurrentCard() {
		return(currentCard);
	}
	
	public Card getCurrentCard() {
		currentCard = unplayed.pop();
		return(currentCard);
	}
	public int getWinnings() {
		return(winnings.size());
	}
	
	public int getUnplayedSize() {
		return(unplayed.size());
	}
	
	public boolean isEmpty() {
		if(unplayed.isEmpty()) {
			return(true);
		}
		else {
			return(false);
		}
	}
	
	public String toString() {
		String str = "Current Card: " + currentCard.toString() +
   		 "\nWon Cards:" + winnings.size();	
   		 return(str);
	}

}
