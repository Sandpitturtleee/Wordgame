package com.company;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample {
    private static int port = 1200;
    private static ServerSocket server;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        server = new ServerSocket(port);

        while (true) {
            System.out.println("Oczekiwanie na klienta...");
            Socket s = server.accept();

            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());

            String msg = (String) ois.readObject();
            System.out.println("Wiadomość od klienta: " + msg);

            oos.writeObject(msg.toUpperCase());

            ois.close();
            oos.close();
            s.close();
        }

    }
}
