package client;

import java.io.*;
import java.net.Socket;

public class MapReceiver {
    Socket socket = null;
    String ip;

    public void makeConnection() throws IOException {
        socket = new Socket(ip,15123);
    }
    public void receiveMap(String fileName) throws IOException {
        makeConnection();
        int filesize=102238600; //2147483647;
        int bytesRead;
        int currentTot = 0;

        InputStream is = socket.getInputStream();

        byte [] bytearray  = new byte [filesize];

        FileOutputStream fos = new FileOutputStream(fileName);

        BufferedOutputStream bos = new BufferedOutputStream(fos);

        bytesRead = is.read(bytearray,0,bytearray.length);
        currentTot = bytesRead;

        System.out.println("connection established. Now sending files.");

        do {

            bytesRead = is.read(bytearray, currentTot, (bytearray.length-currentTot));
            if(bytesRead >= 0) currentTot += bytesRead;

        } while(bytesRead >-1);

        bos.write(bytearray, 0 , currentTot);

        System.out.println("finished.");

        bos.flush();
        bos.close();
        socket.close();
    }
}
