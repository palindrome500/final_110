/*
Matthew Pereira
This class acts as a deck for a player
It's based on a reference based queue
Needs to work with the Card and Dealer classes
*/

public class Deck
{
   //Instance variables
   Card top, bottom; //Top and bottom cards of the deck
   
   int size; //number of cards in deck
   
   /**
   Constructor
   */
   public Deck()
   {
      top = bottom = null;
   }
   
   /**
   takeCard() (dequeue)takes card from top
   returns card that was taken
   taken card is removed from deck
   */
   public Card takeCard() throws NullPointerException
   {
      Card removeCard = top;
      
      top = top.getNext();
      
      size--;
      
      removeCard.setNext(null);
      
      return removeCard;
   }
   
   /**
   returnCard() (enqueue) adds card to bottom of deck
   */
   public void returnCard(Card newCard)
   {
      if(top != null) //If NOT empty
      {
         bottom.setNext(newCard);
         bottom = newCard;
      }
      else
      {
         top = bottom = newCard;
      }
      
      size++;
   }
   
   /**
   getSize() returns the number of cards in the deck
   */
   public int getSize()
   {
      return size;
   }
   
   /**
   isEmpty()
   */
   public boolean isEmpty()
   {
      return top == null;
   }
}
