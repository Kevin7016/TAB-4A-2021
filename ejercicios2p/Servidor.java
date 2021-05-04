package ejercicios2p;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor {
    ServerSocket server;
    ArrayList<Socket> sockets;
    // BufferedReader in;
    // PrintWriter out;
    public Servidor() throws IOException {
        server = new ServerSocket(5000);
        sockets = new ArrayList<>();
        // in = new BufferedReader(new InputStreamReader(cc.getInputStream()));
        // out = new PrintWriter(cc.getOutputStream());
    }

    public void start() throws IOException {
        while(true) {
            System.out.println("Escuchando un nuevo cliente");
            Socket cc = server.accept();
            sockets.add(cc);
            new Atendedor(cc, sockets).start();
        }
    }

    // public void read() throws IOException {
    //     String line = "";
    //     while(!line.equals("adios"))
    //     {
    //         line = in.readLine();
    //         switch(line) {
    //             case "hola":
    //                 System.out.println("Me está saludando....");
    //                 out.println("Hola tambien");
    //                 out.flush();
    //                 break;
    //             case "adios":
    //                 System.out.println("Ya te vas?");
    //                 out.println("Adios igual");
    //                 out.flush();
    //                 break;
    //             case "cual es mi calificacion?":
    //                 System.out.println("Solo para eso veniste...:'(");
    //                 out.println("0");
    //                 out.flush();
    //                 break;
    //             default:
    //                 System.out.println(line);
    //         }
    //     }
    //     in.close();
    //     out.close();
    // }
    public static void main(String args[]) {
        try {
            Servidor s = new Servidor();
            s.start();
            // s.read();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}