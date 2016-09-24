package com.tiy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by DTG2 on 09/23/16.
 */
public class SpringChatServer implements Runnable {

    public final static int SERVER_PORT = 8005;

    public static void main(String[] args) {
        SpringChatServer myServer = new SpringChatServer();
        myServer.startServer();
    }

    public void run() {

    }

    public void startServer() {
        try {
            System.out.println("Server opening...");
            ServerSocket serverListener = new ServerSocket(SERVER_PORT);
            System.out.println("The audience is listening...");

            while (true) {
                Socket incomingConnection = serverListener.accept();
                System.out.println("Connection open.");
                SpringChatServerConnectionHandler handler = new SpringChatServerConnectionHandler(incomingConnection);
                Thread handlerThread = new Thread(handler);
                handlerThread.start();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
