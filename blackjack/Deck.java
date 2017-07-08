package blackjack;
import java.util.ArrayList;

public class Deck {

  private ArrayList<Card> deck;

  public Deck() {
    deck = new ArrayList<Card>();
    makeDeck();
  }

  public void makeDeck() {
    for (Rank rank : Rank.values()) {
      for (Suit suit : Suit.values()) {
        Card card = new Card(rank, suit);
        deck.add(card);
      }
    }
  }

  public int getCount() {
    return deck.size();
  }

}
