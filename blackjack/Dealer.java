package blackjack;
import blackjack_behaviours.*;
import java.util.ArrayList;

public class Dealer extends GameActor implements Dealable {

  private String name;
  private Deck deck;
  
  public Dealer(String name) {
    super(name);
  }

  public void setDeck(Deck deck)
  {
    this.deck = deck;
    deck.shuffleDeck();
  }

  public void dealCard() {
    // To be completed
    // Card dealtCard = deck.getCard();
    // receiveCard(dealtCard.rank, dealtCard.suit, dealtCard.min, dealtCard.max);
    // deck.removeCard();

    // To be completed
    // Card dealtCart = deck.getCard();
    // player.receiveCard(dealtCard.rank, dealtCard.suit, dealtCard.min, dealtCard.max);
    // deck.removeCard();
  }
  
  public int checkAllScores() {
    // to be written
    return 0;
  }

}