package blackjack_behaviours;

public interface Playable {
  
  void receiveCard();
  Integer calculateScore();
  Integer showScore();

}