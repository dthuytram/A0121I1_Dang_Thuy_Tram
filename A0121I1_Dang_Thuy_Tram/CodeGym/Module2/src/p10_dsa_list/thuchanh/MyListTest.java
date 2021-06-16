package p10_dsa_list.thuchanh;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("element 4: "+ list.get(4));
        list.get(-1);
        System.out.println("elment 6: "+ list.get(-1));
    }
}
