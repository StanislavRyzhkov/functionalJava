package company.ryzhkov.recursivelist;

import java.util.Iterator;

public abstract class List<T> implements Iterable<T> {

    private static final class EmptyList<T> extends List<T> {
        private static EmptyList instance = new EmptyList();

        private EmptyList() {
        }
    }

    public static <T> List<T> createEmpty() {
        return EmptyList.instance;
    }

    public static <T>  List<T> of(T ...arr) {
        List<T> list = List.createEmpty();
        InnerList<T> innerList = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            innerList = new InnerList<>(arr[i], list);
            list = innerList;
        }
        return list;
    }

    private static final class InnerList<T> extends List<T> {
        private final T head;
        private final List<T> tail;

        public InnerList(T head, List<T> tail) {
            this.head = head;
            this.tail = tail;
        }

        private T getHead() {
            return head;
        }

        private List<T> getTail() {
            return tail;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            List<T> cursor = List.this;

            @Override
            public boolean hasNext() {
                return !(cursor instanceof EmptyList);
            }

            @Override
            public T next() {
                if (cursor instanceof EmptyList) {
                    throw new IllegalStateException();
                }
                InnerList<T> innerList = (InnerList<T>) cursor;
                T head = innerList.getHead();
                cursor = innerList.getTail();
                return head;
            }
        };
    }
}
