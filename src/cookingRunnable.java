public class cookingRunnable implements Runnable{
    private String task;

    cookingRunnable(String task){
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(task+ " running " + Thread.currentThread().getName());
    }
}


