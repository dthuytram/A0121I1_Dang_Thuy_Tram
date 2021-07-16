package library.deployment.linkedlist;

public class CompareList {
    public static void main(String[] args) {
        MyLinkedList<Integer> list1 = new MyLinkedList<>();

        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);

        MyLinkedList<Integer> list2 = new MyLinkedList<>();

        list2.add(1);
        list2.add(4);
        list2.add(3);
        list2.add(4);
//        list2.add(5);


        System.out.println(list1.compareTo(list2));
    }
}
