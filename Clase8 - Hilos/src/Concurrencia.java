class TareaEnParalelo extends Thread {
    private int numeroThread;

    public TareaEnParalelo(int numeroThread) {
        this.numeroThread = numeroThread;
    }

    @Override
    public void run() {
        System.out.println("T"+numeroThread
                + " está ejecutando este codigo - " + Thread.currentThread().getName());

    }

}

public class Concurrencia {

    public static void main(String[] args) {


        Thread t1 = new TareaEnParalelo(1);
        Thread t2 = new TareaEnParalelo(2);
        Thread t3 = new TareaEnParalelo(3);

        t1.start();
        t2.start();
        t3.start();
    }
}
