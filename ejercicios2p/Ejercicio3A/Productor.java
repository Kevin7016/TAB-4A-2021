package ejercicios2p.Ejercicio3A;

public class Productor extends Thread {

    private String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private String processName;
    Almacen container;
    public Productor(int n, Almacen a) {
        processName = "P-" + n;
        container = a;
    }
    public void run() {
        char c;
        System.out.println(processName);
        for(int i=0; i<10; i++) {
            c = letras.charAt((int)(Math.random()*26));
            container.asignar(c);
            System.out.println(String.format("[%s]: Produce letra: %c",processName, c));
            try{
                Thread.sleep( (int) Math.random() * 100 );
            }catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {

    }
}