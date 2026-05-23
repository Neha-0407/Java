You have APIs:

getUser()
getOrders(user)
getPayments(user)

👉 Requirements:

Fetch user
Then call orders & payments in parallel
Combine results

class CompletableFuture{
    CompletableFuture<User> userFuture  = CompletableFuture.supplyAsync(()->{
        return getUser();
    });

    CompletableFuture<Result> finalResult = userFuture.thenCompose(user->{
        
        CompletableFuture<Orders> ordersFuture = CompletableFuture.supplyAsync((user)->{
            return getOrders(user);
        });
        
        CompletableFuture<Payment> paymentsFuture = CompletableFuture.supplyAsync((user)->{
            return getPayments(user);
        });

        return ordersFuture.thenCombine(paymentsFuture,(orders,payments)-> new Result(orders,payments));
       
    
    });

}