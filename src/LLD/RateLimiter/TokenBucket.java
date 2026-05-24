public class TokenBucket {

        // Maximum bucket capacity
        private final int capacity;

        // Number of tokens added every refill interval
        private final int refillTokens;

        // Refill interval in milliseconds
        private final long refillIntervalMillis;

        // Current available tokens
        private int tokens;

        // Last refill timestamp
        private long lastRefillTime;

        public TokenBucket(int capacity,
                        int refillTokens,
                        long refillIntervalMillis) {

                this.capacity = capacity;
                this.refillTokens = refillTokens;
                this.refillIntervalMillis = refillIntervalMillis;

                this.tokens = capacity;

                this.lastRefillTime =
                        System.currentTimeMillis();
        }

        public synchronized boolean allowRequest() {
                refill();

                if (tokens > 0) {

                tokens--;

                return true;
                }

                return false;
        }

        private void refill() {

                long currentTime =
                        System.currentTimeMillis();

                long elapsedTime =
                        currentTime - lastRefillTime;

                // Check how many refill intervals passed
                if (elapsedTime >= refillIntervalMillis) {

                long intervals =
                        elapsedTime / refillIntervalMillis;

                int tokensToAdd =
                        (int) intervals * refillTokens;

                tokens =
                        Math.min(
                                capacity,
                                tokens + tokensToAdd
                        );

                // Move refill time forward correctly
                lastRefillTime =
                        lastRefillTime +
                        (intervals * refillIntervalMillis);
                }
        }

        public static void main(String[] args) throws InterruptedException {
                TokenBucket bucket =
                        new TokenBucket(5, 1, 1000);

                for (int i = 0; i < 10; i++) {
                        if (bucket.allowRequest()) {
                                System.out.println("Request " + i + " allowed");
                        } else {
                                System.out.println("Request " + i + " denied");
                        }

                        Thread.sleep(500);
                }
        }
}