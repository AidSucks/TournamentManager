package server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TmServer extends Thread {

  private final int HOSTED_PORT;
  private ServerSocket SERVER_SOCKET;
  private final InetSocketAddress SERVER_SOCKET_ADDRESS;

  public TmServer(int hostedPort) throws IOException{
    HOSTED_PORT = hostedPort;
    SERVER_SOCKET_ADDRESS = new InetSocketAddress("localhost", HOSTED_PORT);
  }

  public void startServer() throws IllegalStateException{
    this.start();
  }


  public void stopServer() throws IOException {
    this.interrupt();
    SERVER_SOCKET.close();
  }

  //Server Thread Execution Cycle
  @Override
  public void run() {

    try {
      SERVER_SOCKET = new ServerSocket();
      SERVER_SOCKET.bind(SERVER_SOCKET_ADDRESS);
      Socket sock = SERVER_SOCKET.accept();

    }catch(IOException ex) {
      ex.printStackTrace();
    }

  }

}
