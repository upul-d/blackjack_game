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
  public void canGetCard() {
    assertEquals(Suit.CLUBS, deck.getCard().getSuit());
    assertEquals(Rank.TWO, deck.getCard().getRank());
    assertEquals(2, deck.getCard().getMinValue());
    assertEquals(2, deck.getCard().getMaxValue());
  }

  @Test
  public void canRemoveCard() {
    assertEquals("TWO of CLUBS (min = 2, max = 2);", deck.getCard().toString());
    assertEquals(52, deck.getCount());

    deck.removeCard();
      
    assertNotEquals("TWO of CLUBS (min = 2, max = 2);", deck.getCard().toString());
    assertEquals(51, deck.getCount());
  }

  @Test
  public void checkShuffleDeck() {
    Deck testDeck1 = new Deck();
    assertEquals(Suit.CLUBS, testDeck1.getCard().getSuit());
    assertEquals(Rank.TWO, testDeck1.getCard().getRank());
    assertEquals(2, testDeck1.getCard().getMinValue());
    assertEquals(2, testDeck1.getCard().getMaxValue());

    Deck testDeck2 = new Deck();

    assertEquals(testDeck1.toString(), testDeck2.toString());

    testDeck1.shuffleDeck();
    testDeck2.shuffleDeck();
  
    assertNotEquals(testDeck1.toString(), testDeck2.toString());
  }

  @Test
  public void checkHasSomeRandomness() {
    Deck testDeck1 = new Deck();
    assertEquals(Suit.CLUBS, testDeck1.getCard().getSuit());
    assertEquals(Rank.TWO, testDeck1.getCard().getRank());
    assertEquals(2, testDeck1.getCard().getMinValue());
    assertEquals(2, testDeck1.getCard().getMaxValue());

    Deck testDeck2 = new Deck();

    int deckOrderMatchCounter = 0;

    for(int i=0; i<1000; i++)
    {
      testDeck1.shuffleDeck();
      testDeck2.shuffleDeck();
      if(testDeck1.toString().equals(testDeck2.toString()))
      {
        deckOrderMatchCounter++;
      }
    }

    assertEquals(0, deckOrderMatchCounter);
  }
}