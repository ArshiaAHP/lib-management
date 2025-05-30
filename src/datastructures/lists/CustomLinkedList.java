package datastructures.lists;
import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T>{
    @Override
    public void addFirst(T t) {
        if(t == null){
            throw new NullPointerException();
        }
        head = new Node<T>(t);
        head.next = tail;
        size++;
    }

    @Override
    public void addLast(T t) {
        if(t == null){
            throw new NullPointerException();
        }
        tail = new Node<T>(t);
        size++;
    }

    @Override
    public T removeFirst() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node<T> temp = head;
        head = head.next;
        size--;
        return temp.data;
    }

    @Override
    public T removeLast() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Node<T> temp = tail;
        tail = tail.prev;
        size--;
        return temp.data;
    }

    @Override
    public T getFirst() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return tail.data;
    }

    @Override
    public void clear() {
        head.next = null;
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        Node<T> current = head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.data;
    }



    @Override
    public Object set(int index, Object element) {
        if(element == null){
            throw new NullPointerException();
        }
        if(index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        Node<T> current = head;
        for(int i = 0;i < index; i++){
            current = current.next;
        }
        T temp = current.data;
        current.data = (T) element;
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean add(Object o) {
        if(o == null){
            throw new NullPointerException();
        }
        Node<T> newNode = new Node<T>((T) o);
        if(head == null){
            addFirst((T) o);
        }
        addLast((T) o);
        return true;
    }

    @Override
    public boolean contains(Object o) {
        Node<T> current = head;
        while(current != null){
            if(current.data.equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        Node<T> current = head;
        while(current != null){
            if(current.data.equals(o)){
                current.prev.next = current.next;
                size--;
                return true;
            }
        }
        return false;
    }

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    // TODO: Override and fill the methods to complete the data structure

}