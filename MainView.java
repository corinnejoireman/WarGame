import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * THe main window for dispalying the game of war
 * @author Rinn Joireman, Bethany Reitsma, Pengrui Wang, George Barker
 *
 */
public class MainView extends JFrame{
	
	private WarGame g = new WarGame();
	
    public MainView(){

        final Deck deck = new Deck();
        deck.shuffle();
	    final CardPanel player1 = new CardPanel();
	    final CardPanel player2 = new CardPanel();
	    final JTextArea status = new JTextArea();
	    final JTextField p1 = new JTextField();
	    final JTextField p2 = new JTextField();
	    final JTextField gameStat = new JTextField();
	    final Panel blank = new Panel();
	    g.gameDeal();
	    
        JButton move = new JButton("Move");
        move.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
              if (! g.isEmpty()){
            	  g.step();
                  Card card1 = g.seePlayer1Card();
                  Card card2 = g.seePlayer2Card();
                  card1.turn();
                  card2.turn();
                  player1.setCard(card1);
                  player2.setCard(card2);
                  status.setText(g.toString());
               
               }
              else {
            	  status.setText(g.toString());
             	  String winner = g.whoWon();
            	  JOptionPane.showMessageDialog(MainView.this,
                          "Game Over!" + winner);

              }
           }});
        

        JButton end = new JButton("End");
        end.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
        	   	g = new WarGame();
                g.gameDeal();
                player1.setCard(null);
                player2.setCard(null);
                status.setText("Game Over! Press Move to start new game!");
              }
        });
        
	    Container c = getContentPane();
	    c.setLayout(new GridLayout (3,3));
	    status.setEditable(false);
	    p1.setText("Player 1");
	    p2.setText("Player 2");
	    gameStat.setEditable(false);
	    p1.setEditable(false);
	    p2.setEditable(false);
	    gameStat.setText("Game Status");
	    p1.setHorizontalAlignment(JTextField.CENTER);
	    p2.setHorizontalAlignment(JTextField.CENTER);
	    gameStat.setHorizontalAlignment(JTextField.CENTER);
	   
	    
	    c.add(p1);
	    c.add(gameStat);
	    c.add(p2);
	    c.add(player1);
	    c.add(status);
	    c.add(player2);
	    c.add(move);
	    c.add(blank);
	    c.add(end);

	    
    }

}
