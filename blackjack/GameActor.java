package blackjack;
import blackjack_behaviours.*;
import java.util.ArrayList;


public abstract class GameActor implements Playable {

  private String name;
  private ArrayList<Card> hand;
  
  public GameActor(String name) {
    this.name = name;
    hand = new ArrayList<Card>();
  }

  public String getName() {
    return this.name;
  }

  public void receiveCard(Rank rank, Suit suit, int min, int max) {
    hand.add(new Card(rank, suit, min, max));
  }

  public int showScore() {
    // method to be written
    return 0;
  }


}