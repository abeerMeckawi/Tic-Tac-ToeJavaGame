package Model;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server extends Thread{
   static int playersNo = 0;
    private ServerSocket serverSocket;
    private String ipAdress;

    public static int getPlayersNo() {
        return playersNo;
    }

    public static void setPlayersNo(int playersNo) {
        Server.playersNo = playersNo;
    }

    public Socket getMySocket() {
        return mySocket;
    }

    private Socket mySocket;


    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public void setServerSocket(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public String getIpAdress() {
        return ipAdress;
    }

    public Server() throws UnknownHostException {

        start();

        ipAdress = InetAddress.getLocalHost().getHostAddress();
        System.out.println(ipAdress);
        try {
            mySocket= new Socket(ipAdress,5005);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run(){
        try {
            serverSocket = new ServerSocket(5005);

            while (playersNo<2) {
                Socket s = serverSocket.accept();
                playersNo++;
                new PlayerHandler(s);
            }
        } catch (IOException e) {

                if (serverSocket != null && !serverSocket.isClosed()) {
                    try {
                        System.out.println("in first exception");
                        serverSocket.close();
                        playersNo = 0;
                    } catch (IOException ex)
                    {
                        System.out.println("in second exception");
                        ex.printStackTrace(System.err);
                    }
                }

            }



    }

    public void shutDown(){
        try {
            serverSocket.close();
            this.stop();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
