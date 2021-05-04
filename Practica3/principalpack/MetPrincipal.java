package Practica3.principalpack;

import java.io.*;
import java.net.*;

public class MetPrincipal {
    public String principal(String host) {
        try {
            Socket socket = new Socket(host, 80);
            InputStream input = socket.getInputStream();
            return input + "";
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
        return null;
    }
}

