/*
Matthew Pereira
This class acts as a discard pile for a player
It's based on a reference based stack
It extends Deck
*/

public class Discard extends Deck
{
   //Instance variables
   //Card top; //Top and bottom cards of the deck (INHERITED)
   
   //int size; //number of cards in deck (INHERITED)
   
   /**
   Constructor
   */
   public Discard()
   {
      super();
   }
   
   /**
   takeCard() (dequeue)takes card from top
   returns card that was taken
   (INHERITED)
   */
   
   /**
   returnCard() (enqueue) adds card to bottom of deck
   */
   public void returnCard(Card newCard)
   {
      if(!isEmpty())
      {
         newCard.setNext(top);
         top = newCard;
      }
      else
      {
         top = newCard;
      }
      
      size++;
   }
   
   /**
   getSize() returns the number of cards in the deck
   (INHERITED)
   */
   
   /**
   isEmpty()
   (INHERITED)
   */
}
