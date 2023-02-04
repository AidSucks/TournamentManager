package match;

import match.TmField;
import match.TmMatch;
import match.TmTeam;
import match.TmTimer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static match.TmMatch.TeamColor;

public class TournamentMatchTest {

  TmField myField = new TmField(1);
  TmTimer myTimer = new TmTimer(60);
  TmMatch myMatch = new TmMatch(myField, myTimer);
  TmTeam myTeam = new TmTeam("999A", "Test Team", "USA", "USA Corp");

  //Match Created Tests
  @Test
  void whenNewMatchCreated_ClassVariablesAreNotNull() {
    //Field is not null
    assertNotNull(myMatch.getField());

    //Teams are not null
    assertNotNull(myMatch.getTeamList(TeamColor.RED));
    assertNotNull(myMatch.getTeamList(TeamColor.BLUE));

    //Timer is not null
    assertNotNull(myMatch.getTimer());
  }

  @Test
  void whenNewMatchCreated_TeamsEmpty() {
    assertEquals(0, myMatch.getTeamCount());
  }

  //Team Addition/Removal Tests
  @Test
  void whenTeamAddedToRed_IsNotAddedToBlueArrayList() {
    myMatch.addTeam(myTeam, TeamColor.RED);
    assertFalse(myMatch.getTeamList(TeamColor.BLUE).contains(myTeam));
  }

  @Test
  void whenTeamAddedToBlue_IsNotAddedToRedArrayList() {
    myMatch.addTeam(myTeam, TeamColor.BLUE);
    assertFalse(myMatch.getTeamList(TeamColor.RED).contains(myTeam));
  }

  @Test
  void whenTeamAdded_TeamCountNotEmpty() {
    myMatch.addTeam(myTeam, TeamColor.RED);
    assertNotEquals(0, myMatch.getTeamCount());
  }

  @Test
  void whenTeamAddedThenRemoved_TeamCountIs0() {
    myMatch.addTeam(myTeam, TeamColor.RED);
    myMatch.removeTeam(myTeam);
    assertEquals(0, myMatch.getTeamCount());
  }
  @Test
  void whenTeamRemovedFromEmptyMatch_TeamCountIs0() {
    myMatch.removeTeam(myTeam);
    assertEquals(0, myMatch.getTeamCount());
  }

  //Field Tests
  @Test
  void whenMatchFieldChanged_DoesNotEqualPreviousField() {
    myMatch.setField(new TmField(1));
    assertNotEquals(myField, myMatch.getField());
  }
}
