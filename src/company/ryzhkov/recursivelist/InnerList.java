package company.ryzhkov.recursivelist;

public final class InnerList<T> extends List<T> {
    private final T head;
    private final List<T> tail;

    public InnerList(T head, List<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    public T getHead() {
        return head;
    }

    public List<T> getTail() {
        return tail;
    }
}
