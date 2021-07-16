package library.deployment.linkedlist;

public class Node {
     Node next;
     Object data;

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public boolean compareNode(Node node){
        return data.equals(node.getData());
    }
}
