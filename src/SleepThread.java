public class SleepThread extends Thread{

    @Override
    public void run(){
        for(int i=0;i<5;i++){
            System.out.println("Thread is running: " + i);
            try {
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        SleepThread sleepThread1 = new SleepThread();
        sleepThread1.start();

        SleepThread sleepThread2 = new SleepThread();
        sleepThread2.start();
    }

} 