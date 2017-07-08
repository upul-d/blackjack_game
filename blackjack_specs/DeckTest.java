import static org.junit.Assert.*;
import org.junit.*;
import blackjack.*;

public class DeckTest {

  Deck deck;

  @Before
  public void before() {
    deck = new Deck();
  }

  @Test
  public void has52Cards() {
    assertEquals(52, deck.getCount());
  }

  @Test
  public void canGetCardFromDeck()
  {
    assertEquals(Suit.CLUBS, deck.getCard(0).getSuit());
    assertEquals(Rank.TWO, deck.getCard(0).getRank());
  }

}