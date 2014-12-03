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
   //important objects
   private WarGame game;
   
   //Reused images
   private Icon faceDown = new ImageIcon("cardPics//back.jpg");
   
   //Variable feilds
   private JLabel roundLabel, winnerLabel;
   private JButton warButton, battleButton;
   private JLabel blueCardLabel, redCardLabel;
   private JLabel blueDeckLabel, redDeckLabel;
   private JLabel blueWarLabel, redWarLabel;
   private JLabel blueBattles, redBattles;
   
 
   /**
   Constructor
   */
   public WarGUI()
   {
      
      //Create a game of war
      game = new WarGame();
      
      //Set up main window
      setTitle("The Game of War");
      
      setLayout(new BorderLayout());
      
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      setVisible(true);
      
      //window contents ###############
      //NORTH Panel
      JPanel northPanel = new JPanel();
      
      roundLabel = new JLabel("Round: 1");
      northPanel.add(roundLabel, JLabel.CENTER);
      
      add(northPanel, BorderLayout.NORTH);
      
      
      //WEST
      JPanel westPanel = new JPanel();
      westPanel.setBackground(new Color(70,150,255));
      
      blueDeckLabel = new JLabel("Blue's Deck: 26", faceDown, JLabel.CENTER);
      westPanel.add(blueDeckLabel);
      
      blueBattles = new JLabel(" Cards Won: 0");
      westPanel.add(blueBattles);

      add(westPanel, BorderLayout.WEST);
      
      
      //EAST
      JPanel eastPanel = new JPanel();
      eastPanel.setBackground(new Color(255,50,50));
      
      redDeckLabel = new JLabel("Blue's Deck: 26", faceDown, JLabel.CENTER);
      eastPanel.add(redDeckLabel);
      
      redBattles = new JLabel(" Cards Won: 0");
      eastPanel.add(redBattles);

      add(eastPanel, BorderLayout.EAST);
      
      
      //CENTER
      JPanel centerPanel = new JPanel(new GridLayout(2,3));
      
      blueCardLabel = new JLabel(faceDown);
      winnerLabel = new JLabel("Winner", JLabel.CENTER);
      redCardLabel = new JLabel(faceDown);
      blueWarLabel = new JLabel("War Zone: 0");
      warButton = new JButton("War Button");
      warButton.addActionListener(new ButtonListener());
      warButton.setEnabled(false);
      redWarLabel = new JLabel("War Zone: 0");
      
      //add to center grid
      centerPanel.add(blueCardLabel);
      centerPanel.add(winnerLabel);
      centerPanel.add(redCardLabel);
      centerPanel.add(blueWarLabel);
      centerPanel.add(warButton);
      centerPanel.add(redWarLabel);
      
      add(centerPanel, BorderLayout.CENTER);
      
      
      //SOUTH
      JPanel southPanel = new JPanel();
      
      battleButton = new JButton("BATTLE!");
      battleButton.addActionListener(new ButtonListener());
      southPanel.add(battleButton);
      add(southPanel, BorderLayout.SOUTH);
      
      
      //Pack window
      pack();
      
   }//END CONSTRUCTOR
   
   
   //Update board
   public void update(boolean war, Discard blueWin, Discard redWin, 
         Discard blueWar, Discard redWar, 
         Card blueCard, Card redCard, Deck blueDeck, Deck redDeck, int round, String winner)
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
      
      blueDeckLabel.setText("Blue's Deck: " + blueDeck.getSize());
      redDeckLabel.setText("Red's Deck: " + redDeck.getSize());
      
      blueWarLabel.setText("War Zone: " + blueWar.getSize());
      redWarLabel.setText("War Zone: " + redWar.getSize());
      
      blueBattles.setText(" Cards Won: " + blueWin.getSize());
      redBattles.setText(" Cards Won: " + redWin.getSize());
   }
   
   
   class ButtonListener implements ActionListener{
      public void actionPerformed (ActionEvent e) {
         JButton b = (JButton)(e.getSource());
         
         //Battle button press
         if (e.getSource() == battleButton)
         {
            //take turn
            game.takeTurn();
            
            //update gui *******IN PROGRESS**********
            update(game.isTie(), game.getBlueDiscard(), game.getRedDiscard(), 
               game.getBlueWar(), game.getRedWar(), game.getBlueCard(), game.getRedCard(), 
               game.getBlueDeck(), game.getRedDeck(), game.getRound(), game.getWinner());
         }
         
         if (e.getSource() == warButton)
         {
            //take turn
            game.doWar();
            
            //update gui *******IN PROGRESS**********
            update(game.isTie(), game.getBlueDiscard(), game.getRedDiscard(), 
               game.getBlueWar(), game.getRedWar(), game.getBlueCard(), game.getRedCard(), 
               game.getBlueDeck(), game.getRedDeck(), game.getRound(), game.getWinner());
         }
      }  
   }
   
   
   //main method
   public static void main(String [] args)
   {
      WarGUI gui = new WarGUI();
   }
   
}
