import java.util.NoSuchElementException;
import java.util.Objects;

public class MyArrayList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public MyArrayList() {
        data = new Object[DEFAULT_CAPACITY];
    }

    public void add(T element) {
        growIfNeeded();
        data[size++] = element;
    }

    public void add(int index, T element) {
        checkAddIndex(index);
        growIfNeeded();
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) data[index];
    }

    public T set(int index, T element) {
        checkIndex(index);
        T old = (T) data[index];
        data[index] = element;
        return old;
    }

    public T remove(int index) {
        checkIndex(index);
        T removed = (T) data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--size] = null;
        return removed;
    }

    public void remove(T element) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(element, data[i])) {
                remove(i);
                return;
            }
        }
        throw new NoSuchElementException("Element not found: " + element);
    }

    public int size() {
        return size;
    }

    private void growIfNeeded() {
        if (size == data.length) {
            int newSize = data.length + data.length / 2;
            Object[] newData = new Object[newSize];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayListIndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    private void checkAddIndex(int index) {
        if (index < 0 || index > size) {
            throw new ArrayListIndexOutOfBoundsException("Invalid index: " + index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}



