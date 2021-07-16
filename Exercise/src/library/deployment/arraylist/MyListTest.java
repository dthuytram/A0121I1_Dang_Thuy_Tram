package library.deployment.arraylist;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> strings = new MyList<>();

        System.out.println("\tTest Add");
        strings.add("One");
        strings.add("True");
        strings.add(1,"Three");
        strings.add("Four");

        System.out.println(strings.toString());

        System.out.println("\tTest Remove");
        System.out.println("Remove: " + strings.remove(1));
        System.out.println(strings.toString());

//        strings.add(2,"Three");
//        strings.ensureCapacity(20);
////        strings.add(20,"Error");
//        System.out.println(strings.toString());

        System.out.println("\tTest Clone");
        MyList<String> string2 = strings.clone();
        System.out.println("String2: " + string2.toString());

    }
}
