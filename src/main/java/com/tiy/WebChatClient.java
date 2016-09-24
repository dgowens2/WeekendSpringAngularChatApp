package com.tiy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by DTG2 on 09/23/16.
 */
public class WebChatClient {
    String serverResponse;
    public final static String CLIENT_URL = "localhost";
    public final static int CLIENT_PORT = 8005;


    public String sendMessage(String message) {
        try {
            Socket clientSocket = new Socket(CLIENT_URL, CLIENT_PORT);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            out.println(message);
            System.out.println("Client: " + message);

            serverResponse = in.readLine();
            System.out.println("Server: " + serverResponse);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return serverResponse;
    }
}
