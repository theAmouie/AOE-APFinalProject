package server;

import server.iomanage.IOManager;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ServerManager{

    // Users maps is as big as the number of the users.
    public static ArrayList<ClientInfo> gameClients;

    public boolean gameIsRunning = true;

    public static void main(String[] args) throws Exception{
        IOManager ioManager = new IOManager();

//        gameClients.add(new ClientInfo("zahra",0,"192.168.100.10"));
        gameClients.add(new ClientInfo("amirreza",1,"127.0.0.1"));
//        gameClients.add(new ClientInfo("Kia",2,InetAddress.getLocalHost()));

        ioManager.start();

    }

    public ServerManager(){
        gameIsRunning=true;
    }
}
