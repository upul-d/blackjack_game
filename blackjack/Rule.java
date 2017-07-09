package blackjack;

public abstract class Rule {

  public static int getMinCardValue(Rank rank, Suit suit) {
    switch(rank) 
    {
      case ACE:
        return 1;

      case TWO:
        return 2;

      case THREE:
        return 3;

      case FOUR:
        return 4;

      case FIVE:
        return 5;

      case SIX:
        return 6;

      case SEVEN:
        return 7;

      case EIGHT:
        return 8;

      case NINE:
        return 9;

      case TEN:
        return 10;

      case JACK:
        return 10;

      case QUEEN:
        return 10;

      case KING:
        return 10;

      default:
        return 0;
    }

  }

  public static int getMaxCardValue(Rank rank, Suit suit) {
    switch (rank) 
    {
      case ACE:
        return 11;

      case TWO:
        return 2;

      case THREE:
        return 3;

      case FOUR:
        return 4;

      case FIVE:
        return 5;

      case SIX:
        return 6;

      case SEVEN:
        return 7;

      case EIGHT:
        return 8;

      case NINE:
        return 9;

      case TEN:
        return 10;

      case JACK:
        return 10;

      case QUEEN:
        return 10;

      case KING:
        return 10;

      default:
        return 0;
    }
      
  }

}

