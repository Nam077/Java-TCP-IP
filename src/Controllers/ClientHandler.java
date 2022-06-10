package Controllers;

import java.net.Socket;

public class ClientHandler implements Runnable {
    @Override
    public void run() {

    }
    public ClientHandler(Socket socket) {
        try {
            System.out.println("Client connected");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        new Thread(this).start();

    }
}
