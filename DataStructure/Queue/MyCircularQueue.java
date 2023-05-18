package DataStucture.Queue;

public class MyCircularQueue<T> implements MyQueue<T> {

    private T[] elements;
    private int front;
    private int rear;
    private int maxSize;

    public MyCircularQueue(int size) {
        this.elements = (T[]) new Object[size + 1]; //size + 1 은 더미공간을 만들어주기 위함
        this.front = 0;
        this.rear = 0;
        this.maxSize = size + 1;
    }

    @Override
    public void offer(T data) {
        if (this.isFull()) throw new IllegalStateException();

        this.rear = (this.rear + 1) % this.maxSize;
        this.elements[this.rear] = data;
    }

    @Override
    public T poll() {
        if (this.isEmpty()) throw new IllegalStateException();

        this.front = (this.front + 1) % this.maxSize;
        return this.elements[this.front];
    }
    //굳이 null로 삭제를 안해도 된다. 왜냐, front와 rear의 값으로 지정하기 때문에 값을 넣을 때 rear의 값으로 덮어 씌우면 되기 때문
    //뺀다고 index를 -1 하는게 아님, 어차피 한 방향으로 돌기 때문에 + 1

    @Override
    public T peek() {
        if (this.isEmpty()) throw new IllegalStateException();

        return this.elements[this.front + 1];
    }

    @Override
    public int size() {
        if (this.front <= this.rear) return this.rear - this.front;

        return maxSize - this.front + this.rear;
    }

    @Override
    public void clear() {
         this.front = 0;
         this.rear = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    private boolean isFull() {
        return (this.rear + 1) % this.maxSize == this.front;
    }
}
