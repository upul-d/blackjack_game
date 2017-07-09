package blackjack;

public class Card {

  private final Rank rank;
  private final Suit suit;
  private final Integer min;
  private final Integer max;

  public Card(Rank rank, Suit suit, Integer min, Integer max) {
    this.rank = rank;
    this.suit = suit;
    this.min = min;
    this.max = max;
  }

  public Rank getRank() {
    return this.rank;
  }

  public Suit getSuit() {
    return this.suit;
  }

  public int getMinValue() {
    return this.min;
  }

  public int getMaxValue() {
    return this.max;
  }

  @Override
  public String toString() {
    return this.rank.toString() + "," + this.suit.toString() + "," + this.min.toString() + "," + this.max.toString();
  }
}