package DataStucture.Stack;

import DataStucture.List.MyLinkedList;

public class MyStack<T> implements MyStackInterface<T> {

    private int size;
    private Node head;

    public MyStack() {
        this.size = size();
        this.head = new Node(null);
    }

    @Override
    public void push(T data) {
        Node node = new Node(data, this.head.next);
        this.head.next = node;
        this.size++;

    }

    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        Node cur = this.head.next;
        this.head.next = cur.next;
        cur.next = null;
        this.size--;
        return cur.data;
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            return null;
        }
        return this.head.next.data;
    }

    private boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public int size() {
        return this.size;
    }

    private class Node {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
        }

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
