package util;

import match.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MatchGenerator {

  private MatchGenerator () {}

  //TODO Refactor and implement match buffer variable
  public static MatchHandler generateIQMatchHandler(int matchesPerTeam, ArrayList<TmTeam> teamList) {

    HashMap<TmTeam, Integer> genMap = new HashMap<>();
    ArrayList<TmMatch> createdMatches = new ArrayList<>();
    int totalMatches = (matchesPerTeam * teamList.size()) / 2;

    //Load HashMap
    for (TmTeam tmTeam : teamList) genMap.put(tmTeam, matchesPerTeam);

    int index = 0;

    while(index < totalMatches) {

      boolean zeroError = false;
      boolean isSameMatch;
      TmMatch match;
      TmTeam team1;
      TmTeam team2;
      TmTeam[] red = new TmTeam[1];
      TmTeam[] blue = new TmTeam[1];

      do {

        ArrayList<TmTeam> teams = new ArrayList<>(genMap.keySet());
        Random rand = new Random();

        isSameMatch = false;

        team1 = teams.get(rand.nextInt(teams.size()));
        teams.remove(team1);

        if(teams.size() == 0) {
          TmMatch randMatch = createdMatches.get(rand.nextInt(createdMatches.size()));
          TmTeam temp = randMatch.getTeamList(TmMatch.TeamColor.BLUE).get(0);

          randMatch.removeTeam(temp);
          randMatch.addTeam(team1, TmMatch.TeamColor.BLUE);

          team2 = temp;
          zeroError = true;
          System.out.println("Zero Error Set\n");

        }else {
          team2 = teams.get(rand.nextInt(teams.size()));
        }

        red[0] = team1;
        blue[0] = team2;

        for(TmMatch m : createdMatches) {
          if(m.getTeamList(TmMatch.TeamColor.RED).contains(team2) &&
             m.getTeamList(TmMatch.TeamColor.BLUE).contains(team1)) {
            isSameMatch = true;
            break;
          }
        }
      }while(isSameMatch);

      match = new TmMatch(new TmField(1), new TmTimer(60), red, blue);

      createdMatches.add(match);

      int i1 = genMap.get(team1);
      genMap.replace(team1, --i1);

      if(genMap.get(team1) == 0)
        genMap.remove(team1);

      if(!zeroError) {
        int i2 = genMap.get(team2);
        genMap.replace(team2, --i2);

        if (genMap.get(team2) == 0)
          genMap.remove(team2);
      }

      index++;
    }

    return new MatchHandler(createdMatches);
  }

  public static MatchHandler generateVRCMatchHandler() {
    return null;
  }
}
