import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

class CallableP{
    public static void main(String[] args){
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> c  = (()->{
            return 5*5;
        });

        Future<Integer> f = executor.submit(c);
        int result = 0;
        try{
            result = f.get();
        }catch(Exception e){
            e.printStackTrace();
        }

        System.out.println(result);

        executor.shutdown();
    }
}