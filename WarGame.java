import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class WarGame {
	
	private Player p1;
	private Player p2;
	private Stack<Card> warPile = new Stack<Card>();
	final Deck deck = new Deck();

	public WarGame() {
		p1 = new Player();
		p2 = new Player();
		warPile.clear();
	}
	
	public boolean isEmpty() {
		if(p1.isEmpty()||p2.isEmpty()) {
			return(true);
		}
		else {
			return(false);
		}
	}
	
	public Card seePlayer1Card() {
		return(p1.seeCurrentCard());
	}
	
	public Card seePlayer2Card() {
		return(p2.seeCurrentCard());
	}
	

	public void gameDeal() {
		deck.shuffle();
		while(!(deck.isEmpty())) {
			Card card = deck.deal();
			p1.addToUnplayed(card);
			card = deck.deal();
			p2.addToUnplayed(card);
		}
		
	}
	public String toString() {
		String str = "Player 1:\n" + p1.toString() + "\nUnplayed Pile: " +
				p1.getUnplayedSize() + "\n\nPlayer 2:\n" + p2.toString() + "\nUnplayed Pile: "
				 + p2.getUnplayedSize() + "\n\nWar Pile: " + warPile.size();
				
		return(str);
	}
	
	public void step() {
		Card p1Card = p1.getCurrentCard();
		Card p2Card = p2.getCurrentCard();
		warPile.push(p1Card);
		warPile.push(p2Card);
		
        if (p1Card.getRank() > p2Card.getRank()){
		//if (p1Card.compareTo(p2Card) > 0) {
        	p1.addToWinnings(warPile);
        	warPile.clear();
        	
        }
        else if(p2Card.getRank() > p1Card.getRank()) {
		//else if (p1Card.compareTo(p2Card) < 0) {
        	p2.addToWinnings(warPile);
        	warPile.clear();
        }
        
        else {
        	this.step();
        }
      
}
	public String whoWon() {
		int p1winnings = p1.getWinnings();
		int p2winnings = p2.getWinnings();
		String winner = "";
		if (p1.getWinnings()<p2.getWinnings()) {
    		  winner = " Player 2 won!";
    	  }
    	else if(p1.getWinnings() >p2.getWinnings()) {
    		  winner = " Player 1 won!";
    	  }
    	else if(p1.getWinnings()==p2.getWinnings()) {
    		  winner = " It's a tie!";
    	  }
		return(winner);
		
			
	}
	
}