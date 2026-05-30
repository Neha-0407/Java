package Thread;

public class ThreadDaemon_1 extends Thread {
    @Override
    public void run() {
        while(true){
            System.out.println(1);    
        }
    }

    public static void main(String[] args) {
        ThreadDaemon_1 t1 = new ThreadDaemon_1();
       

       t1.setDaemon(true); // Setting t1 as a daemon thread

        t1.start();
        System.out.println("Main thread is finishing..."); // The main thread will finish before t1 completes its execution, and since t1 is a daemon thread, it will be terminated when the main thread finishes.

        // The main thread will finish before t1 completes its execution, and since t1 is a daemon thread, it will be terminated when the main thread finishes.
    }
}
