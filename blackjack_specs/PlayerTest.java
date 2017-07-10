import static org.junit.Assert.*;
import org.junit.*;
import blackjack.*;

public class PlayerTest {

  Player player;

  @Before
  public void before() {
    player = new Player("Mickey O'Neil");
  }

  @Test
  public void hasName() {
    assertEquals("Mickey O'Neil", player.getName());
  }

}