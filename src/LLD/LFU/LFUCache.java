package LLD.LFU;

import java.util.HashMap;
import java.util.Map;
//Logic for LFU Cache
//1. When we put a new key-value pair, we check if the cache is at capacity.
//  If it is, we evict the least frequently used key (the one with the lowest frequency).
//  If there are multiple keys with the same frequency, we evict the least recently used one among them.
//2. When we get a key, we return its value and update its frequency.

//why are we using a doubly linked list?
//1. A doubly linked list allows us to efficiently add and remove nodes from both ends
//  of the list, which is crucial for maintaining the order of keys based on their frequency and recency of use.

//if we use a singly linked list, we would have to traverse the entire list to find the node to remove, 
// which would result in O(n) time complexity for eviction. With a doubly linked list, we can directly access 
// the node to remove and update the pointers in O(1) time using prev and next pointers , making the eviction process efficient.
class Node{
    int key;
    int value;
    int freq;

    Node prev;
    Node next;

    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoublyLinkedList{
    Node head;
    Node tail;

    DoublyLinkedList(){
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    void addFirst(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    Node removeLast(){
        if(isEmpty())
            return null;
        Node node = tail.prev;
        remove(node);
        return node;
    }

    boolean isEmpty() {
        return head.next == tail;
    }
}
public class LFUCache {
    private final int capacity;
    private int size;
    private int minFreq;

    private final Map<Integer,Node> keyToNode;
    private final Map<Integer,DoublyLinkedList> freqToList;

    public LFUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        keyToNode = new HashMap<>();
        freqToList = new HashMap<>();
    }

    public int get(int key){
        if(!keyToNode.containsKey(key))
            return -1;
        Node node = keyToNode.get(key);
        updateFreq(node);
        return node.value;
    }

    public void put(int key,int value){
        if(capacity==0)
            return;
        if(keyToNode.containsKey(key)){
            Node node = keyToNode.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }
        if(size==capacity){
            DoublyLinkedList minFreqList = freqToList.get(minFreq);
            Node node = minFreqList.removeLast();
            keyToNode.remove(node.key);
            size--;
        }
        Node node = new Node(key,value);
        minFreq = 1;
        DoublyLinkedList minFreqList = freqToList.computeIfAbsent(1,k->new DoublyLinkedList());
        minFreqList.addFirst(node);
        keyToNode.put(key,node);
        size++;
        return;
    }

    public void updateFreq(Node node){
        int oldFreq = node.freq;
        DoublyLinkedList list = freqToList.get(oldFreq);
        list.remove(node);
        if(oldFreq==minFreq && list.isEmpty())
            minFreq++;
        node.freq = oldFreq+1;
        DoublyLinkedList newList = freqToList.computeIfAbsent(oldFreq+1,k->new DoublyLinkedList());
        newList.addFirst(node);
    }

    public static void main(String[] args){
        LFUCache lfu =  new LFUCache(2);

        lfu.put(1,1);
        lfu.put(5,2);

        System.out.println(lfu.get(1));

        lfu.put(3,5);

        System.out.println(lfu.get(5));

    
    }
}
