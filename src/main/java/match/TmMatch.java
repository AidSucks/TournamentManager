package match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TmMatch {

  private TmField tmField;
  private TmTimer tmTimer;
  private MatchStatus matchStatus = MatchStatus.STOPPED;
  private int teamCount;

  private ArrayList<TmTeam> redTeams;
  private ArrayList<TmTeam> blueTeams;

  public TmMatch(TmField tmField, TmTimer tmTimer) {
    this(tmField, tmTimer, new TmTeam[0], new TmTeam[0]);
  }

  public TmMatch(TmField tmField, TmTimer tmTimer, TmTeam[] redTeams, TmTeam[] blueTeams) {
    this.tmField = tmField;
    this.tmTimer = tmTimer;

    List<TmTeam> redTeamsList = Arrays.stream(redTeams).toList();
    List<TmTeam> blueTeamsList = Arrays.stream(blueTeams).toList();

    this.teamCount = redTeamsList.size() + blueTeamsList.size();

    this.redTeams = new ArrayList<>(redTeamsList);
    this.blueTeams = new ArrayList<>(blueTeamsList);
  }

  public TmField getField() {
    return tmField;
  }

  public TmTimer getTimer() {
    return tmTimer;
  }

  public int getTeamCount() {
    return teamCount;
  }

  public void setField(TmField field) {
    this.tmField = field;
  }

  public ArrayList<TmTeam> getTeamList(TeamColor colorSetToRetrieve) {
    if(colorSetToRetrieve == TeamColor.RED) return redTeams;

    return blueTeams;
  }

  public void addTeam(TmTeam teamToAdd, TeamColor teamColor) {
    if(teamColor == TeamColor.RED) {
      redTeams.add(teamToAdd);
    }else {
      blueTeams.add(teamToAdd);
    }
    teamCount++;
  }

  public void removeTeam(TmTeam teamToRemove) {
    if(redTeams.remove(teamToRemove) || blueTeams.remove(teamToRemove))
      --teamCount;
  }

  public boolean startMatch() {
    tmTimer.startTimer();
    return true;
  }

  public boolean pauseMatch() {
    return true;
  }

  public boolean endMatch() {
    tmTimer.stopTimer();
    return true;
  }

  public enum TeamColor {
    RED, BLUE
  }

  public enum MatchStatus {
    STARTED, PAUSED, STOPPED
  }
}
