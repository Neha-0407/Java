public class Odd implements Runnable{
    private final int limit;

    Odd(int limit) {
        this.limit = limit;
    }
    
    @Override
    public void run() {
        for (int i = 1; i <= limit; i++) {
            if (i % 2 != 0) {
                System.out.println("Odd: " + i);
            }
        }
    }

} 