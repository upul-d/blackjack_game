package blackjack;

import java.util.*;

public class Game{

  private String playerName;
  private int playerStandLevel;

  public Game(String playerName){
    this.playerName = playerName;
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

    interactWithHumanPlayer(player, dealer);

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


  private void interactWithHumanPlayer(Player player, Dealer dealer)
  {
      Scanner scanner = new Scanner(System.in);
      boolean twist = true;
      
      System.out.println("\n" + player.getName() + "'s current hand:\n" + player.toString());

      while(askTwistOrStick(player)){

          System.out.println("Would you like to twist or stick (enter T for twist and S for stick)? ");

          String answer = scanner.nextLine();
          
          if(answer.equals("T")){              //User has selected to twist, deal a card to the player
              dealer.dealCard(player);
              System.out.println(player.getName() + "'s hand after getting a card:\n" + player.toString());
          }else if(answer.equals("S")){
              System.out.println(player.getName() + " has decided to stick!");
              break;
          }else{
              System.out.println("'" + answer + "' is not a valid answer.  Please enter 'T' to twist or 'S' to stick");
          }
    }

    if(player.showScore() > 21)
    {
      System.out.println(player.getName() + " is bust! " +  player.getName() + "'s final score is: " + player.showScore());
    }else if (player.showScore() == 21) {
      System.out.println(player.getName() + " has 21. Let's see what " + dealer.getName() + " will end up on.");
    }else 
    {
      System.out.println(player.getName() + " has decided to stick to " + player.showScore());
    } 
  }
  
  private boolean askTwistOrStick(Player player)
  {
      if(player.showScore() < 21)
      {
          return true;
      }else
      {
          return false;
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