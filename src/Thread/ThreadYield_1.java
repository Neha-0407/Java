package Thread;


//yield is a static method of the Thread class that allows a thread to voluntarily give up its current use of the CPU and allow other
// threads to execute.
public class ThreadYield_1 extends Thread{

    ThreadYield_1(String name){
        super(name);
    }

    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + " is running: " + i);
            Thread.yield();
        }
    }

    public static void main(String[] args){
        ThreadYield_1 t1 = new ThreadYield_1("Thread-1");
        ThreadYield_1 t2 = new ThreadYield_1("Thread-2");

        t1.start();
        t2.start();
    }
}
