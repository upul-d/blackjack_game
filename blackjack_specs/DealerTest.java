import static org.junit.Assert.*;
import org.junit.*;
import blackjack.*;

public class DealerTest {

  Dealer dealer;
  Deck testDeck;
  Player testPlayer;

  @Before
  public void before() {
    dealer = new Dealer("Boris 'The Blade' Yurinov");
    testDeck = new Deck();
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

}