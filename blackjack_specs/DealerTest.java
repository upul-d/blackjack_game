import static org.junit.Assert.*;
import org.junit.*;
import blackjack.*;
import java.util.Random;

public class DealerTest {

  private static final String DEALERNAME = "Boris 'The Blade' Yurinov";
  private static final String PLAYERNAME = "Mickey O'Neil";
  private static final String FOUROFCLUBS = "FOUR of CLUBS (min = 4, max = 4);";
  private static final String KINGOFCLUBS = "KING of CLUBS (min = 10, max = 10);";


  Dealer dealer;
  Deck testDeck;
  Player testPlayer;

  @Before
  public void before() {
    dealer = new Dealer(DEALERNAME);
    testDeck = new Deck(new Random(5));
    dealer.setDeck(testDeck);
    testPlayer = new Player(PLAYERNAME);
  }

  @Test
  public void hasName() {
    assertEquals(DEALERNAME, dealer.getName());
  }

  @Test
  public void canReceiveCard() {
    dealer.dealCard(dealer);
    assertEquals(1, dealer.getCount());
    assertEquals(51, testDeck.getCount());
  }

  @Test
  public void playerCanReceiveCard() {
    dealer.dealCard(testPlayer);
    assertEquals(1, testPlayer.getCount());
    assertEquals(51, testDeck.getCount());
  }

  @Test
  public void canGetGameActorHandAsString() {
    dealer.dealCard(testPlayer);
    assertEquals(1, testPlayer.getCount());
    assertEquals(FOUROFCLUBS, testPlayer.toString());
    dealer.dealCard(dealer);
    assertEquals(1, dealer.getCount());
    assertEquals(KINGOFCLUBS, dealer.toString());
  }

  @Test
  public void canCalculateScore() {
    dealer.dealCard(dealer);
    assertEquals(FOUROFCLUBS, dealer.toString());
    dealer.dealCard(dealer);
    assertEquals(FOUROFCLUBS+KINGOFCLUBS, dealer.toString());
    assertEquals(14, dealer.showScore());
  }

  @Test
  public void canCalculatePlayerScore() {
    dealer.dealCard(testPlayer);
    dealer.dealCard(testPlayer);
    dealer.dealCard(testPlayer);
    assertEquals(17, testPlayer.showScore());
  }

  @Test
  public void canCompareScoresDrawBothHave21() {
    Card newDealtCard1 = new Card(Rank.QUEEN,Suit.DIAMONDS,10,10);
    Card newDealtCard2 = new Card(Rank.ACE,Suit.CLUBS,1,11);

    testPlayer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    testPlayer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    testPlayer.receiveCard(newDealtCard2.getRank(), newDealtCard2.getSuit(), newDealtCard2.getMinValue(), newDealtCard2.getMaxValue());
    assertEquals(21, testPlayer.showScore());

    dealer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    dealer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    dealer.receiveCard(newDealtCard2.getRank(), newDealtCard2.getSuit(), newDealtCard2.getMinValue(), newDealtCard2.getMaxValue());
    assertEquals(21, dealer.showScore());

    assertEquals(null, dealer.compareScores(testPlayer));
  }

  @Test
  public void canCompareScoresDrawBothBust() {
    Card newDealtCard1 = new Card(Rank.QUEEN,Suit.DIAMONDS,10,10);
    Card newDealtCard2 = new Card(Rank.ACE,Suit.CLUBS,1,11);
    
    dealer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    dealer.receiveCard(newDealtCard2.getRank(), newDealtCard2.getSuit(), newDealtCard2.getMinValue(), newDealtCard2.getMaxValue());
    dealer.receiveCard(newDealtCard2.getRank(), newDealtCard2.getSuit(), newDealtCard2.getMinValue(), newDealtCard2.getMaxValue());
    assertEquals(22, dealer.showScore());

    testPlayer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    testPlayer.receiveCard(newDealtCard2.getRank(), newDealtCard2.getSuit(), newDealtCard2.getMinValue(), newDealtCard2.getMaxValue());
    testPlayer.receiveCard(newDealtCard2.getRank(), newDealtCard2.getSuit(), newDealtCard2.getMinValue(), newDealtCard2.getMaxValue());
    assertEquals(22, testPlayer.showScore());
    
    assertEquals(null, dealer.compareScores(testPlayer));
  }

