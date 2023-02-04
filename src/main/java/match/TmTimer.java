package match;

import java.util.Timer;
import java.util.TimerTask;

public class TmTimer {

  private Timer timer;
  private boolean isRunning;
  private final int timerLength;

  public TmTimer(int timerLength) throws InvalidTimerException {
    if(timerLength <= 0) throw new InvalidTimerException();

    this.isRunning = false;
    this.timer = new Timer();
    this.timerLength = timerLength;
  }

  public void startTimer() {
    if(isRunning) return;

    this.timer.scheduleAtFixedRate(new TmTimerTask(), 0, 1000);
    this.isRunning = true;
  }

  public void stopTimer() {
    if(!isRunning) return;

    timer.cancel();
    this.isRunning = false;
  }

  public int getLength() {
    return timerLength;
  }

  public class InvalidTimerException extends RuntimeException {
    public InvalidTimerException() {
      super("Invalid Timer Value");
    }
  }

  private class TmTimerTask extends TimerTask {

    private int runCount = 0;

    @Override
    public void run() {
      System.out.println(timerLength - runCount);
      if(runCount == timerLength) stopTimer();
      runCount++;
    }
  }
}
