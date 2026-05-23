import java.util.concurrent.locks.ReentrantLock;

class ReentrantLockExample{
    private final ReentrantLock lock  = new ReentrantLock();

    public void outer(){
        lock.lock();
        try{
            System.out.println("Outer method is executing.");
            inner();
        }finally{
            lock.unlock();
        }
    }

    public void inner(){
        lock.lock();
        try{
            System.out.println("Inner method is executing.");
        }finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        example.outer();
    }
}