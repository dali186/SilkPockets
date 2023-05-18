package DataStucture.List;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T>{

    private static final int DEFAULT_SIZE = 50;
    private T[] elements;
    private int size;

    public MyArrayList() {
        this.elements = (T[])new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    @Override
    public void add(T t) {
        if(this.elements.length == this.size) {
            this.elements = Arrays.copyOf(this.elements, size * 2);
        }
        this.elements[size++] = t;
    }

    @Override
    public void insert(int index, T t) {
        if(this.elements.length == this.size) {
            this.elements = Arrays.copyOf(this.elements, this.size * 2);
        }
        for(int i = index; i < this.elements.length; i++) {
            this.elements[i + 1] = this.elements[i];
        }
        this.elements[index] = t;
        this.size++;
    }

    @Override
    public void clear() {
        this.elements = (T[]) new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    @Override
    public boolean delete(T t) {
        for (int i = 0; i < this.size; i++) {
            if(this.elements[i].equals(t)) {
                for (int j = i; j < this.size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                this.size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        if(index < 0 || index > this.size - 1) return false;
        for (int i = index; i < this.size - 1; i++) {
            this.elements[i] = this.elements[i + 1];
            return true;
        }
        this.size--;
        return false;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index > this.size -1) {
            throw new IndexOutOfBoundsException();
        }

        return this.elements[index];
    }

    @Override
    public int indexOf(T t) {
        for (int i = 0; i < this.size; i++) {
            if(this.elements[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(T t) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals(t)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
}
