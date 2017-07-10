package blackjack_behaviours;
import blackjack.*;

public interface Dealable {
  
  void dealCard(GameActor gameActor);
  int checkAllScores();

}