package company.ryzhkov.recursivelist;

import java.util.AbstractList;

public abstract class LinkedRecursiveList<T> extends AbstractList<T> {
    protected int size;

    private static final class EmptyList<T> extends LinkedRecursiveList<T> {

        private static EmptyList instance = new EmptyList();

        private EmptyList() {
            size = 0;
        }
    }

    private static final class InnerList<T> extends LinkedRecursiveList<T> {
        private final T head;
        private final LinkedRecursiveList<T> tail;

        private InnerList(T head, LinkedRecursiveList<T> tail) {
            this.head = head;
            this.tail = tail;
            size = 1 + this.tail.size;
        }
    }

    public static <T> LinkedRecursiveList<T> createEmpty() {
        return EmptyList.instance;
    }

    public static <T> LinkedRecursiveList<T> create(T el, LinkedRecursiveList<T> list) {
        return new InnerList<>(el, list);
    }

    @SafeVarargs
    public static <T> LinkedRecursiveList<T> of(T ...arr) {
        LinkedRecursiveList<T> linkedRecursiveList = LinkedRecursiveList.createEmpty();
        InnerList<T> innerList;
        for (int i = arr.length - 1; i >= 0; i--) {
            innerList = new InnerList<>(arr[i], linkedRecursiveList);
            linkedRecursiveList = innerList;
        }
        return linkedRecursiveList;
    }

    @Override
    public T get(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index >= this.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        InnerList<T> innerList = (InnerList<T>) this;
        if (index == 0) {
            return innerList.head;
        }
        return innerList.tail.get(index - 1);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(T t) {
        throw new UnsupportedOperationException();
    }
}
