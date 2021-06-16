package p11_stack_queue.baitap.queueLienKetVong;

public class Node {
    int data;
    Node link;

    public Node(int data) {
        this.data = data;
        this.link = null;
    }

    public Node() {
        this.data = 0;
        this.link = null;
    }
}
