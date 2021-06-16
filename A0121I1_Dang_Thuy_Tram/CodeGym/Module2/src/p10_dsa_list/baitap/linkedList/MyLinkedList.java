package p10_dsa_list.baitap.linkedList;

import p10_dsa_list.baitap.Node;

/**
 * Phan dac ta o package arrayList.thuchanh.MyLinkedList;
 */
public class MyLinkedList<E> {

    // khoi tao Node
    private Node head;

    public int getNumNodes() {
        return numNodes;
    }

    public void setNumNodes(int numNodes) {
        this.numNodes = numNodes;
    }

    private int numNodes;
    Object e;

    public MyLinkedList() {
    }

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    // lien ket den Node


    public void addFirst(E element) {
        /**
         * Khai báo 1 biến là temp
         * trỏ đến gá trị của head
         */
        Node temp = head;
        // head nhận giá trị 1 node mới
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E data) {
        if (head == null) {
            addFirst(data);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new Node(data);
            numNodes++;
        }
    }
    //==========
    // Phương thức add với index

    public void add(int index, E data) {
        if (index == 0) {
            addFirst(data);
        } else if (index >= numNodes) {
            addLast(data);
        } else {
            // Khai báo biến temp đến head
            Node temp = head;

            // Khai báo 1 node là holder
            Node holder;

            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            holder = temp.next;
            temp.next = new Node(data);
            temp.next.next = holder;
            numNodes++;
        }
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    //======DELETE FUNCTION

    public void clear() {
        head = null;
        numNodes = 0;
    }

    //----
    public void remove(int index) {
        Node before = head;
        Node after = before.next;
        for (int i = 0; i < index - 1; i++) {
            before = after;
        }

        after = after.next;
        numNodes--;
    }

    public boolean remove(E e) {
        if (contains(e)) {
            remove(indexOf(e));
            return true;
        }

        return false;
    }

    /**
     * PrintList
     */
    public int size() {
        return numNodes;
    }


    @SuppressWarnings("unchecked")
    public Object clone() {
        MyLinkedList<Object> clone = new MyLinkedList<>();

        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            clone.addLast((Object) temp.getData());
        }

        return clone;
    }


    @SuppressWarnings("unchecked")
    public Object get(int i) {
        if (i >= numNodes)
            throw new IndexOutOfBoundsException();
        else if (i == 0) {
            return getFirst();
        } else if (i == numNodes - 1) {
            return getLast();
        } else {
            Node temp = head;
            for (int j = 0; j < i; j++) {
                temp = temp.next;
            }
            return (Object) temp.getData();
        }
    }

    @SuppressWarnings("unchecked")
    public Object getFirst() {
        return (Object) head.getData();
    }

    @SuppressWarnings("unchecked")
    public Object getLast() {
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++) {
            temp = temp.next;
        }

        return (Object) temp.getData();
    }


    public boolean contains(E e) {
        Node temp = head;

        while (temp.next != null) {
            if (temp.getData().equals(e))
                return true;
            temp = temp.next;
        }

        return false;
    }

    public int indexOf(E e) {
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(e))
                return i;
            temp = temp.next;
        }

        return -1;
    }

    public boolean compareList(MyLinkedList<E> list) {
        if (size() != list.size()) {
            return false;
        } else {
            Node node1 = head;
            Node node2 = list.head;
            while (node1 != null) {
                if (!node1.compareNode(node2)) {
                    return false;
                }
                node1 = node1.next;
                node2 = node2.next;
            }
        }
        return true;
    }

    // truyen String truc tiep vao
    // sử dụng khi k có đối tượng dc thay thế
    public String toString() {
        StringBuilder str = new StringBuilder("List (size: " + numNodes + "){");
        Node temp = head;
        for (int i = 0; i < numNodes - 1; i++) {
            str.append(temp.getData()).append(", ");
            temp = temp.next;
        }
        str.append(temp.getData()).append("}");
        return String.valueOf(str);

    }
}
