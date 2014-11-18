/*
Matthew Pereira
This class will act as the dealer in a card game
It will be able to:
Create an array of all 52 cards
Shuffle the deck
Hand out a set amount of cards to a set amount of player decks
*/

import java.util.ArrayList;//needed for ArrayList use
import java.util.Random; //Needed for shuffling

public class Dealer
{  
   //CONSTANTS
   public static final int MIN_RANK = 2, DECK_MAX = 51, DECK_MIN = 0;

   //Instance variables
   private ArrayList<Card> deck; //the dealer's deck - stores Card objects
   private int dealIndex; //the current deck the dealer is giving to a player
   private Random rand; //Random number generator
   
   /**
   Constructor
   only constructor - creates deck of 52 cards
   */
   public Dealer()
   {
      //Create array list
      deck = new ArrayList<Card>();
      // create Random object
      rand = new Random();
   
      for (int suit = Card.SPADES; suit <= Card.DIAMONDS; suit++)
      {
         for(int rank = MIN_RANK; rank <= Card.ACE; rank++ )
         {
            Card newCard = new Card(suit, rank);
            deck.add(newCard);
            //System.out.println(newCard); //Debug
         }
      }
      
      dealIndex = DECK_MIN;
   }
   
   /**
   shuffle()
   randomely mixes up cards in dealer deck
   restarts deal Index
   */
   public void shuffle()
   {
      Card temp; //Stores one of the cards while they're swapped
      
      for(int index = 0; index <= DECK_MAX; index++)
      {
         int swapWith = rand.nextInt(DECK_MAX + 1); //get a random index from 0 through 51
         
         temp = deck.get(index); //save current index in temp
         
         deck.set(index, deck.get(swapWith)); //set current index to swapWith
         
         deck.set(swapWith, temp); //copy temp to swapWith
      }
      
      resetDealIndex();
   }
   
   /**
   deal(int cards)
   creates and returns a card from the index indicated by dealIndex
   */
   public Card deal()
   {
      //try
      //{
      //   if (dealIndex > DECK_MAX) //IF
      //      throw new OutOfCardsException("NO MORE CARDS!");
            
      //else
      return deck.get(dealIndex++);//return a card and count up
      //}
      
      // catch(new IndexOutOfBoundsException oob)
//       {
//          System.out.println("ERROR: No more cards to deal./nReset dealIndex or shuffle.")
//          Card errorCard = new Card(Card.SPADES, Card.ACE);
//          return errorCard;
//       }
   }
   
   
   /**
   resetDealIndex()
   */
   public void resetDealIndex()
   {
      dealIndex = DECK_MIN;
   }
   
   
   /**
   getDealIndex()
   */
   public int getDealIndex()
   {
      return dealIndex;
   }
   
//    public static void main(String [] args)
//    {
//       Dealer dealer = new Dealer();
//    }
}
