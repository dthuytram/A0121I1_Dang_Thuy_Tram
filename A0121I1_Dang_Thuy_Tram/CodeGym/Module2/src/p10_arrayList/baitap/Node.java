package p10_arrayList.baitap;

public class Node {
    public Node next;
    public Object data;

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return this.data;
    }

    public boolean compareNode(Node node){
        return data.equals(node.getData());
    }


}
