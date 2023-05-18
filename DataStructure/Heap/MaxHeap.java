package DataStucture.Heap;

public class MaxHeap <T extends Comparable<T>> implements  MyHeap<T>{

    T[] data;
    int size;
    int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.data = (T[]) new Comparable[maxSize + 1];
        this.size = 0;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private int leftChild(int pos) {
        return pos * 2;
    }

    private int rightChild(int pos) {
        return (pos * 2) + 1;
    }

    private boolean isLeaf(int pos) {
        return (pos > (size / 2) && pos <= size);
    }

    @Override
    public void insert(T val) {
        this.data[++this.size] = val;

        int current = this.size;
        while (this.data[parent(current)] != null && this.data[current].compareTo(this.data[parent(current)]) > 0) {

        }
    }

    @Override
    public boolean contains(T val) {
        return false;
    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
