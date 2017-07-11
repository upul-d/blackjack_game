import static org.junit.Assert.*;
import org.junit.*;
import blackjack.*;
import java.util.Random;

public class DealerTest {

  Dealer dealer;
  Deck testDeck;
  Player testPlayer;

  @Before
  public void before() {
    dealer = new Dealer("Boris 'The Blade' Yurinov");
    testDeck = new Deck(new Random(5));
    dealer.setDeck(testDeck);
    testPlayer = new Player("Mickey O'Neil");
  }

  @Test
  public void hasName() {
    assertEquals("Boris 'The Blade' Yurinov", dealer.getName());
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
    assertEquals("FOUR of CLUBS (min = 4, max = 4);", testPlayer.toString());
    dealer.dealCard(dealer);
    assertEquals(1, dealer.getCount());
    assertEquals("KING of CLUBS (min = 10, max = 10);", dealer.toString());
  }

  @Test
  public void canCalculateScore() {
    dealer.dealCard(dealer);
    assertEquals("FOUR of CLUBS (min = 4, max = 4);", dealer.toString());
    dealer.dealCard(dealer);
    assertEquals("FOUR of CLUBS (min = 4, max = 4);KING of CLUBS (min = 10, max = 10);", dealer.toString());
    assertEquals(14, dealer.showScore());
  }

  @Test
  public void canCalculatePlayerScore() {
    dealer.dealCard(testPlayer);
    dealer.dealCard(testPlayer);
    dealer.dealCard(testPlayer);
    assertEquals(17, testPlayer.showScore());
  }

}