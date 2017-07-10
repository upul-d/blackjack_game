import static org.junit.Assert.*;
import org.junit.*;
import blackjack.*;

public class DealerTest {

  Dealer dealer;
  Deck testDeck;

  @Before
  public void before() {
    dealer = new Dealer("Boris 'The Blade' Yurinov");
    testDeck = new Deck();
    dealer.setDeck(testDeck);
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

}