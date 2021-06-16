package p10_dsa_list.baitap.arrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[]; // Mang chua cac phan tu

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Phthuc the hien suc chua cua element
     *
     * @param capacity
     */
    public MyList(int capacity) {
        if (capacity >= 0) {
            elements = new Object[capacity];
        } else {
            throw new IllegalArgumentException("capacity error" + capacity);
        }
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        size = 0;
        for (int i = 0; i < elements.length; i++) {
            elements[i] = null;
        }
    }

    /**
     * Kiem tra add 1 phan tu vao List
     *
     * @param e
     * @return
     */
    public boolean add(E e) {
        // nếu size= 5 ( có 5 phtu)
        // có length= 5 ( có thể chứa tối đa 5 phtu)
        // Phthuc ensureCapacity: tăng sức chứa lên minCapacity
        if (elements.length == size) {
            this.ensureCapacity(5);
        }
        // nếu size= 3 ( có 3 phtu)
        // có length= 5 ( có thể chứa tối đa 5 phtu)
        //
        elements[size] = e; // them phan tu vao thu size
        size++; // them so luong len 1
        return true;
    }

    /**
     * Phthuc tang kich thuoc cua List
     * <p>
     * Mục đích: Dành cho trường hợp List
     * có số phần tử bằng với số size
     * ( khi cần add phần tử vào)
     *
     * @param minCapacity
     */
    public void ensureCapacity(int minCapacity) {
        if (minCapacity >= 0) {
            int newSize = this.elements.length + minCapacity;
            elements = Arrays.copyOf(elements, newSize);
        } else {
            throw new IllegalArgumentException("capacity: " + minCapacity);
        }
    }

    public void add(E e, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (elements.length == size) {
            this.ensureCapacity(5);
        }
        if (elements[index] == null) {
            elements[index] = e;
            size++;
        } else {
            for (int i = size + 1; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = e;
            size++;
        }
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return (E) elements[i];
    }


}
