package blackjack_behaviours;
import blackjack.*;

public interface Playable {
  
  void receiveCard(Rank rank, Suit suit, int min, int max);
  int showScore();

}