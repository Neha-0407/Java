public class cooking extends Thread{

    private String task;

    cooking(String task){
        this.task = task;
    }

    public void run(){
        System.out.println(task+ " running " + Thread.currentThread().getName());

    }
}


