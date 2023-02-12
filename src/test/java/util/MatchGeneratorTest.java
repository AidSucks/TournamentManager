package util;

import match.MatchHandler;
import match.TmMatch;
import match.TmTeam;

import java.util.ArrayList;

public class MatchGeneratorTest {

  static ArrayList<TmTeam> testTeams = new ArrayList<>(16);

  public static void main(String[] args) {

    for(int x = 1; x <= 16; x++) {
      testTeams.add(new TmTeam(String.valueOf(x), "Test Team " + x, "", ""));
    }

    MatchHandler handler = MatchGenerator.generateIQMatchHandler(2, testTeams);


    for(int y = 0; y < handler.totalMatches(); y++) {
      TmMatch match = handler.currentMatch();
      System.out.print(handler.getCurrentID() + " [");
      System.out.print(match.getTeamList(TmMatch.TeamColor.RED).get(0).teamName() + ", ");
      System.out.print(match.getTeamList(TmMatch.TeamColor.BLUE).get(0).teamName());
      System.out.print("]\n");
      if(y != handler.totalMatches() - 1)
        handler.nextMatch();
    }

  }
}
