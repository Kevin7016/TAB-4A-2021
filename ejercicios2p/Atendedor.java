package ejercicios2p;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Atendedor extends Thread {
    Socket c;
    BufferedReader in;
    PrintWriter out;
    List<Socket> sockets;

    public Atendedor(Socket client, List<Socket> ss) throws IOException {
        this.c = client;
        this.sockets = ss;
        in = new BufferedReader(new InputStreamReader(c.getInputStream()));
        out = new PrintWriter(c.getOutputStream());
    }
    public void sendBroadCast(String mensaje) {
        System.out.println("Enviando Broadcast:" + mensaje);
        if(sockets.size()>0) {
            sockets.forEach(socket -> {
                try {
                    PrintWriter outbc = new PrintWriter(socket.getOutputStream());
                    outbc.println(mensaje + " por broadcast.");
                    outbc.flush();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
        }
    }
    @Override
    public void run() {
        String line = "";
        while(!line.equals("adios"))
        {
            try{
                line = in.readLine();
                switch(line) {
                    case "hola":
                        System.out.println("Me está saludando....");
                        out.println("Hola tambien");
                        out.flush();
                        sendBroadCast("hola tambien");
                        break;
                    case "adios":
                        System.out.println("Ya te vas?");
                        out.println("Adios igual");
                        out.flush();
                        sendBroadCast("Ya se va uno");
                        in.close();
                        out.close();
                        break;
                    case "cual es mi calificacion?":
                        System.out.println("Solo para eso veniste...:'(");
                        sendBroadCast("Fulanito sacó 0");
                        out.println("0");
                        out.flush();
                        break;
                    default:
                        System.out.println(line);
                }
            
            }catch(IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }

}