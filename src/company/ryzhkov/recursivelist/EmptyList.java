package company.ryzhkov.recursivelist;

public final class EmptyList<T> extends List<T> {
    public static EmptyList instance = new EmptyList();

    private EmptyList() {
    }
}
