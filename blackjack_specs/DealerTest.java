import static org.junit.Assert.*;
import org.junit.*;
import blackjack.*;

public class DealerTest {

  Dealer dealer;

  @Before
  public void before() {
    dealer = new Dealer("Boris 'The Blade' Yurinov");
    dealer.setDeck(new Deck());
  }

  @Test
  public void hasName() {
    assertEquals("Boris 'The Blade' Yurinov", dealer.getName());
  }

  @Test
  public void canReceiveCard() {
    dealer.dealCard(dealer);
    assertEquals(1, dealer.getCount());
  }

}