  @Test
  public void canCompareScoresDrawNeitherBust() {
    Card newDealtCard1 = new Card(Rank.QUEEN,Suit.DIAMONDS,10,10);
    Card newDealtCard2 = new Card(Rank.ACE,Suit.CLUBS,1,11);

    dealer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    assertEquals(10, dealer.showScore());

    testPlayer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    assertEquals(10, testPlayer.showScore());

    assertEquals(null, dealer.compareScores(testPlayer));
  }

  @Test
  public void canCompareScoresDealerBustPlayerNotBust() {
    Card newDealtCard1 = new Card(Rank.QUEEN,Suit.DIAMONDS,10,10);
    Card newDealtCard2 = new Card(Rank.ACE,Suit.CLUBS,1,11);

    dealer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    dealer.receiveCard(newDealtCard2.getRank(), newDealtCard2.getSuit(), newDealtCard2.getMinValue(), newDealtCard2.getMaxValue());
    dealer.receiveCard(newDealtCard2.getRank(), newDealtCard2.getSuit(), newDealtCard2.getMinValue(), newDealtCard2.getMaxValue());
    assertEquals(22, dealer.showScore());

    testPlayer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    assertEquals(10, testPlayer.showScore());

    assertEquals(PLAYERNAME, dealer.compareScores(testPlayer).getName());
  }

  @Test
  public void canCompareScoresPlayerBustDealerNotBust() {
    Card newDealtCard1 = new Card(Rank.QUEEN,Suit.DIAMONDS,10,10);
    Card newDealtCard2 = new Card(Rank.ACE,Suit.CLUBS,1,11);

    testPlayer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    testPlayer.receiveCard(newDealtCard2.getRank(), newDealtCard2.getSuit(), newDealtCard2.getMinValue(), newDealtCard2.getMaxValue());
    testPlayer.receiveCard(newDealtCard2.getRank(), newDealtCard2.getSuit(), newDealtCard2.getMinValue(), newDealtCard2.getMaxValue());
    assertEquals(22, testPlayer.showScore());

    dealer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    assertEquals(10, dealer.showScore());

    assertEquals(DEALERNAME, dealer.compareScores(testPlayer).getName());
  }

  @Test
  public void canCompareScoresPlayerBeatsDealerNeitherBust() {
    Card newDealtCard1 = new Card(Rank.QUEEN,Suit.DIAMONDS,10,10);
    Card newDealtCard2 = new Card(Rank.ACE,Suit.CLUBS,1,11);

    dealer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    assertEquals(10, dealer.showScore());

    testPlayer.receiveCard(newDealtCard2.getRank(), newDealtCard2.getSuit(), newDealtCard2.getMinValue(), newDealtCard2.getMaxValue());
    assertEquals(11, testPlayer.showScore());

    assertEquals(PLAYERNAME, dealer.compareScores(testPlayer).getName());
  }

  @Test
  public void canCompareScoresDealerBeatsPlayerNeitherBust() {
    Card newDealtCard1 = new Card(Rank.QUEEN,Suit.DIAMONDS,10,10);
    Card newDealtCard2 = new Card(Rank.ACE,Suit.CLUBS,1,11);

    testPlayer.receiveCard(newDealtCard1.getRank(), newDealtCard1.getSuit(), newDealtCard1.getMinValue(), newDealtCard1.getMaxValue());
    assertEquals(10, testPlayer.showScore());

    dealer.receiveCard(newDealtCard2.getRank(), newDealtCard2.getSuit(), newDealtCard2.getMinValue(), newDealtCard2.getMaxValue());
    assertEquals(11, dealer.showScore());

    assertEquals(DEALERNAME, dealer.compareScores(testPlayer).getName());
  }

}