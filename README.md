# Java Blackjack Game

This was my second project at CodeClan: a blackjack game which runs in the terminal.

Built using: Java
Tested using: JUnit

This app first met, then exceeded the MVP specificiations. For example, a Runner to actually play the game was not part of the MVP.


# The MVP Requirements:

1.  Deal two cards to the dealer and the player
2.  Compare the hands
3.  Determine the winner by checking who has the highest value hand


# Additional Features Achieved:

These focused on on adding more interactivity, providing more information to the player, and building in some of the more complex rules of Blackjack:

1.  The game can be played in the terminal by a human player, against an automated dealer
2.  The player can choose to stand/stick or hit/twist 
3.  To aid decision-making, the player's score can be seen in the terminal at all times after the initial deal
4.  In addition to all win conditions, the game logic accounts for all lose and draw conditions
5.  Always see their score
6.  As per the rules of Blackjack, the dealer must hit if on a score of less than 17, and must stand if on a score of 17 or more
7.  As per the rules, the dealer is only dealt cards after the player has chosen to stand or is bust


# Setup instructions:

After cloning/downloading the repository, please go to its root directory in your terminal. 

Then, to run the tests, please run the shell script by entering the following command:

```./run.sh```

To play the game, please enter the following command and follow the game instructions:

```java -cp ./bin blackjack.Main```
