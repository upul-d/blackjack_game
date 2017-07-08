package blackjack;
import java.util.ArrayList;

public class Deck {

  private ArrayList<Card> deck;

  public Deck() {
    deck = new ArrayList<Card>();
    makeDeck();
  }

  private void makeDeck() {
    for (Rank rank : Rank.values()) {
      for (Suit suit : Suit.values()) {
        int minValue = Rule.getMinCardValue(rank, suit);
        int maxValue = Rule.getMaxCardValue(rank, suit);
        Card card = new Card(rank, suit, minValue, maxValue);
        deck.add(card);
      }
    }
  }

  public int getCount() {
    return deck.size();
  }

  public Card getCard() {
    return deck.get(48);
  }

}
