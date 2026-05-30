import java.util.LinkedList;
import java.util.Queue;

class QueueDao{
    
    private final Queue<Integer> q;

    public QueueDao(){
        q = new LinkedList<>();
    }

    public void add(int element){
        q.offer(element);
    }

    public Integer remove(){
        if(q.isEmpty())
            return null;
        
        return q.poll();    
    }

    public Integer peek(){
        if(q.isEmpty())
            return null;
        return q.peek();
    }

    public int size(){
        return q.size();
    }

    public boolean isEmpty(){
        return q.isEmpty();
    }
}