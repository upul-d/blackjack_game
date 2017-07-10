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

  public void dealCard(GameActor gameActor) {
    Card dealtCard = deck.getCard();
    gameActor.receiveCard(dealtCard.getRank(), dealtCard.getSuit(), dealtCard.getMinValue(), dealtCard.getMaxValue());
    deck.removeCard();
  }
  
  public int checkAllScores() {
    // to be written
    return 0;
  }

}