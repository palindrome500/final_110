/**
Matthew Pereira
This class creates and manages the GUI for the WarGame class
*/


//NEEDED PACKAGES
import java.util.*;
import java.awt.*;//for gui
import javax.swing.*;
import java.io.*;//file I/O
import java.awt.event.*;

public class WarGUI extends JFrame
{
   
   //Reused images
   Icon faceDown = new ImageIcon("cardPics//back.jpg");
   
   //Variable feilds
   JLabel roundLabel, winnerLabel;
   JButton warButton, battleButton;
   JLabel blueCardLabel, redCardLabel;
   JLabel blueDeckLabel, redDeckLabel;
   JLabel blueWarLabel, redWarLabel;
   JLabel blueBattles, redBattles;
   
 
   /**
   Constructor
   */
   public WarGUI()
   {
      
      
      //Set up main window
      JFrame window = new JFrame();
      
      window.setTitle("The Game of War");
      
      window.setLayout(new BorderLayout());
      
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      window.setVisible(true);
      
      //window contents ###############
      //NORTH Panel
      JPanel northPanel = new JPanel();
      
      roundLabel = new JLabel("Round: 1");
      northPanel.add(roundLabel, JLabel.CENTER);
      
      window.add(northPanel, BorderLayout.NORTH);
      
      
      //WEST
      JPanel westPanel = new JPanel();
      westPanel.setBackground(new Color(70,150,255));
      
      blueDeckLabel = new JLabel("Blue's Deck: 26", faceDown, JLabel.CENTER);
      westPanel.add(blueDeckLabel);
      
      blueBattles = new JLabel(" Cards Won: 0");
      westPanel.add(blueBattles);

      window.add(westPanel, BorderLayout.WEST);
      
      
      //EAST
      JPanel eastPanel = new JPanel();
      eastPanel.setBackground(new Color(255,50,50));
      
      redDeckLabel = new JLabel("Blue's Deck: 26", faceDown, JLabel.CENTER);
      eastPanel.add(redDeckLabel);
      
      redBattles = new JLabel(" Cards Won: 0");
      eastPanel.add(redBattles);

      window.add(eastPanel, BorderLayout.EAST);
      
      
      //CENTER
      JPanel centerPanel = new JPanel(new GridLayout(2,3));
      
      blueCardLabel = new JLabel(faceDown);
      winnerLabel = new JLabel("Winner", JLabel.CENTER);
      redCardLabel = new JLabel(faceDown);
      blueWarLabel = new JLabel("War Zone: 0");
      warButton = new JButton("War Button");
      warButton.setEnabled(false);
      redWarLabel = new JLabel("War Zone: 0");
      
      //add to center grid
      centerPanel.add(blueCardLabel);
      centerPanel.add(winnerLabel);
      centerPanel.add(redCardLabel);
      centerPanel.add(blueWarLabel);
      centerPanel.add(warButton);
      centerPanel.add(redWarLabel);
      
      window.add(centerPanel, BorderLayout.CENTER);
      
      
      //SOUTH
      JPanel southPanel = new JPanel();
      
      battleButton = new JButton("BATTLE!");
      southPanel.add(battleButton);
      window.add(southPanel, BorderLayout.SOUTH);
      
      
      //Pack window
      window.pack();
   }
   
   
   //Update board
   public void update(boolean war, int blueWin, int redWin, int blueWar, int redWar, 
         Card blueCard, Card redCard, int blueDeck, int redDeck, int round, String winner)
   {
      if(!war)
      {
         winnerLabel.setText(winner);
         warButton.setEnabled(false);
         battleButton.setEnabled(true);
      }
      else
      {
         winnerLabel.setText("WAR!");
         warButton.setEnabled(true);
         battleButton.setEnabled(false);
      }
      
      //set win-independent fields
      String roundText = "Round: " + round;
      roundLabel.setText(roundText);
      
      
      blueCardLabel.setIcon(new ImageIcon(blueCard.getImage()));
      redCardLabel.setIcon(new ImageIcon(redCard.getImage()));
      
      blueDeckLabel.setText("Blue's Deck: " + blueDeck);
      redDeckLabel.setText("Red's Deck: " + redDeck);
      
      blueWarLabel.setText("War Zone: " + blueWar);
      redWarLabel.setText("War Zone: " + redWar);
      
      blueBattles.setText(" Cards Won: " + blueWin);
      redBattles.setText(" Cards Won: " + redWin);
   }
   
   //
   
}
