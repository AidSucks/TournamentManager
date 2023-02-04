package client;

import java.io.IOException;
import java.net.InetSocketAddress;

public class TournamentClientTest {

  public static void main(String[] args) {

    InetSocketAddress socketAddress = new InetSocketAddress("localhost", 5000);

    TmClient client = new TmClient(socketAddress);

    try {
      client.connectToServer();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
