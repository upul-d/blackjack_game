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

}