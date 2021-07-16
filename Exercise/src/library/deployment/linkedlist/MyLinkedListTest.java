package library.deployment.linkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();

        list.add("Hello");
        list.add("World");
        System.out.println(list.toString());

        list.addFirst("I");
        list.add(1,"am");
        list.addLast("Goodbye");
        System.out.println(list.toString());

        list.remove(3);
        list.remove("World");
        System.out.println(list.toString());

        System.out.println(list.getFirst() + " " + list.getLast());

        System.out.println("Contain Hello: " + list.contains("Hello"));

        System.out.println("Index of am: " + list.indexOf("am"));
    }
}
