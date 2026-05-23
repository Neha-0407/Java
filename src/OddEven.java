public class OddEven {
    public static void main(String[] args){
        int limit = 10;
        Thread oddThread = new Thread(new Odd(limit));
        Thread evenThread = new Thread(new Even(limit));

        oddThread.start();
        evenThread.start();
    }
}
