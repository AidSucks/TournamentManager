package client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class TmClient {

  private final Socket CLIENT_SOCKET;
  private final InetSocketAddress SOCKET_ADDRESS;

  public TmClient(InetSocketAddress socketAddress) {
    CLIENT_SOCKET = new Socket();
    SOCKET_ADDRESS = socketAddress;
  }

  public void connectToServer() throws IOException{
    CLIENT_SOCKET.connect(SOCKET_ADDRESS);
  }

}
