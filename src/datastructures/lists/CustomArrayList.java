package datastructures.lists;

import datastructures.interfaces.List;

import java.util.Arrays;
import java.util.Objects;

public class CustomArrayList<T> implements List<T> {
    private static final int INITIAL_CAPACITY = 10;
    private Object[] elements;
    private int size = 0;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    @Override
    public T set(int index, T element) {
        if(index < 0 || index > size - 1){
            throw new IndexOutOfBoundsException();
        }
        Object temp = elements[index];
        elements[index] = element;
        return (T) temp;
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
        ensureCapacity();
        elements[size] = o;
        size++;
        return true;
    }

    @Override
    public boolean contains(Object o) {
        for(Object obj : elements){
            if(obj.equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        if(o == null){
            throw new NullPointerException();
        }
        int i = 0; //for counting the index in loop.
        for(Object obj : elements){
            if(obj.equals(o)){
                for(int j = i; j< size - 1; j++){
                    elements[j] = elements[j+1];
                }
                return true;
            }
            i++;
        }
        return false;
    }
}