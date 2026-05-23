class Transaction implements Runnable{
    private final String transactionName;

    Transaction (String transactionName){
        this.transactionName = transactionName;
    }

    @Override
    public void run(){
        System.out.println(transactionName + " is starting.");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println(transactionName + " was interrupted.");
        }
        System.out.println(transactionName + " is completed.");
    }
    public static void main(String[] args){
        Thread transaction1 = new Thread(new Transaction("Credited"));
        Thread transaction2 = new Thread(new Transaction("Debited"));

        transaction1.start();
        transaction2.start();
    }
}