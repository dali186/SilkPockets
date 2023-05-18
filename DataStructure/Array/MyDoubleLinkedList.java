package DataStucture.List;

public class MyDoubleLinkedList<T> implements MyList<T> {

    private int size = 0;
    private Node head;
    private Node tail;

    public MyDoubleLinkedList() {
        this.size = 0;
        this.head = new Node(null);
        this.tail = new Node(null);
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    @Override
    public void add(T t) {
        Node last = this.tail.pre;
        Node node = new Node(t, last, this.tail);
        last.next = node;
        this.tail.pre = node;
        this.size++;
    }

    @Override
    public void insert(int index, T t) {
        Node node = new Node(t);
        Node cur = null;
        Node pre = null;
        int i = 0;
        if (index < this.size / 2) {
            //Head 부터 탐색
            cur = head.next;
            pre = head;
            while (i++ < index) {
                cur = cur.next;
                pre = pre.next;
            }
        } else {
            //Tail 부터 탐색
            cur = tail;
            pre = tail.pre;
            //tail 부터 시작하기 때문에 조건식에 -1을 하지 않음
            while (i++ < (this.size - index)) {
                cur = cur.pre;
                pre = pre.pre;
            }
        }
        node.pre = pre;
        node.next = cur;
        pre.next = node;
        cur.pre = node;
        this.size++;
    }

    @Override
    public void clear() {
        this.size = 0;
        this.head.next = this.tail;
        this.tail.pre = this.head;
    }

    @Override
    public boolean delete(T t) {
        Node cur = this.head.next;
        Node pre = this.tail.pre;
        int i = 0;
        while (i++ < size/2) {
            if (cur.data.equals(t)) {
                cur.pre.next = cur.next;
                cur.next.pre = cur.pre;
                cur.next = null;
                cur.pre = null;
            } else if (pre.data.equals(t)) {
                pre.pre.next = pre.next;
                pre.next.pre = pre.pre;
                pre.next = null;
                pre.pre = null;
            }
            cur = cur.next;
            pre = pre.pre;
        }
        return false;
    }

    @Override
    public boolean deleteByIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node cur = null;
        Node pre = null;
        Node next = null;
        int i = 0;
        if (index < this.size / 2) {
            //Head 부터 탐색
            cur = this.head.next;
            pre = this.head;
            while (i++ < index) {
                cur = cur.next;
                pre = pre.next;
            }
            pre.next = cur.next;
            cur.next.pre = pre;
            cur.next = null;
            cur.pre = null;
        } else {
            //Tail 부터 탐색
            cur = this.tail.pre;
            next = this.tail;
            while (i++ < (this.size - index - 1)) {
                cur = cur.pre;
                next = next.pre;
            }
            cur.pre.next = next;
            next.pre = cur.pre;
            cur.next = null;
            cur.pre = null;
        }
        this.size--;
        return true;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        Node cur = null;
        int i = 0;
        if (index < this.size / 2) {
            //Head 부터 탐색
            cur = this.head.next;
            while (i++ < index) {
                cur = cur.next;
            }
        } else {
            //tail 부터 탐색
            cur = this.tail.pre;
            while (i++ < (size - index - 1)) {
                cur = cur.pre;
            }
        }
        return cur.data;
    }

    @Override
    public int indexOf(T t) {
        Node cur = this.head.next;
        Node back = this.tail.pre;
        int index = 0;
        while (index++ < this.size / 2) {
            if (cur.data.equals(t)) {
                return index - 1;
            } else if (back.data.equals(t)) {
                return (this.size - index);
            }
            cur = cur.next;
            back = back.pre;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T t) {
        Node cur = this.head.next;
        Node back = this.tail.pre;
        int i = 0;
        while (i++ < size / 2) {
            if (cur.data.equals(t) || back.data.equals(t)) {
                return true;
            }
            cur = cur.next;
            back = back.pre;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {
        private T data;
        private Node pre;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node pre, Node next) {
            this.data = data;
            this.pre = pre;
            this.next = next;
        }

    }
}
