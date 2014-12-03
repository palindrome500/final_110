/*
Matthew Pereira
This class will work out the main logic for the game of War

The game is run from here
*/


//NEEDED PACKAGES
import java.util.*;
import java.awt.*;//for gui
import javax.swing.*;
import java.io.*;//file I/O
import java.awt.event.*;


public class WarGame
{
   //CONSTANTS
   static public final int HALF_DECK = 26, FULL_DECK = 52;
   static public final String BLUE_WINS = "BLUE WINS!", RED_WINS = "RED WINS!";
   
   //Class variables
   private boolean endGame = false, isTie = false;
   private int blueWin = 0, redWin = 0;
   private int round = 0;
   private Dealer dealer; //Dealer deck
   private Deck blueDeck, redDeck; //Main player decks
   private Discard blueWar, redWar; //WAR decks
   private Discard blueDiscard, redDiscard;//Discard piles for each player
   private Card blueInPlay, redInPlay; //Represents the cards in play
   private String winner = "";
   private Scanner keyboard = new Scanner(System.in); //Get keyboard input
   private String proceed; //press enter to continue
      
   
   /**
   Constructor
   */
   public WarGame()
   {
      //PRE_GAME SET-UP********************************************
      //Make dealer deck
      dealer = new Dealer();
      
      //Shuffle dealer deck
      dealer.shuffle();
      
      //Create player decks
      blueDeck = new Deck();
      redDeck = new Deck();
      
      //Deal out half of dealer deck to each player
      dealCards(dealer, blueDeck);
      dealCards(dealer, redDeck);
      
      //Create discard pile for each player
      blueDiscard = new Discard();
      redDiscard = new Discard();
      
      //Create WAR pile for each player
      blueWar = new Discard();
      redWar = new Discard();
      
   }//END CONSTRUCTOR
      
   
   
   /**
   takeTurn()
   */  
   public void takeTurn()
   { 
         //If there are still cards to draw
         if(!blueDeck.isEmpty() && !redDeck.isEmpty())
         {
            round++;//Count up one round
            
            //Each player draws a card
            blueInPlay = blueDeck.takeCard();
            redInPlay = redDeck.takeCard();
            
            //Determine winner of battle######################################
            //If not a tie
            if(!(blueInPlay.equals(redInPlay)))
            {
               isTie = false;
               
               //Give both cards to winner's discard pile
               if(blueInPlay.greaterThan(redInPlay))
               {
                  blueDiscard.returnCard(blueInPlay);
                  blueDiscard.returnCard(redInPlay);
                  
                  blueWin++;
                  winner = BLUE_WINS;
               }
               
               else if(redInPlay.greaterThan(blueInPlay))
               {
                  redDiscard.returnCard(blueInPlay);
                  redDiscard.returnCard(redInPlay);
                  
                  redWin++;
                  winner = RED_WINS;
               }
               
               else//Failsafe
                  System.out.println("ERROR IN COMPARING CARDS");
               
               //Update GUI
               //window.update(isTie, blueDiscard.getSize(), redDiscard.getSize(), blueWar.getSize(), redWar.getSize(), blueInPlay, redInPlay, blueDeck.getSize(), redDeck.getSize(), round, winner);
               
            }//end if not a tie
            
                  
            //Else a tie: go into WAR mode
            else
            {
               isTie = true;
               
            }//end else a tie
         }//end if still cards
         
         //Else if no more cards
         else
         {
            endGame = true;
         }
   }//END TAKE TURN
   
   /**
   printWinner()
   */ 
   public void printWinner()
   { 
      //Determine winner (the one with the larger discard pile)
      if(blueDiscard.getSize() > redDiscard.getSize())
      {
         System.out.println(BLUE_WINS);
      }
      
      else if(blueDiscard.getSize() < redDiscard.getSize())
      {
         System.out.println(RED_WINS);
      }
      
      else
      {
         System.out.println("It's a tie");
      }
      
   }//END PRINT WINNER
   
   
   /**
   doWar() puts the game into war
   used when battle ends in tie
   */
   public void doWar()
   {
      //place tieing cards in WAR piles
      blueWar.returnCard(blueInPlay);
      redWar.returnCard(redInPlay);

      //Draw new card for each player
      blueInPlay = blueDeck.takeCard();
      redInPlay = redDeck.takeCard();

      //If cards don't tie
      if(!(blueInPlay.equals(redInPlay)))
      {
         //find winner
         //give in-Play cards and all WAR pile cards to winner's discard deck
         if(blueInPlay.greaterThan(redInPlay))
         {
            blueDiscard.returnCard(blueInPlay);
            blueDiscard.returnCard(redInPlay);

            while(!blueWar.isEmpty() && !redWar.isEmpty())
            {
               blueDiscard.returnCard(blueWar.takeCard());
               blueDiscard.returnCard(redWar.takeCard());
            }
         }

         else if(redInPlay.greaterThan(blueInPlay))
         {
            redDiscard.returnCard(blueInPlay);
            redDiscard.returnCard(redInPlay);

            while(!blueWar.isEmpty() && !redWar.isEmpty())
            {
               redDiscard.returnCard(blueWar.takeCard());
               redDiscard.returnCard(redWar.takeCard());
            }
         }

         //isTie = false
         isTie= false;

      }//Else is tie, continue loop

   }
   
   
   /**
   dealCards() gives cards to the player
   */
   public static Deck dealCards(Dealer dealer, Deck player)
   {
      for(int i = 0; i < HALF_DECK; i++)
      {
         player.returnCard(dealer.deal());
      }
      
      return player;
   }
   
   
   //GETTERS #######################################################################
   
   /**
   isTie()
   */
   public boolean isTie()
   {
      return this.isTie;
   }
   
   /**
   isEndGame() returns endGame
   */
   public boolean isEndGame()
   {
      return this.endGame;
   }
   
   /**
   getRound()
   */
   public int getRound()
   {
      return round;
   }
   
   /**
   getBlueSize()
   */
   public Deck getBlueDeck()
   {
      return blueDeck;
   }
   
   /**
   getRound()
   */
   public Deck getRedDeck()
   {
      return redDeck;
   }
   
   /**
   getWinner()
   returns the winner of the last battle
   */
   public String getWinner()
   {
      return winner;
   }
   
   /**
   getBlueDiscard()
   */
   public Discard getBlueDiscard()
   {
      return blueDiscard;
   }
   
   /**
   getRedDiscard()
   */
   public Discard getRedDiscard()
   {
      return redDiscard;
   }
   
   /**
   getBlueWar()
   */
   public Discard getBlueWar()
   {
      return blueWar;
   }
   
   /**
   getRedWar()
   */
   public Discard getRedWar()
   {
      return redWar;
   }
   
   /**
   getBlueCard()
   */
   public Card getBlueCard()
   {
      return blueInPlay;
   }
   
   /**
   getRedCard()
   */
   public Card getRedCard()
   {
      return redInPlay;
   }
   
   
   //TESTING
   public static void main(String [] args)
   {
      WarGame game = new WarGame();
   }
   
}
