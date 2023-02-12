package match;

import java.util.ArrayList;

public class MatchHandler {

  private final ArrayList<TmMatch> matches;
  private int currentMatchIndex;

  public MatchHandler(ArrayList<TmMatch> matches) {
    this.matches = matches;
    setCurrentMatch(0);
  }

  public boolean setCurrentMatch(int index) {
    if(index >= matches.size() || index < 0) return false;

    this.currentMatchIndex = index;
    return true;
  }

  public int totalMatches() {
    return matches.size();
  }

  public int getCurrentID() {
    return currentMatchIndex + 1;
  }

  public TmMatch currentMatch() throws IndexOutOfBoundsException {
    return matches.get(currentMatchIndex);
  }

  public TmMatch nextMatch() throws IndexOutOfBoundsException {
    currentMatchIndex++;
    return currentMatch();
  }

  public TmMatch previousMatch() throws IndexOutOfBoundsException {
    --currentMatchIndex;
    return currentMatch();
  }

  public void startMatch() {

    TmMatch selectedMatch = currentMatch();

    selectedMatch.getTimer().startTimer();
  }

  public void pauseMatch() {

    TmMatch selectedMatch = currentMatch();

    selectedMatch.getTimer().stopTimer(true);
  }

  public void endMatch() {

    TmMatch selectedMatch = currentMatch();

    selectedMatch.getTimer().stopTimer(false);
  }
}
