package Thread;

public class ThreadInterrup_1 extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        ThreadInterrup_1 t1 = new ThreadInterrup_1();
        t1.start(); //sleep interripted
        t1.interrupt(); // Interrupting the thread while it is sleeping
    } 
}
