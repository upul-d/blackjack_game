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

    if (rank == Rank.ACE) {
      return 11;
    }

    if (rank == Rank.TWO) {
      return 2;
    }

    if (rank == Rank.THREE) {
      return 3;
    }

    if (rank == Rank.FOUR) {
      return 4;
    }

    if (rank == Rank.FIVE) {
      return 5;
    }

    if (rank == Rank.SIX) {
      return 6;
    }

    if (rank == Rank.SEVEN) {
      return 7;
    }

    if (rank == Rank.EIGHT) {
      return 8;
    }

    if (rank == Rank.NINE) {
      return 9;
    }

    if (rank == Rank.TEN) {
      return 10;
    }

    if (rank == Rank.JACK) {
      return 10;
    }

    if (rank == Rank.QUEEN) {
      return 10;
    }

    if (rank == Rank.KING) {
      return 10;
    }

    return 0;
  }

}

