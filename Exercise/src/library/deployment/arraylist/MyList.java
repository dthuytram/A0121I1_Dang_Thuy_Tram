package library.deployment.arraylist;

import java.util.Objects;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int size) {
        elements = new Object[size];
    }

    public void add(int index, E element) {
        if (size - index + 1 >= 0) System.arraycopy(elements, index, elements, index + 1, size - index + 1);

        elements[index] = element;

        size++;
    }

    public E remove(int index) {
        @SuppressWarnings("unchecked") E temp = (E) elements[index];

        System.arraycopy(elements, index + 1, elements, index, size - index - 1);

        size--;

        return temp;
    }

    public int size() {
        return size;
    }

    public boolean contains(E o) {
        return indexOf(o) >= 0;
    }

    public int indexOf(E o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null)
                    return i;

            }
        } else
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i]))
                    return i;
            }

        return -1;
    }

    public boolean add(E e) {
        elements[size++] = e;
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > size || minCapacity > DEFAULT_CAPACITY) {
            MyList<E> temp = new MyList<>(minCapacity);

            temp = clone();
            elements = new Object[minCapacity];

            for (int i = 0; i < size; i++) {
                elements[i] = temp.get(i);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public MyList<E> clone() {
        MyList<E> temp = new MyList<>(size);
        for (int i = 0; i < size; i++) {
            temp.add((E) elements[i]);
        }

        return temp;
    }

    @SuppressWarnings("unchecked")
    public E get(int i) {
        Objects.checkIndex(i, size);
        return (E) elements[i];
    }

    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        list.append("List (size: ").append(size()).append("){");
        for (int i = 0; i < size; i++) {
            list.append(elements[i]).append(", ");
        }
        list.append("}");
        return String.valueOf(list);
    }
}
