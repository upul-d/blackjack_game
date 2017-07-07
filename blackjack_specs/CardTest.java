import static org.junit.Assert.*;
import org.junit.*;
import blackjack.*;

public class CardTest {
  
  Card card;

  @Before
  public void before() {
    card = new Card(Rank.EIGHT, Suit.CLUBS);
  }

  @Test
  public void hasRank() {
    assertEquals(Rank.EIGHT, card.getRank());
  }

  @Test
  public void hasSuit() {
    assertEquals(Suit.CLUBS, card.getSuit());
  }

}
