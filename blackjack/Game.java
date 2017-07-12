package blackjack;

public class Game{

  private String playerName;
  private int playerStandLevel;

  public Game(String playerName, int playerStandLevel){
    this.playerName = playerName;
    this.playerStandLevel = playerStandLevel;
    System.out.println(playerName + " is the player.\n" + playerName + " has chosen a minimum stand score of " + this.playerStandLevel + ".");
  }

  public void play()
  {
    System.out.println("Let's set up the game!");

    Player player = new Player(playerName);
    System.out.println("Finished setting up the system for " + player.getName() + " to play.");
    Dealer dealer = new Dealer("MacDealer");
    System.out.println("Finished setting up the system for the computer, " + dealer.getName() + ", to play :-)");
    Deck deck = new Deck();
    dealer.setDeck(deck);
    System.out.println("Finished setting up the deck");

    dealer.dealCard(player);
    dealer.dealCard(player);
    System.out.println(dealer.getName() + " dealt two cards to " + player.getName() + ".");

    dealer.dealCard(dealer);
    dealer.dealCard(dealer);
    System.out.println(dealer.getName() + " dealt two cards to itself.");

    automateHumanPlayer(player, dealer);

    if(player.showScore() > 21)
    {
      System.out.println("Game over..." + dealer.getName() + " is the winner!");
    }else
    {
      automateComputerPlayer(player, dealer);
      checkWinner(dealer.compareScores(player));
    }
  }

  private void checkWinner(GameActor winner)
  {
    if(winner == null)
    {
      System.out.println("Game over...it's a draw!");
    }else
    {
      System.out.println("Game over..." + winner.getName() + " is the winner!");
    }
  }


  private void automateHumanPlayer(Player player, Dealer dealer)
  {
    System.out.println("\n" + player.getName() + "'s current hand:\n" + player.toString());

    while(player.showScore() <= playerStandLevel)
    {
      dealer.dealCard(player);
      System.out.println(player.getName() + "'s hand after getting a card:\n" + player.toString());
    }

    if(player.showScore() > 21)
    {
      System.out.println(player.getName() + " is bust! " +  player.getName() + "'s final score is: " + player.showScore());
    }else if (player.showScore() == 21) {
      System.out.println(player.getName() + " has 21. Let's see what " + dealer.getName() + " will end up on.");
    }else 
    {
      System.out.println(player.getName() + " is not bust but has met the chosen stand score. " + player.getName() + " can't twist. " + player.getName() + "'s final score is: " + player.showScore());
    } 
  }

  private void automateComputerPlayer(Player player, Dealer dealer)
    {
      System.out.println("\n" + dealer.getName() + "'s current hand:\n" + dealer.toString());

      while(dealer.showScore() < 17)
      {
        dealer.dealCard(dealer);
        System.out.println(dealer.getName() + "'s hand after getting a card:\n" + dealer.toString());
      }

      if(dealer.showScore() > 21)
      {
        System.out.println(dealer.getName() + " is bust! " +  dealer.getName() + "'s final score is: " + dealer.showScore());
      }else {
          System.out.println(dealer.getName() + " is not able to twist anymore. " + dealer.getName() + "'s final score is: " + dealer.showScore());
      }  
    }

}