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

  public int getCount() {
    return hand.size();
  }

  @Override
  public String toString() {
    String output = "";
    int min = 0;
    int max = 0;
    for (Card card : hand) {
      min += card.getMinValue();
      max += card.getMaxValue();
      output += card.toString();
    }
    output += "Current min total = " + min + ", current max total = " + max + "\n";

    return output;
  }

  public int showScore() {
      int sum = 0;    
      int intMinTotal = 0;
      int intMaxTotal = 0;
      for (Card card : hand) {
          intMinTotal += card.getMinValue();
          intMaxTotal += card.getMaxValue();
      }
      
      if(intMinTotal <= 21 && intMaxTotal <= 21){
          sum = Math.max(intMinTotal, intMaxTotal);
      }else if(intMinTotal <= 21){
          sum = intMinTotal;
      }else{
          sum = intMaxTotal;
      }

      return sum;
    }
}