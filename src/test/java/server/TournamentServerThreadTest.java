package server;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TournamentServerThreadTest {

  public static void main(String[] args) {
    try {
      TmServer server = new TmServer(5000);
      server.startServer();
    }catch(IOException ex) {
      ex.printStackTrace();
    }
  }

}
