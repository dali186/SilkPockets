package DataStucture.Stack;

public interface MyStackInterface<T> {
    void push(T data);
    T pop();
    T peek();
    int size();
}
