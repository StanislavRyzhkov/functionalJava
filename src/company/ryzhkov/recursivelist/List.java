package company.ryzhkov.recursivelist;

import java.util.Iterator;

public abstract class List<T> implements Iterable<T> {

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
