package ejercicios2p.Ejercicio3A;

public class Consumidor extends Thread {
    private Almacen container;
    private String processName;
    public Consumidor(int n, Almacen a) {
        this.container = a;
        processName = "C-" + n;
    }

    public void run() {
        char c;
        for (int i=0;i<10;i++) {
            c = container.obtener();
            System.out.println(String.format("[%s]: Consume letra: %c",processName, c));
            try{
                Thread.sleep( 1000 );
            }catch(InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}