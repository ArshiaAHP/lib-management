package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import javax.xml.crypto.NoSuchMechanismException;
import java.util.NoSuchElementException;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;
    private int capacity; //capacity for this queue
    public CustomQueue(int capacity) {
        list = new CustomLinkedList<>();
        this.capacity = capacity;
    }

    @Override
    public boolean add(Object t) {
        if(list.size() >= capacity){
            throw new IllegalStateException("Queue is full.");
        }
        return list.add(t);
    }

    @Override
    public boolean offer(Object t) {
        if(list.size() >= capacity){
            return false;
        }
        return list.add((t));
    }

    @Override
    public T remove() {
        if(list.isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return list.removeFirst();
    }

    @Override
    public T poll() {
        if(list.isEmpty()){
            throw new NoSuchElementException("Queue is empty.");
        }
        return list.removeFirst();
    }

    @Override
    public T element() {
        if(list.isEmpty()){
            throw new NoSuchElementException("Queue is empty.");
        }
        return list.getFirst();
    }

    @Override
    public T peek() {
        if(list.isEmpty()){
            return null;
        }
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    // TODO: Override and fill the methods to complete the data structure

}