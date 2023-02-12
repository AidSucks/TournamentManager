package match;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class MatchHandlerTest {

  TmField field1 = new TmField(1);
  TmField field2 = new TmField(2);

  TmTimer slapshotTimer = new TmTimer(60);

  TmMatch match1 = new TmMatch(field1, slapshotTimer);
  TmMatch match2 = new TmMatch(field2, slapshotTimer);

  ArrayList<TmMatch> matches = new ArrayList<>();

  @Test
  void whenMatchHandlerCreated_VariablesAreNotNull() {

    matches.add(match1);
    matches.add(match2);

    MatchHandler handler = new MatchHandler(matches);

    assertNotNull(handler.currentMatch());
  }

  @Test
  void whenHandlerCreated_CurrentMatchIsSetToIndex0() {

    matches.add(match1);
    matches.add(match2);

    MatchHandler handler = new MatchHandler(matches);

    assertEquals(matches.get(0), handler.currentMatch());
  }

  @Test
  void whenPreviousMatchCalledOnIndex0_willThrowIndexOutOfBounds() {
    matches.add(match1);
    matches.add(match2);

    MatchHandler handler = new MatchHandler(matches);

    assertThrows(IndexOutOfBoundsException.class, handler::previousMatch);
  }

  @Test
  void whenNextMatchCalledOnMaxIndex_willThrowIndexOutOfBounds() {

    matches.add(match1);
    matches.add(match2);

    MatchHandler handler = new MatchHandler(matches);

    //Advance to index 1
    handler.nextMatch();

    assertThrows(IndexOutOfBoundsException.class, handler::nextMatch);
  }

  @Test
  void whenGettingMatchId_DoesNotChangeIndex() {
    matches.add(match1);
    matches.add(match2);

    MatchHandler handler = new MatchHandler(matches);

    int id1 = handler.getCurrentID();
    int id2 = handler.getCurrentID();

    assertEquals(id1, id2);
  }

  @Test
  void whenMatchIndexChanged_MatchIdChanges() {
    matches.add(match1);
    matches.add(match2);

    MatchHandler handler = new MatchHandler(matches);

    int id1 = handler.getCurrentID();
    handler.nextMatch();
    int id2 = handler.getCurrentID();

    assertNotEquals(id1, id2);
  }
}
