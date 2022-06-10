package Controllers;
//class Client using thread to connect to server from Server.java
import java.net.Socket;
public class Client extends Thread {
    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
    @Override
    public void run() {
        super.run();
        try {
            //connect to server and listen to port 9000 ip localhost
            String serverName = "localhost";
            Socket clientSocket = new Socket(serverName, 9000);
            System.out.println("Client is connected to server");
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}