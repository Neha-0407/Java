import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool implements Runnable{

    @Override
    public void run(){
        System.out.println("Thread is running: " + Thread.currentThread().getName());
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // ThreadPool threadPool1 = new ThreadPool();
        // ThreadPool threadPool2 = new ThreadPool();
        // ThreadPool threadPool3 = new ThreadPool();
        // ThreadPool threadPool4 = new ThreadPool();
        // ThreadPool threadPool5 = new ThreadPool();

        // executorService.execute(threadPool1);
        // executorService.execute(threadPool2);    
        // executorService.execute(threadPool3);
        // executorService.execute(threadPool4);    
        
        for(int i=0;i<5;i++){
            executorService.execute(new ThreadPool());
        }
        executorService.shutdown();
    }
    

}