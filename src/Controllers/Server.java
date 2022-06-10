package Controllers;

import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    @Override
    public void run() {
        super.run();
        try {
            //run server and listen to port 9000 ip localhost
            ServerSocket serverSocket = new ServerSocket(9000);
            System.out.println("Server is running in port 9000 and IP " + serverSocket.getInetAddress().getHostAddress());
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
