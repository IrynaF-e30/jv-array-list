package core.basesyntax;

public interface List<T> {
    void add(T element);

    void add(T element, int index);

    T get(int index);

    T set(T element, int index);

    T remove(int index);

    T remove(T element);

    void addAll(List<T> list);

    int size();

    boolean isEmpty();
}

