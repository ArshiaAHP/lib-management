package datastructures.stacks;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomStack<T> implements Queue<T> {
    private CustomLinkedList<T> list;
    private int capacity;
    public CustomStack(int capacity) {
        list = new CustomLinkedList<>();
        this.capacity = capacity;
    }


    @Override
    public boolean add(Object t) {
        if(list.size() >= capacity){
            throw new IllegalStateException("Stack is full");
        }
        return list.add(t);
    }

    @Override
    public boolean offer(Object t) {
        if(list.size() >= capacity){
            return false;
        }
        return list.add(t);
    }

    @Override
    public T remove() {
        if(list.isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        return list.removeLast(); //because Stack
    }

    @Override
    public T poll() {
        if(list.isEmpty()){
            return null;
        }
        return list.removeLast();
    }

    @Override
    public T element() {
        if(list.isEmpty()){
            throw new NoSuchElementException("Stack is empty");
        }
        return list.getLast();
    }

    @Override
    public T peek() {
        if(list.isEmpty()){
            return null;
        }
        return list.getLast();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }
}