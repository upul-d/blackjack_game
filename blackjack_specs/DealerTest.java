import static org.junit.Assert.*;
import org.junit.*;
import blackjack.*;

public class DealerTest {

  Dealer dealer;

  @Before
  public void before() {
    dealer = new Dealer("Boris 'The Blade' Yurinov");
  }

  @Test
  public void hasName() {
    assertEquals("Boris 'The Blade' Yurinov", dealer.getName());
  }

}