import java.util.concurrent.atomic.AtomicInteger;

class Counter {

    int count = 0;

    void increment(){
        count++;
    }
}

//Use Synchronized blocks or AtomicInteger


class AtomicCounter{
    AtomicInteger count = new AtomicInteger(0);

    void increment(){
        count.getAndIncrement();
    }
}

class Gfg{
    public static void main(String[] args) throws InterruptedException {
        AtomicCounter c = new AtomicCounter();
        Thread t1 = new Thread(() -> {
            for(int i=0;i<1000;i++)
                c.increment();
        });

        Thread t2 = new Thread(() -> {
            for(int i=0;i<1000;i++)
                c.increment();
        });


        t1.start();

        t2.start();

        t1.join();

        t2.join();

        System.out.println(c.count);
    }
}
