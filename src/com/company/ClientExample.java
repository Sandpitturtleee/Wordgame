package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ClientExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int port = 1200;
        InetAddress host = InetAddress.getLocalHost();
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;

//        Połączenie z serwerem
        Socket s = new Socket(host.getHostName(), port);

        oos = new ObjectOutputStream(s.getOutputStream());
        System.out.println("Wysłanie informacji do serwera...");
        oos.writeObject("hello server!");

        ois = new ObjectInputStream(s.getInputStream());
        String msg = (String) ois.readObject();
        System.out.println("Odpowiedź od serwera: " + msg);

        ois.close();
        oos.close();
    }
}
