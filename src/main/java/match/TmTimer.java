package match;

import java.util.Timer;
import java.util.TimerTask;

public class TmTimer {

  private Timer timer;
  private boolean isRunning;
  private boolean isPaused;
  private final int timerLength;
  private int runCount;

  public TmTimer(int timerLength) throws InvalidTimerException {
    if(timerLength <= 0) throw new InvalidTimerException();

    this.isRunning = false;
    this.timerLength = timerLength;
  }

  public void startTimer() {
    if(isRunning) return;

    this.timer = new Timer();

    if(isPaused) {
      this.timer.scheduleAtFixedRate(new TmTimerTask(runCount), 0, 1000);
      this.isPaused = false;
    }else {
      this.timer.scheduleAtFixedRate(new TmTimerTask(timerLength), 0, 1000);
    }

    this.isRunning = true;
  }

  public void stopTimer(boolean pause) {
    if(!isRunning) return;

    timer.cancel();
    this.isRunning = false;
    this.isPaused = pause;
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

    private TmTimerTask(int count) {
      runCount = count;
    }

    @Override
    public void run() {
      if(runCount == 0) {
        stopTimer(false);
        return;
      }
      --runCount;
      System.out.println(runCount);
    }
  }
}
