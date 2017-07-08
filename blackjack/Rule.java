package blackjack;

public abstract class Rule {

  public static int getMinCardValue(Rank rank, Suit suit) {

    if (rank == Rank.ACE) {
      return 1;
    }

    if (rank == Rank.TWO) {
      return 2;
    }

    return 0;
  }

  public static int getMaxCardValue(Rank rank, Suit suit) {

    if (rank == Rank.ACE) {
      return 11;
    }

    if (rank == Rank.TWO) {
      return 2;
    }

    return 0;
  }

}

