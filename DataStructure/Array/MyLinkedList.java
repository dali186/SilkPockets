package DataStucture.List;

public class MyLinkedList<T> implements MyList<T>{
    //간결하게 작성하기 위해 HEAD를 비워놓고 구현, HEAD를 더미노드라고 표현

    private int size;
    private Node head;

    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(null); // dummy head node
    }

    @Override
    public void add(T t) {
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        Node node = new Node(t);
        current.next = node;
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node pre = this.head;
        Node cur = pre.next;

        int i = 0;
        while (i++ < index) {
            pre = pre.next;
            cur = cur.next;
        }

        Node node = new Node(t, cur);
        pre.next = node;
        this.size++;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = null;
    }

    @Override
    public boolean delete(T t) {
        Node pre = this.head;
        Node cur = pre.next;
        while (cur.next != null) {
            if (cur.data.equals(t)) {
                pre.next = cur.next;
                cur.next = null;        //더 이상 노드를 가리키지 못하게 만든다 ( 삭제 )
                this.size--;
                return true;
            }
            pre = pre.next;         //반복할라믄 자꾸 값을 넣어줘야한다
            cur = cur.next;
        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node pre = this.head;
        Node cur = pre.next;
        int i = 0;
        while (i++ < index) {
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = cur.next;
        cur.next = null;
        this.size--;
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException();
        }
        Node cur = this.head.next;
        int i = 0;
        while (i++ < index) {
            cur = cur.next;
        }
        return cur.data;
    }

    @Override
    public int indexOf(T t) {
        Node cur = this.head.next;
        int index = 0;
        while (cur != null) {
            if (cur.data.equals(t)){
                return index;
            }
            cur = cur.next;
            index++;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return this.head.next == null;
    }

    @Override
    public boolean contains(T t) {
        Node cur = this.head.next;
        while (cur != null) {
            if (cur.data.equals(t)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
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
