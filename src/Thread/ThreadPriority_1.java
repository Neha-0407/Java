package Thread;

public class ThreadPriority_1 extends Thread {
    
    //setting the name of the thread using constructor
    ThreadPriority_1(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName() + "- Priority: " + Thread.currentThread().getPriority() + " is running: " + i);

            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    // we do set the priority of the thread, but it is not guaranteed that the thread with higher priority will always execute before the 
    // thread with lower priority. The scheduling of threads is determined by the operating system and can be influenced by 
    // various factors such as the workload, system resources, and the specific implementation of the Java Virtual Machine (JVM). 
    // Therefore, while setting thread priorities can provide hints to the scheduler, it does not guarantee a specific execution order.
    public static void main(String[] args){
        ThreadPriority_1 t1 = new ThreadPriority_1("Low");
        ThreadPriority_1 t2 = new ThreadPriority_1("Medium");
        ThreadPriority_1 t3 = new ThreadPriority_1("High");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();

    }   
}