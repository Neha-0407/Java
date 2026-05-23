import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class ProducerConsumer{
    private Queue<Integer> queue = new LinkedList<>();
    private final int capacity;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();


    ProducerConsumer(int capacity){
        this.capacity = capacity;
    }

    void produce(int item) throws InterruptedException{
        lock.lock();
        try{
            while(queue.size() == capacity){
                notFull.await();
            }
            queue.offer(item);
            notEmpty.signal();
        }finally{
            lock.unlock();
        }
    }

    int consume() throws InterruptedException{
        lock.lock();
        try{
            while(queue.isEmpty()){
                notEmpty.await();
            }
            int item = queue.poll();
            notFull.signal();
            return item;
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args){
       ProducerConsumer pc = new ProducerConsumer(5);
       Thread producerThread = new Thread(()->{
        try{
            for(int i=0;i<10;i++){
                pc.produce(i);
                System.out.println("Produced: " + (i+1));
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
       });

       Thread consumerThread = new Thread(()->{
        try{
            for(int i=0;i<10;i++){
                int item = pc.consume();
                System.out.println("Consumed: " + item);
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
       });

       producerThread.start();
       consumerThread.start();
    }

}