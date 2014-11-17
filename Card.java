/*
Matthew Pereira
Final project
This card class represents a standard playing card. 
It store information on it's rank and suit
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
   
   //FEILDS
   private int rank;
   private int suit;
   
   //CONSTRUCTOR
   /**
   Constructor requires an int for the suit of the card and another int for the rank
   */
   public Card(int suit, int rank)
   {
      this.suit = suit;
      this.rank = rank;
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
}
