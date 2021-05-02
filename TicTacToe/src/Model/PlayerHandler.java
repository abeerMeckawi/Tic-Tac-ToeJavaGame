package Model;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class PlayerHandler extends Thread{
    static ArrayList<PlayerHandler> playersList = new ArrayList<>();

    private DataInputStream dis ;
    private PrintStream ps;
    private Socket sc;
    boolean online;
    public PlayerHandler(Socket socketIp){
        sc = socketIp;
        online = true;
        playersList.add(this);
        try{
            dis = new DataInputStream(sc.getInputStream());
            ps = new PrintStream(sc.getOutputStream());
        }
        catch (IOException e){
            e.printStackTrace();
        }

        start();

    }

    public void run(){
        while(online){
        String str = "";

        try{
            str =dis.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }


        if(str.equals("close")){
            Server.playersNo = 0;
            online = false;
            sendPlay(str);
            closeGame();
        }else{
            sendPlay(str);
        }
        }
    }


    private void sendPlay(String playDescription){

        for(PlayerHandler ph:playersList){
            ph.ps.println(playDescription);

        }

    }

    private void closeGame(){
        try {
            dis.close();
            ps.close();
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

            for(PlayerHandler ph:playersList){

            try {
                ph.ps.close();
                ph.dis.close();
                ph.sc.close();


            } catch (IOException e) {
                System.out.println("EXCEPTION in player Handler");
                e.printStackTrace();
            }


        }
    }


}
