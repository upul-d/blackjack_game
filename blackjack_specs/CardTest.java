import static org.junit.Assert.*;
import org.junit.*;
import blackjack.*;

public class CardTest {
  
  Card card;

  @Before
  public void before() {
    card = new Card(Rank.ACE, Suit.CLUBS, 1, 11);
  }

  @Test
  public void hasRank() {
    assertEquals(Rank.ACE, card.getRank());
  }

  @Test
  public void hasSuit() {
    assertEquals(Suit.CLUBS, card.getSuit());
  }

  @Test
  public void hasMinValue() {
    assertEquals(1, card.getMinValue());
  }

  @Test
  public void hasMaxValue() {
    assertEquals(11, card.getMaxValue());
  }

  @Test
  public void convertCardToString() {
    assertEquals("ACE of CLUBS (min = 1, max = 11);", card.toString());
  }

}
