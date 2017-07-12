package blackjack;

public class Main{
  public static void main(String[] args) {
    String playerName = "MacPlayer";
    int playerStandLevel = 16;
    if(args != null)
    {
      if(args.length == 2)
      {
        playerName = args[0];
        playerStandLevel = Integer.parseInt(args[1]);
      }
    }
    Game game = new Game(playerName, playerStandLevel);
    game.play();
  }
}