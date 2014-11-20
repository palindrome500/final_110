/*
Matthew Pereira
Final project
This card class represents a standard playing card. 
It stores information on it's rank and suit
*/

public class Card
{
   //CONSTANTS
   //suits
   static final int SPADES = 1;
   static final int HEARTS = 2;
   static final int CLUBS = 3;
   static final int DIAMONDS = 4;
   
   //ranks
   static final int ACE = 14;
   static final int KING = 13;
   static final int QUEEN = 12;
   static final int JACK = 11;
   
   //REQUIRED FEILDS
   private int rank;
   private int suit;
   
   //NODE FIELDS
   private Card next; //next card in the deck
   
   //CONSTRUCTOR
   /**
   Constructor requires an int for the suit of the card and another int for the rank
   */
   public Card(int suit, int rank)
   {
      this.suit = suit;
      this.rank = rank;
      this.next = null;
   }   
   
   //GETTERS
   /**
   getSuit returns the card's suit as an int
   */
   public int getSuit()
   {
      return suit;
   }
   
   /**
   getRank returns the cards rank as an int
   */
   public int getRank()
   {
      return rank;
   }
   
   //NO SETTERS
   
   //OTHER METHODS
   /**
   toString returns the suit and rank of the string as a string object
   */
   public String toString()
   {
      String suitString = "", rankString = ""; //Stores the rank and suit as strings
      String cardName; // the final card name to return
      
      switch (suit) //determines suitString based on the card's int suit value
      {
         case SPADES: suitString = "Spades";
            break;
         case HEARTS: suitString = "Hearts";
            break;
         case CLUBS: suitString = "Clubs";
            break;
         case DIAMONDS: suitString = "Diamonds";
            break;
         default: suitString = "ERROR"; //return the string "ERROR" if input is invalid
            break;
      }
      
      switch (rank) //determines rankString based on the card's int rank value
      {
         case 2: rankString = "2";
            break;
         case 3: rankString = "3";
            break;
         case 4: rankString = "4";
            break;
         case 5: rankString = "5";
            break;
         case 6: rankString = "6";
            break;
         case 7: rankString = "7";
            break;
         case 8: rankString = "8";
            break;
         case 9: rankString = "9";
            break;
         case 10: rankString = "10";
            break;
         case ACE: rankString = "Ace";
            break;
         case JACK: rankString = "Jack";
            break;
         case QUEEN: rankString = "Queen";
            break;
         case KING: rankString = "King";
            break;
         default: rankString = "ERROR"; //return the string "ERROR" if input is invalid
            break;
      }
      
      cardName = rankString + " of " + suitString;
      
      return cardName;
   }
   
   /**
   equals compares cards based on rank. If they have the same rank, it returns true
   */
   public boolean equals(Card otherCard)
   {
      return (rank == otherCard.getRank());
   }
   
   /**
   greaterThan returns true if this Card object has a greater rank than the input Card
   */
   public boolean greaterThan(Card otherCard)
   {
      return (rank > otherCard.getRank());
   }
   
   /**
   lessThan returns true if this Card object has a lesser rank than the input Card
   */
   public boolean lessThan(Card otherCard)
   {
      return (rank < otherCard.getRank());
   }
   
   /**
   getImage()
   returns the file name of the image that corresponds to this Card
   */
   public String getImage()
   {
      String imageFile = ".jpg";
      
      switch(this.suit)
      {
         case SPADES: imageFile = "s" + imageFile;
            break;
         case HEARTS: imageFile = "h" + imageFile;
            break;
         case CLUBS: imageFile = "c" + imageFile;
            break;
         case DIAMONDS: imageFile = "s" + imageFile;
            break;
      }
      
      switch (this.rank)
      {
         case 2: imageFile = "2" + imageFile;
            break;
         case 3: imageFile = "3" + imageFile;
            break;
         case 4: imageFile = "4" + imageFile;
            break;
         case 5: imageFile = "5" + imageFile;
            break;
         case 6: imageFile = "6" + imageFile;
            break;
         case 7: imageFile = "7" + imageFile;
            break;
         case 8: imageFile = "8" + imageFile;
            break;
         case 9: imageFile = "9" + imageFile;
            break;
         case 10: imageFile = "10" + imageFile;
            break;
         case ACE: imageFile = "ace" + imageFile;
            break;
         case JACK: imageFile = "jack" + imageFile;
            break;
         case QUEEN: imageFile = "queen" + imageFile;
            break;
         case KING: imageFile = "king" + imageFile;
            break;
      }
      
      return "cardPics/" + imageFile;
   }
   
   //NODE METHODS*****************************
   
   /**
   getNext()
   */
   public Card getNext()
   {
      return next;
   }
   
   /**
   setNext()
   */
   public void setNext(Card nextCard)
   {
      next = nextCard;
   }
}
