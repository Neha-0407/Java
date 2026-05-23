public class ThreadLocalP {
    
    static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
   

    static void method2(){
        threadLocal.set(2);
        System.out.println("Thread 2: " + threadLocal.get());
    }
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            threadLocal.set(1);
            System.out.println("Thread 1: " + threadLocal.get());
            threadLocal.remove(); // Clean up to prevent memory leaks
        });
        t1.start();

        Thread t2 = new Thread(ThreadLocalP::method2);
        t2.start();



    }
}
