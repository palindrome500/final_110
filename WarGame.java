/*
Matthew Pereira
This class will work out the main logic for the game of War

The game is run from here
*/

/**
BUG LOG

-DECKS ONLY TAKE TWO CARDS
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
   static final int HALF_DECK = 26, FULL_DECK = 52;
   static final String BLUE_WINS = "BLUE WINS!", RED_WINS = "RED WINS!";
   
   //Class variables
   
   public static void main(String [] args)
   {
      //MAIN varirables#########################
      boolean endGame = false, isTie;
      int blueWin = 0, redWin = 0;
      int round = 0;
      Card blueInPlay, redInPlay; //Represents the cards in play
      String winner = "";
      Scanner keyboard = new Scanner(System.in); //Get keyboard input
      String proceed; //press enter to continue
      
      
      //PRE_GAME SET-UP********************************************
      //Make dealer deck
      Dealer dealer = new Dealer();
      
      //Shuffle dealer deck
      dealer.shuffle();
      
      //Create player decks
      Deck blueDeck = new Deck();
      Deck redDeck = new Deck();
      
      //Deal out half of dealer deck to each player
      dealCards(dealer, blueDeck);
      dealCards(dealer, redDeck);
      
      //Create discard pile for each player
      Discard blueDiscard = new Discard();
      Discard redDiscard = new Discard();
      
      //Create WAR pile for each player
      Discard blueWar = new Discard();
      Discard redWar = new Discard();
      
      
      //CREATE GUI
      WarGUI window = new WarGUI();
      
      
      //Start MAIN GAME LOOP //While winner == false &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
      while(!endGame)
      {
         
         //If there are still cards to draw
         if(!blueDeck.isEmpty() && !redDeck.isEmpty())
         {
            //Get player's ok for next draw
            round++;
            System.out.println("Press enter to draw a card");
            proceed = keyboard.next();
            
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
               window.update(isTie, blueDiscard.getSize(), redDiscard.getSize(), blueWar.getSize(), redWar.getSize(), blueInPlay, redInPlay, blueDeck.getSize(), redDeck.getSize(), round, winner);
               
            }//end if not a tie
            
                  
            //Else a tie: go into WAR mode
            else
            {
               isTie = true;
               
               //While there are only ties
               while(isTie)
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
               }//END WAR LOOP
            }//end else a tie
         }//end if still cards
         
         //Else if no more cards
         else
         {
            endGame = true;
         }
         
      }//END MAIN GAME LOOP
      
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
      
   }
   
   /**
   dealCards gives cards to the player
   */
   public static Deck dealCards(Dealer dealer, Deck player)
   {
      for(int i = 0; i < HALF_DECK; i++)
      {
         player.returnCard(dealer.deal());
      }
      
      return player;
   }
   
}
