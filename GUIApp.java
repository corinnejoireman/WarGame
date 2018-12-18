import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * The main window for displaying the game of war. Instantiates the model and passes it to
 * the view
 * @author Rinn Joireman, Bethany Reitsma, George Barker, Pengrui Wang
 *
 */
public class GUIApp extends JFrame{

    public static void main(String[] args){
        MainView theGUI = new MainView();
        theGUI.setSize(200, 200);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        theGUI.setVisible(true);
     }

}
