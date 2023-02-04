package match;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TournamentTimerTest {

  public static void main(String[] args) {
    TmTimer myTimer = new TmTimer(10);
    myTimer.startTimer();
    myTimer.startTimer();
  }


  TmTimer myTimer = new TmTimer(10);

  @Test
  void timerThrowsErrorWhenSetTo0() {
    assertThrows(TmTimer.InvalidTimerException.class, () -> {new TmTimer(0);});
  }
}
