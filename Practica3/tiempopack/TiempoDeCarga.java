package tiempopack;

import java.net.*;

public class TiempoDeCarga {
    private Socket socket;

    public int carga(String host){//obtencion de tiempo de carga
        try {
            socket = new Socket(host, 65535);
            int tiempo = socket.getSoTimeout();
            return tiempo;
        } catch (Exception e) {
        }
        return 0;
    }    
}